/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.springTA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(String name, Integer age) {
		jdbcTemplate.update("insert into test (name,age,input_time) values (?, ?,now())", name, age);
	}
}
