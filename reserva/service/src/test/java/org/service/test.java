package org.service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.dao.PersonaDao;
import org.entities.Persona;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import junit.framework.TestCase;

public class test extends TestCase {
	private PersonaDao dao;
	private SqlMapClient sql;
	static Logger logger = Logger.getLogger(test.class);
	
	protected void setUp() throws Exception {
		super.setUp();
		dao = new PersonaDao();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddUser() {
	
		Persona user = new Persona();
		user.setApellido("henriquez");
		user.setCelular(56476419);
		user.setCorreo("geral.henriquez2011@gmail.com");
		user.setDireccion("casa");
		user.setEdad(25);
		logger.debug("Log4j appender configuration is successful !!");
		dao.addUser(user);
		
	}
	public void testGetUserById() {
		fail("Not yet implemented");
	}

	public void testDeleteUserById() {
		fail("Not yet implemented");
	}

}
