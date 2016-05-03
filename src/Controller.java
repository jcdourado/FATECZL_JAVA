import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Controller implements TableModel{

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void add(Usuario user){
		usuarios.add(user);
	}
	
	public void rem(int id){
		usuarios.remove(id);
	}
	
	public void rem(Usuario user){
		usuarios.remove(user);
	}
	
	public void alterar(int id, Usuario user){
		usuarios.add(id, user);
		usuarios.remove(id + 1);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0: return String.class;
			case 1: return String.class;
			default: return null;
		}
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex){
			case 0: return "Usuário";
			case 1: return "Endereço";
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario user = usuarios.get(rowIndex);
		switch(columnIndex){
			case 0: return user.getNome();
			case 1: return user.getEndereço();
			default: return "";
		}
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
