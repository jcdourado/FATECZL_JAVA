import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// SINGLETON, DEVE RETORNAR ELE MESMO EM ALGUM METODO E ALGUMA INFORMACAO RELEVANTE COM O 
// CONSTRUTOR PRIVADO
public class DBResourceManager {
	
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/jogo";
	private static String USER = "root";
	private static String PASSWORD = "aluno";
	private static DBResourceManager inst;
	private Connection con;
	
	private DBResourceManager() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}
	
	public static DBResourceManager getInstance() throws ClassNotFoundException, SQLException{
		if(inst==null){
			return (new DBResourceManager()); 
		}
		return inst;
	}
	
	public Connection getConnection(){
		return con;
	}
}
