package DAO;

import java.sql.SQLException;
import java.util.List;

import Entity.Curso;

public interface iCursoDAO {
	public void adicionar(Curso c) throws  SQLException;
	public void remover(Curso c) throws  SQLException;
	public void alterar(Curso c) throws SQLException;
	public List<Curso> pesquisar(String nome) throws  SQLException;
}
