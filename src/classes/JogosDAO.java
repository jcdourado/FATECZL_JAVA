package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JogosDAO {
	
	public void adicionar(Jogo j) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO JOGOS(nome, dificuldade) VALUES (?, ?)";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, j.getNome());
		pS.setInt(2, j.getDificuldade());
		pS.execute();
	}
	
	public Jogo pesquisar(String nome) throws SQLException, ClassNotFoundException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM JOGOS WHERE NOME LIKE ?";
		PreparedStatement Ps = con.prepareStatement(sql);
		Ps.setString(1, "%"+nome+"%");
		Jogo j = new Jogo();
		j.setNome("");
		j.setDificuldade(1);
		ResultSet rS = Ps.executeQuery();
		if(rS.next()){
			j.setNome(rS.getString("nome"));
			j.setDificuldade(rS.getInt("dificuldade"));
		}
		return j;
	}
}
