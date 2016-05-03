import java.util.List;

public interface IJogosDAO {

	public void adicionar(Jogo j) throws JogosDAOException;

	public void atualizar(Jogo j) throws JogosDAOException;

	public void remover(int id) throws JogosDAOException;

	public List<Jogo> pesquisar(String nome) throws JogosDAOException;
}
