package root;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private Connection c;
	
	public DAO(){
		c = new ResourceManager().getConnection();
	}
	
	public String pesquisar(User user){
		if(!nome(user)){
			return "Usuario informado não existe";
		}
		else if(!senha(user)){
			return "Senha incorreta";
		}
		return "Logado";
	}
	
	public boolean nome(User user){
		String sql = "SELECT nome FROM tbl_usuarios WHERE nome = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean senha(User user){
		String sql = "SELECT nome, password FROM tbl_usuarios WHERE nome = ? AND password = ?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getSenha());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}