package com.dh.holamundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HolamundoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolamundoApplication.class, args);

	}

	@GetMapping("/hola")
	public String holaMundo(){
		return "Hola mundo desde Springboot";
	}

	@GetMapping("/chau")
	public String byeMundo(){
		return "Adios usuario";
	}

}
