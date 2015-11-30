package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Curso;

public class CursoDAO implements iCursoDAO{
	private Connection con;
	
	public CursoDAO() throws ClassNotFoundException, SQLException {
		con = ResourceManager.getResource().getC();
	}
	
	@Override
	public void adicionar(Curso c) throws SQLException {
		String sql = "insert into curso(id, nome, descricao, ativo, horarioinicio, horariotermino) values (? ,? , ? , ?,? ,?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, c.getId());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getDescricao());
			stmt.setBoolean(4, c.isAtivo());
			java.sql.Date sd = new java.sql.Date( c.getHorarioInicio().getTime());
			stmt.setDate(5, sd);
			java.sql.Date sd2 = new java.sql.Date( c.getHorarioTermino().getTime());
			stmt.setDate(6, sd2);		
			stmt.executeUpdate();
	}

	@Override
	public void remover(Curso c) throws SQLException {
		String sql = "delete from curso where id = "+c.getId() +";";
			PreparedStatement stmt = con.prepareStatement(sql);
			int linhas = stmt.executeUpdate();
			
			if(linhas == 1){
				System.out.println("Curso excluido com sucesso");
			}
			else{
				System.out.println("Erro ao excluir o curso");
			}
	}

	@Override
	public void alterar(Curso c) throws SQLException {
		String sql = "update curso set nome = ?, descricao = ?, ativo = ?, horarioinicio = ?, horariotermino = ? where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			java.sql.Date sd = new java.sql.Date(c.getHorarioInicio().getTime());
			java.sql.Date sd2 = new java.sql.Date(c.getHorarioTermino().getTime());
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getDescricao());
			stmt.setBoolean(3, c.isAtivo());
			stmt.setDate(4,sd);
			stmt.setDate(5,sd2);
			stmt.setLong(6,c.getId());
			
			int linhas = stmt.executeUpdate();
			
			if(linhas == 1){
				System.out.println("Curso atualizado com sucesso");
			}
			else{
				System.out.println("Erro ao atualizar o curso");
			}
	}

	@Override
	public List<Curso> pesquisar(String nome) throws SQLException {
		String sql = "SELECT * FROM curso WHERE nome like '%"+nome+"%'";
		List<Curso> cursos = new ArrayList<Curso>();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){ 
				Curso c = new Curso();				
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setDescricao(rs.getString("descricao"));
				c.setAtivo(rs.getBoolean("ativo"));
				c.setHorarioInicio(rs.getDate("horarioinicio"));
				c.setHorarioTermino(rs.getDate("horariotermino"));
				cursos.add(c);
			}
		return cursos;
	}
}
