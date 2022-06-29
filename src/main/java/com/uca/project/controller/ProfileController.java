package com.uca.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.uca.project.model.Adopter;
import com.uca.project.model.Owner;
import com.uca.project.modelDTO.UserDTO;
import com.uca.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.uca.project.model.User;
import com.uca.project.repository.ProfileRepository;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ProfileController  {
	@Autowired
	ProfileRepository profileRepository;
	@Autowired @Lazy
	private PasswordEncoder bcryptEncoder;
	
	@RequestMapping(value = {"/findAllUsers"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody
	List<User> AllUsers(){
		List<User> profile = profileRepository.findAll();
		return profile;
	}
	@PutMapping(value = {"/modifyProfile"})
	Map<String, String> modifyProfile(@RequestBody UserDTO userDTO) throws Exception{
		Map<String, String> ans = new HashMap<>();
		User newUser = new User();
		newUser.setIdUser(userDTO.getIdUser());
		newUser.setNameUser(userDTO.getNameUser());
		newUser.setAddress(userDTO.getAddress());
		newUser.setAge(userDTO.getAge());
		newUser.setDepartment(userDTO.getDepartment());
		newUser.setDescription(userDTO.getDescription());
		newUser.setEmail(userDTO.getEmail());
		newUser.setPhone(Integer.valueOf(userDTO.getPhone()));
		newUser.setPicture(userDTO.getPicture());
		newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		profileRepository.save(newUser);
		ans.put("message", "Successful modified");
		return ans;
	}
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newProfile(@ModelAttribute("user") User profile,ModelMap map) {
		boolean error=false;
		if(profile.getNameUser()==null  || profile.getNameUser().isEmpty() ){
			map.put("nameError","Name is required it");
			error = true;
		}
		if(profile.getAge()==null){
			map.put("AgeError","Age room is required it");
			error = true;
		}
		if(profile.getAddress()==null  ||  profile.getAddress().isEmpty() ){
			map.put("AddressError","Address is required it");
			error = true;
		}
		if(profile.getPicture()==null || profile.getPicture().isEmpty()){
			map.put("PictureError","Picture is required it");
			error = true;
		}
		if(profile.getPassword()==null  ||  profile.getPassword().isEmpty() ){
			map.put("PasswordError","Password is required it");
			error = true;
		}
		if(profile.getPhone()==null ){
			map.put("PhoneError","Phone is required it");
			error = true;
		}
		if(profile.getEmail()==null  ||  profile.getEmail().isEmpty() ){
			map.put("EmailError","Email is required it");
			error = true;
		}
		if(profile.getDescription()==null || profile.getDescription().isEmpty()){
			map.put("DescriptionError","Description is required it");
			error = true;
		}
		if(!error){
			profileRepository.save(profile);
			return "success";
		}




		return "exit";
	}
	@RequestMapping(value = "/deleteProfile", method = RequestMethod.DELETE)
	public @ResponseBody
	String deleteProfile(@RequestParam Integer ID) {
		profileRepository.deleteById(ID);
		return "exit";
	}
	@GetMapping(value = {"/getProfile"})
	User getUser(@RequestParam Integer id){
		User user = profileRepository.findById(id).get();
		return user;
	}
	
}
