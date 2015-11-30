package Controller;

import java.sql.SQLException;
import java.util.List;

import DAO.CursoDAO;
import DAO.iCursoDAO;
import Entity.Curso;

public class ControllerAluno {
	private iCursoDAO dao;
	
	public ControllerAluno() throws ClassNotFoundException, SQLException{
		dao = new CursoDAO();
	}
	public List<Curso>  adicionar(Curso c) throws SQLException{
		dao.adicionar(c);
		Curso c1 = new Curso();
		c1.setNome("");
		return(pesquisar(c1));
		}
	public List<Curso>  atualizar(Curso c) throws SQLException{
		dao.alterar(c);
		Curso c1 = new Curso();
		c1.setNome("");
		return(pesquisar(c1));
	}	
	public List<Curso>  remover(Curso c) throws SQLException{
		dao.remover(c);
		Curso c1 = new Curso();
		c1.setNome("");
		return(pesquisar(c1));
	}
	public List<Curso> pesquisar(Curso c) throws SQLException{
		return (dao.pesquisar(c.getNome()));
	}
}
