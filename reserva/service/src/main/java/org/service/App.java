package org.service;

import org.apache.log4j.Logger;
import org.dao.PersonaDao;

/**
 * Hello world!
 *
 */
public class App 
{   
	//Se carga logger
	private static Logger log = Logger.getLogger(App.class);
	protected PersonaDao dao;
	
	public App() {
		try {
			dao= new PersonaDao();
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
