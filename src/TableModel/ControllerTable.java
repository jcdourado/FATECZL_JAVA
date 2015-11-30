package TableModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Entity.Curso;

public class ControllerTable implements TableModel{
	
	private List<Curso> cursos = new ArrayList<Curso>();

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
		case 0: return Integer.class;
		case 1: return String.class;
		case 2: return String.class;
		case 3: return Boolean.class;
		case 4: return Date.class;
		case 5: return Date.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex){
		case 0: return "Id";
		case 1: return "Nome";
		case 2: return "Descrição";
		case 3: return "Ativo";
		case 4: return "Inicio";
		case 5: return "Termino";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return cursos.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Curso c = cursos.get(rowIndex);
		switch(columnIndex){
		case 0: return c.getId();
		case 1: return c.getNome();
		case 2: return c.getDescricao();
		case 3: return c.isAtivo();
		case 4: return c.getHorarioInicio();
		case 5: return c.getHorarioTermino();
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
	
	public List<Curso> getCursos(){
		return cursos;
	}

	public void setCursos(List<Curso> lista){
		this.cursos = lista;
	}
}
