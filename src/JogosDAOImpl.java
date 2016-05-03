import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogosDAOImpl implements IJogosDAO {

	@Override
	public void adicionar(Jogo j) throws JogosDAOException {
		String sql = "insert into jogos(id, nome, lancamento, preco) values (? ,? , ? , ?);";
		try {
			Connection con = DBResourceManager.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, j.getId());
			stmt.setString(2, j.getNome());
			java.sql.Date sd = new java.sql.Date(j.getLancamento().getTime());
			stmt.setDate(3, sd);
			stmt.setFloat(4, j.getPreço());

			stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new JogosDAOException(e);
		} catch (SQLException e) {
			throw new JogosDAOException(e);
		}
	}

	@Override
	public void atualizar(Jogo j) throws JogosDAOException {

		java.sql.Date sd = new java.sql.Date(j.getLancamento().getTime());
		String sql = "update jogos set nome = ?, lancamento = ?, preco = ? where id = ?;";
		try {
			Connection con = DBResourceManager.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, j.getNome());
			stmt.setDate(2, sd);
			stmt.setFloat(3, j.getPreço());
			stmt.setInt(4, j.getId());
			int linhas = stmt.executeUpdate();

			if (linhas == 1) {
				System.out.println("Jogo atualizado com sucesso");
			} else {
				System.out.println("Erro ao atualizar o jogo");
			}
		} catch (SQLException e) {
			throw new JogosDAOException(e);
		} catch (ClassNotFoundException e) {
			throw new JogosDAOException(e);
		}
	}

	@Override
	public void remover(int id) throws JogosDAOException {
		String sql = "delete from jogos where id = ?;";
		try {
			Connection con = DBResourceManager.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			int linhas = stmt.executeUpdate();

			if (linhas == 1) {
				System.out.println("Jogo excluido com sucesso");
			} else {
				System.out.println("Erro ao excluir o jogo");
			}
		} catch (ClassNotFoundException e) {
			throw new JogosDAOException(e);
		} catch (SQLException e) {
			throw new JogosDAOException(e);
		}
		
	}

	@Override
	public List<Jogo> pesquisar(String nome) throws JogosDAOException {
		List<Jogo> jogos = new ArrayList<Jogo>();
		String sql = "SELECT * FROM jogos WHERE nome like ?";
		try {
			Connection con = DBResourceManager.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			jogos.clear();
			while (rs.next()) { // testa se pegou alguma informação
				Jogo j = new Jogo();
				j.setId(rs.getInt("id"));
				j.setNome(rs.getString("nome"));
				j.setLancamento(rs.getDate("lancamento"));
				j.setPreço(rs.getFloat("preco"));
				jogos.add(j);
			}
		} catch (SQLException e) {
			throw new JogosDAOException(e);		
		} catch (ClassNotFoundException e) {
			throw new JogosDAOException(e);
		}
		return jogos;
	}

}
