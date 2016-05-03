package root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EscolaSambaDAO {
	
	private Connection con;
	
	public Connection getConnection() throws SQLException{
		if(con == null || con.isClosed()){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CARNAVAL","root","aluno");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public boolean adicionar(EscolaSamba escola) throws SQLException{
		String sql = "INSERT INTO ESCOLAS(ID,NOME,NUMALAS,QTDCOMPONENTES,TOTALPONTOS,APRESENTACAO) VALUES "
				+ "(?,?,?,?,?,?)";
		PreparedStatement pS;
		getConnection();
		pS = con.prepareStatement(sql);
		pS.setInt(1, escola.getId());
		pS.setString(2, escola.getNome());
		pS.setInt(3, escola.getNumeroAlas());
		pS.setInt(4, escola.getQtdComponentes());
		pS.setFloat(5, escola.getTotalPontos());
		java.sql.Date date = new java.sql.Date(escola.getApresentacao().getTime());
		pS.setDate(6, date);
		pS.execute();
		pS.close();
		return true;
	}
	public List<EscolaSamba> pesquisar(String nome) throws SQLException{
		List<EscolaSamba> lista = new ArrayList<EscolaSamba>();
		getConnection();
		String sql = "SELECT * FROM ESCOLAS WHERE NOME LIKE '%?%'";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, nome);
		ResultSet result = pS.executeQuery();
		while(result.next()){	
			EscolaSamba escola = new EscolaSamba();
			escola.setId(result.getInt("ID"));
			escola.setNome(result.getString("NOME"));
			escola.setNumeroAlas(result.getInt("NUMALAS"));
			escola.setQtdComponentes(result.getInt("QTDCOMPONENTES"));
			escola.setTotalPontos(result.getFloat("TOTALPONTOS"));
			Date dHelper = new Date(result.getDate("APRESENTACAO").getTime());
			escola.setApresentacao(dHelper);
		}
		result.close();
		pS.close();
		return lista;
	}
	public boolean excluir(int id) throws SQLException{
		String sql = "DELETE FROM ESCOLA WHERE ID=?";
		getConnection();
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setInt(1, id);
		pS.execute();
		return true;
	}
}	
