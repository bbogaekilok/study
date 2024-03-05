package com.hecto.hectobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class HectoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HectoBackendApplication.class, args);
	}

}
