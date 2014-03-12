package org.dao;

import java.io.Reader;
import java.sql.SQLException;

import org.entities.Persona;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class PersonaDao {
	
	protected static SqlMapClient sqlMap;

	static {
		try {
			//se genera lectura de archivo xml con conexion a base de datos
			String resource="ibatis-config/sql-map-config.xml";
		    Reader reader = Resources.getResourceAsReader(resource);
		    sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		    
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Persona addUser(Persona user, SqlMapClient sqlMapClient){
		
		try {
			sqlMapClient.insert("user.addUser",user);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;				
	}
	public Persona getUserById(int id,SqlMapClient sqlMapClient){
		
		try {
			Persona user= (Persona)sqlMapClient.queryForObject("user.getUserById",id);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void deleteUserById(int id,SqlMapClient sqlMapClient){
		
		try {
			Persona user= (Persona)sqlMapClient.queryForObject("user.deleteUserById",id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	
}
