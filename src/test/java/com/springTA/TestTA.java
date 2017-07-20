/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.springTA;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springTA.service.JdbcService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartSpringTA.class)
@WebAppConfiguration
public class TestTA {

	@Autowired
	private JdbcService jdbcService;

	@Test
	public void test() {
//		notOpenTAJdbc();
		openTAJdbc();
	}

	private void notOpenTAJdbc() {
		jdbcService.jdbc();
	}

	private void openTAJdbc() {
		jdbcService.jdbcOpenTA();
	}

}
