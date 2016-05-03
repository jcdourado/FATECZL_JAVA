package dao;

import java.sql.SQLException;

import model.Produto;

public interface iProdutoDAO {
	public void inserir( Produto p ) throws SQLException, ClassNotFoundException;
	public Produto pesquisarPorId( long id ) throws SQLException, ClassNotFoundException;
}
