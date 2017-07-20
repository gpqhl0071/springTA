/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.springTA.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springTA.dao.TestDao;

@Service
public class TestService {
	@Autowired
	private TestDao testDao;

	public String test() {
		Random r = new Random();
		int a = r.nextInt(100);
		testDao.save("test" + a, a);
		return "SUCCESS";
	}
}
