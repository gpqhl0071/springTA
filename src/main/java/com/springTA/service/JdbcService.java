/*
*Copyright (c) 2016, gp.inc and/or its affiliates. All rights reserved.
*/
package com.springTA.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class JdbcService {

	/**
	 * 未开启事务
	 * 
	 * @author: gao peng @param: @return: void @throws
	 */
	public void jdbc() {
		Connection con = null; // 定义一个MYSQL链接对象
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // MYSQL驱动
			con = DriverManager.getConnection("jdbc:mysql://192.168.146.129:3306/gp", "root", "123456"); // 链接本地MYSQL

			Statement stmt; // 创建声明
			stmt = con.createStatement();

			stmt.executeUpdate("insert into test (name,age,input_time) values ('zzz', '1',now())");
			stmt.executeUpdate("insert into test (name,age,input_time) values ('zzz', '2',now())");

			int i = 1 / 0;

			stmt.executeUpdate("insert into test (name,age,input_time) values ('zzz', '3',now())");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con == null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 开启事务
	 * 
	 * @author: gao peng @param: @return: void @throws
	 */
	public void jdbcOpenTA() {
		Connection con = null; // 定义一个MYSQL链接对象
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // MYSQL驱动
			con = DriverManager.getConnection("jdbc:mysql://192.168.146.129:3306/gp", "root", "123456"); // 链接本地MYSQL

			Statement stmt; // 创建声明
			stmt = con.createStatement();

			// 关闭自动提交开启事务
			con.setAutoCommit(false);

			stmt.executeUpdate("insert into test (name,age,input_time) values ('zzz', '1',now())");
			stmt.executeUpdate("insert into test (name,age,input_time) values ('zzz', '2',now())");

			int i = 1 / 0;

			stmt.executeUpdate("insert into test (name,age,input_time) values ('zzz', '3',now())");

			con.commit();

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (con == null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
