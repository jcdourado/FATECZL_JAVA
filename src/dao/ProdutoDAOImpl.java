package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Categoria;
import model.Produto;

public class ProdutoDAOImpl implements iProdutoDAO {

	@Override
	public void inserir(Produto p) throws SQLException, ClassNotFoundException {
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO produtos (nome, descricao, foto, preco, unidMedida, medida, idCategoria, cidade, estado, paisOrigem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement( sql );
		pstmt.setString(1, p.getNome());
		pstmt.setString(2, p.getDescricao());
		pstmt.setString(3, p.getFoto());
		pstmt.setFloat(4, p.getPreco());
		pstmt.setString(5, p.getUnidMedida());
		pstmt.setFloat(6, p.getMedida());
		pstmt.setInt(7, p.getCategoria().getId());
		pstmt.setString(8, p.getCidade());
		pstmt.setString(9, p.getEstado());
		pstmt.setString(10, p.getPaisOrigem());
		pstmt.execute();		
	}
	@Override
	public Produto pesquisarPorId(long id) throws SQLException, ClassNotFoundException {
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM produtos WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement( sql );
		pstmt.setLong(1,  id);
		ResultSet rs = pstmt.executeQuery();
		Produto p = null;
		if (rs.next()) { 
			p = new Produto();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setDescricao(rs.getString("descricao"));
			p.setFoto(rs.getString("foto"));
			p.setUnidMedida(rs.getString("unidMedida"));
			p.setMedida(rs.getFloat("medida"));
			p.setCategoria(new Categoria());
			p.setCidade(rs.getString("cidade"));
			p.setEstado(rs.getString("estado"));
			p.setPaisOrigem(rs.getString("paisOrigem"));
			p.setPreco(rs.getFloat("preco"));
			
		}
		return p;
	}
}
