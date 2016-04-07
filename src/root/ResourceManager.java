package root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResourceManager {
		private Connection c;
		
		public ResourceManager(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","1408");
				System.out.println(c.isClosed());
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFound");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("SQLException");
				e.printStackTrace();
			}
		}
			
		public Connection getConnection(){
			return c;
		}
	}
