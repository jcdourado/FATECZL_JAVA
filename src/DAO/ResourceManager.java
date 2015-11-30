package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResourceManager {
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/cursos";
	private final static String USER = "root";
	private final static String PASSWORD = "1408";
	private Connection c;
	private static ResourceManager instancia;
	
	private ResourceManager() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		c = DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
	public static ResourceManager getResource() throws ClassNotFoundException, SQLException{
		if(instancia == null){
			instancia = new ResourceManager();
		}
		return instancia;
	}
	
	public Connection getC(){
		return c;
	}
}
