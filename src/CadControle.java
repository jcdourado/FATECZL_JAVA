import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class CadControle implements TableModel {
	private IJogosDAO dao;
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	public CadControle(){
		dao = new JogosDAOImpl();
	}

	public void add(Jogo j) {
		try {
			dao.adicionar(j);
		} catch (JogosDAOException e) {
			e.printStackTrace();
		}
		
	}

	public void rem(int id) {
		try {
			dao.remover(id);
		} catch (JogosDAOException e) {
			e.printStackTrace();
		}
		
	}

	public void atualizar(Jogo j) {
		try {
			dao.atualizar(j);
		} catch (JogosDAOException e) {
			e.printStackTrace();
		}
	}

	public List<Jogo> pesquisar(String text) {
		try {
			jogos = dao.pesquisar(text);
		} catch (JogosDAOException e) {
			e.printStackTrace();
		}
		return jogos;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		switch (arg0) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return Date.class;
		case 3:
			return Float.class;
		default:
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return 4; // qtd de atributos
	}

	@Override
	public String getColumnName(int arg0) {
		switch (arg0) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Lançamento";
		case 3:
			return "Preço";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() { // tamanho da tabela
		return jogos.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Jogo j = jogos.get(row);
		switch (col) {
		case 0:
			return j.getId();
		case 1:
			return j.getNome();
		case 2:
			return j.getLancamento();
		case 3:
			return j.getPreço();
		default:
			return "";
		}
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
