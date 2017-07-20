/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.springTA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration
@SpringBootApplication
public class StartSpringTA {
	@RequestMapping("/")
	String home() {
		return "Hello   World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartSpringTA.class, args);
	}
}
