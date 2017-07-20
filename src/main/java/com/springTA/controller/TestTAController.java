/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.springTA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springTA.service.TestService;

@RestController
@RequestMapping("/testTAController")
public class TestTAController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "test")
	public String test() {
		return testService.test();
	}
	
}
