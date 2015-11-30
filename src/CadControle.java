import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class CadControle implements TableModel{
	private Connection con;
	private List<Jogo> jogos = new ArrayList<Jogo>();
	private Jogo jAtual = new Jogo();
	
	public CadControle(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogos","root","aluno");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(Jogo j){
		// permite inserir tudo 
		String sql = "insert into jogo(id, nome, lancamento, preco) values (? ,? , ? , ?);";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, j.getId());
			stmt.setString(2, j.getNome());
			java.sql.Date sd = new java.sql.Date( j.getLancamento().getTime());
			stmt.setDate(3, sd);
			stmt.setFloat(4, j.getPreço());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rem(int id){
		String sql = "delete from jogo where id = "+id +";";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			int linhas = stmt.executeUpdate();
			
			if(linhas == 1){
				System.out.println("Jogo excluido com sucesso");
			}
			else{
				System.out.println("Erro ao excluir o jogo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void atualizar(Jogo j){

		java.sql.Date sd = new java.sql.Date( j.getLancamento().getTime());
		String sql = "update jogo set nome = '" +j.getNome()+"', lancamento = '"+sd+"', preco = "+j.getPreço()+" where id = "+j.getId()+";";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			int linhas = stmt.executeUpdate();
			
			if(linhas == 1){
				System.out.println("Jogo atualizado com sucesso");
			}
			else{
				System.out.println("Erro ao atualizar o jogo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public List<Jogo> pesquisar(String text) {
		String sql = "SELECT * FROM jogo WHERE nome like ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+text+"%");
			ResultSet rs = stmt.executeQuery();
			jogos.clear();
			while(rs.next()){ // testa se pegou alguma informação
				Jogo j = new Jogo();				
				j.setId(rs.getInt("id"));
				j.setNome(rs.getString("nome"));
				j.setLancamento(rs.getDate("lancamento"));
				j.setPreço(rs.getFloat("preco"));
				jogos.add(j);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		switch(arg0){
		case 0 : return Integer.class;
		case 1 : return String.class;
		case 2 : return Date.class;
		case 3 : return Float.class;
		default: return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return 4; // qtd de atributos
	}

	@Override
	public String getColumnName(int arg0) {
		switch(arg0){
		case 0 : return "Id";
		case 1 : return "Nome";
		case 2 : return "Lançamento";
		case 3 : return "Preço";
		default: return "";
		}
	}

	@Override
	public int getRowCount() { // tamanho da tabela
		return jogos.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Jogo j = jogos.get(row);
		switch(col){ 
		case 0 : return j.getId();
		case 1 : return j.getNome();
		case 2 : return j.getLancamento();
		case 3 : return j.getPreço();
		default: return "";
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
