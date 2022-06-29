package com.uca.project.controller;

import com.uca.project.configurations.JwtTokenUtil;
import com.uca.project.model.*;
import com.uca.project.modelDTO.AuthDTO;
import com.uca.project.modelDTO.UserDTO;
import com.uca.project.repository.*;
import com.uca.project.service.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    AdoptRepository adoptRepository;
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired @Lazy
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping(value={"/registry"})
    Map<String, String> registry(@RequestBody UserDTO userDTO){
        Map<String, String> ans = new HashMap<>();
        User newUser = new User();
        newUser.setNameUser(userDTO.getNameUser());
        newUser.setAddress(userDTO.getAddress());
        newUser.setAge(userDTO.getAge());
        newUser.setDescription(userDTO.getDescription());
        newUser.setEmail(userDTO.getEmail());
        newUser.setDepartment(userDTO.getDepartment());
        newUser.setPhone(Integer.valueOf(userDTO.getPhone()));
        newUser.setPicture(userDTO.getPicture());
        newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        userRepository.save(newUser);
        Adopter adopterProfile = new Adopter();
        adopterProfile.setUser(newUser);
        adoptRepository.save(adopterProfile);
        Owner ownerProfile = new Owner();
        ownerProfile.setUser(newUser);
        ownerRepository.save(ownerProfile);
        ans.put("message", "Successful registration");
        return ans;
    }
    @PostMapping(value={"/login"})
    ResponseEntity<?> login(@RequestBody AuthDTO auth) throws Exception{
        authenticate(auth.getUsername(), auth.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getUsername());
        User userCredential = userDetailsService.loadUserByUsernameAll(auth.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, userCredential.getIdUser());

        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, password);
            User userCredential = userDetailsService.loadUserByUsernameAll(user.getPrincipal().toString());
            if (!bcryptEncoder.matches(password,userCredential.getPassword().replaceAll("\\s+",""))){
                throw new BadCredentialsException("Error-credentials");
            }
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
