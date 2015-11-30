import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlunoBoundary implements ActionListener {
	private JTextField txtId = new JTextField(10);
	private JTextField txtRa = new JTextField(10);
	private JTextField txtNome = new JTextField(50);
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private AlunoControle aC = new AlunoControle();
	
	public AlunoBoundary() { 
		JFrame janela = new JFrame("Gestão de Alunos");
		JPanel painel = new JPanel();
		janela.setContentPane( painel );
		painel.setLayout( new GridLayout(4, 2) );
		painel.add( new JLabel("Id : ") );
		painel.add( txtId );
		painel.add( new JLabel("Ra : ") );
		painel.add( txtRa );
		painel.add( new JLabel("Nome : ") );
		painel.add( txtNome );
		painel.add( btnAdicionar );
		painel.add( btnPesquisar );
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		janela.setSize(300, 200);
		janela.setVisible( true );
		janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Adicionar".equals(cmd)) { 
			aC.adiciona(toAluno()); 
		} else if ("Pesquisar".equals(cmd)) { 
			fromAluno(aC.pesquisar(txtNome.getText()));
		}
		
	}
	
	public Aluno toAluno(){
		Aluno a = new Aluno();
		a.setId( Long.parseLong( txtId.getText() ) );
		a.setRa( txtRa.getText() );
		a.setNome( txtNome.getText() );
		return a;
	}
	
	public void fromAluno(Aluno a){
		if(a!= null){
			txtId.setText(String.valueOf(a.getId()));
			txtRa.setText(a.getRa());
			txtNome.setText(a.getNome());
		}
		else{
			System.out.println("Noc Exicsts");
		}
	}

	public static void main(String[] args) {
		new AlunoBoundary();
	}
}
