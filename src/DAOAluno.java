import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOAluno {
	private Connection con;
	public DAOAluno(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunos","root","1408");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void add(Aluno a){
		String sql = "insert into aluno(ra, nome, idade, nascimento) values (? ,? , ? , ?);";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, a.getRa());
			stmt.setString(2, a.getNome());
			stmt.setInt(3, a.getIdade());
			java.sql.Date sd = new java.sql.Date( a.getNascimento().getTime());
			stmt.setDate(4, sd);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rem(String ra){
		String sql = "delete from aluno where ra = "+ra +";";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			int linhas = stmt.executeUpdate();
			
			if(linhas == 1){
				System.out.println("Aluno excluido com sucesso");
			}
			else{
				System.out.println("Erro ao excluir o Aluno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Aluno a){
		java.sql.Date sd = new java.sql.Date( a.getNascimento().getTime());
		String sql = "update aluno set nome = '" +a.getNome()+"', nascimento = '"+sd+"', idade = "+a.getIdade()+" where ra = "+a.getRa()+";";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			int linhas = stmt.executeUpdate();
			
			if(linhas == 1){
				System.out.println("Jogo atualizado com sucesso");
			}
			else{
				System.out.println("Erro ao atualizar o jogo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public List<Aluno> pesquisar(String text) {
		String sql = "SELECT * FROM aluno WHERE nome like ?";
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+text+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){ 
				Aluno a = new Aluno();				
				a.setRa(rs.getString("ra"));
				a.setNome(rs.getString("nome"));
				a.setIdade(rs.getInt("idade"));
				a.setNascimento(rs.getDate("nascimento"));
				alunos.add(a);
			}
			return alunos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Aluno>();
	}
}
