import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class DicionarioControle implements TableModel{
	private List<Palavra> dicionario = new ArrayList<Palavra>(); 
	
	public boolean adicionar(Palavra p){
		for(Palavra palavraDicionario : dicionario){
			if(palavraDicionario.getPalavra().equals(p.getPalavra())){
				return false;
			}
		}
		dicionario.add(p);
		return true;
	}
	
	public void remover(String palavra){
		for(Palavra palavraDicionario : dicionario){
			if(palavraDicionario.getPalavra().equals(palavra)){
				dicionario.remove(palavraDicionario);
				break;

			}
		}
	}
	
	public Palavra buscar(String p){
		for(Palavra palavraDicionario : dicionario){
			if(palavraDicionario.getPalavra().equals(p)){
				return palavraDicionario;
			}
		}
		return null;
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		switch(arg0){
		case 0: return String.class;
		case 1: return String.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int arg0) {
		switch(arg0){
		case 0: return "Palavra";
		case 1: return "Definição";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return dicionario.size();
	}

	// pode haver algo errado aqui
	@Override
	public Object getValueAt(int row, int col) {
		Palavra a = dicionario.get(row);
		switch(col){
		case 0 : return a.getPalavra();
		case 1 : return a.getDefinicao();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
	}
}
