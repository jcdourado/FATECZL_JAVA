import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ControllerAluno implements TableModel{
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private DAOAluno dao = new DAOAluno();
	
	public List<Aluno> getLista(){
		return alunos;
	}
	
	public void adicionar(Aluno a){
		dao.add(a);
		pesq(new Aluno());
	}
	
	public void remover(Aluno a){
		dao.rem(a.getRa());
		pesq(new Aluno());
	}
	
	public void atualizar(Aluno a){
		dao.atualizar(a);
		pesq(new Aluno());
	}
	
	public List<Aluno> pesq(Aluno a){
		alunos = dao.pesquisar(a.getNome());
		return alunos;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return Integer.class;
		case 3 : return Date.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex){
		case 0 : return "R.A.";
		case 1 : return "Nome";
		case 2 : return "Idade";
		case 3 : return "Nascimento";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return alunos.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Aluno a = alunos.get(rowIndex);
		switch(columnIndex){
		case 0 : return a.getRa();
		case 1 : return a.getNome();
		case 2 : return a.getIdade();
		case 3 : return a.getNascimento();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

}
