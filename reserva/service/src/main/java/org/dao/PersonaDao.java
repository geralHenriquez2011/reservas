package org.dao;

import java.io.Reader;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.entities.Persona;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class PersonaDao {
	
	protected static SqlMapClient sqlMap;
	//configuracion de log4j
	static final Logger logger = Logger.getLogger(PersonaDao.class);
	
	static {
		try {
			//se genera lectura de archivo xml con conexion a base de datos
			String resource="ibatis-config/sql-map-config.xml";
		    Reader reader = Resources.getResourceAsReader(resource);
		    sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		    //Toma la configuracion desde el archivo log4g.properties
		    BasicConfigurator.configure();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Persona addUser(Persona user){
		
		try {
			logger.debug("Llamada para generar nuevo usuario");
			sqlMap.insert("addUser",user);
			logger.debug("Usuario creado");
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Error: ",e);
			e.printStackTrace();
		}
		
		return null;				
	}
	public Persona getUserById(int id){
		
		try {
			Persona user= (Persona)sqlMap.queryForObject("getUserById",id);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void deleteUserById(int id){
		
		try {
			Persona user= (Persona)sqlMap.queryForObject("deleteUserById",id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	
}
