package com.uca.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.uca.project.repository", "com.uca.project.controller", "com.uca.project.configurations", "com.uca.project.service"})
public class HuellitasUcaApplication {
	public static void main(String[] args) {
		SpringApplication.run(HuellitasUcaApplication.class, args);
	}

}
