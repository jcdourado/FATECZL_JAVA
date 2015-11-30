import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AlunoJanela implements ActionListener, ListSelectionListener{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JFrame janela;
	private JPanel panelPrincipal;
	private JPanel panelBtn;
	private JPanel panelCampos;
	private JScrollPane paneTable;
	private ControllerAluno con = new ControllerAluno();
	private JTable tabela = new JTable(con);
	private JTextField ra;
	private JTextField nome;
	private JTextField idade;
	private JTextField nasc;
	
	public AlunoJanela(){
		janela = new JFrame("Formulário de alunos");
		janela.setSize(400, 600);
		panelPrincipal = new JPanel(new BorderLayout());
		panelBtn = new JPanel(new FlowLayout());
		panelCampos= new JPanel(new GridLayout(4,2));
		
		paneTable = new JScrollPane();
		paneTable.getViewport().add(tabela);

		tabela.getSelectionModel().addListSelectionListener(this);
		
		JLabel lblRa = new JLabel("R.A.:");
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblIdade = new JLabel("Idade:");
		JLabel lblNasc = new JLabel("Data de Nascimento:");
		
		ra = new JTextField();
		nome = new JTextField();
		idade = new JTextField();
		nasc = new JTextField();
		
		panelCampos.add(lblRa);
		panelCampos.add(ra);
		panelCampos.add(lblNome);
		panelCampos.add(nome);
		panelCampos.add(lblIdade);
		panelCampos.add(idade);
		panelCampos.add(lblNasc);
		panelCampos.add(nasc);
		
		panelPrincipal.add(panelCampos,BorderLayout.NORTH);
		panelPrincipal.add(paneTable,BorderLayout.CENTER);
		
		JButton btnAdd = new JButton("Adicionar");
		JButton btnRem = new JButton("Remover");
		JButton btnAtt = new JButton("Atualizar");
		JButton btnPes = new JButton("Pesquisar");
		
		btnAdd.addActionListener(this);
		btnAtt.addActionListener(this);
		btnRem.addActionListener(this);
		btnPes.addActionListener(this);
		
		panelBtn.add(btnAdd);
		panelBtn.add(btnAtt);
		panelBtn.add(btnRem);
		panelBtn.add(btnPes);
		panelPrincipal.add(panelBtn,BorderLayout.SOUTH);
		janela.setContentPane(panelPrincipal);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Adicionar")){
			con.adicionar(fromAluno());
			tabela.revalidate();
			paneTable.repaint();
		}
		else if(cmd.equals("Remover")){
			con.remover(fromAluno());
			tabela.revalidate();
			paneTable.repaint();
		}
		else if(cmd.equals("Atualizar")){
			con.atualizar(fromAluno());
			tabela.revalidate();
			paneTable.repaint();
		}
		else{
			con.pesq(fromAluno());
			tabela.revalidate();
			paneTable.repaint();
		}
	}
	
	public void toAluno(Aluno a){
		ra.setText(a.getRa());
		nome.setText(a.getNome());
		idade.setText(String.valueOf(a.getIdade()));
		nasc.setText(sdf.format(a.getNascimento()));
	}
	
	public Aluno fromAluno(){
		Aluno a = new Aluno();
		a.setRa(ra.getText());
		a.setNome(nome.getText());
		try{
			a.setIdade(Integer.parseInt(idade.getText()));
		}
		catch(NumberFormatException e){}
		try {
			a.setNascimento(sdf.parse(nasc.getText()));
		} catch (ParseException e) {}
		return a;
	}
	
	
	public static void main(String[] args) {
		new AlunoJanela();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linha = tabela.getSelectionModel().getMinSelectionIndex();
		toAluno(con.getLista().get(linha));
	}
}
