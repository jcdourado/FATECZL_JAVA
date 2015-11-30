import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;


public class DicionarioBoundary implements ActionListener{
	private JFrame janela;
	private JPanel principal;
	private JTable tabela;
	private JPanel finalJanela;
	private JScrollPane scroll;
	private DicionarioControle dC = new DicionarioControle();
	
	public DicionarioBoundary(){
		this.janela = new JFrame("Dicionario");
		this.principal = new JPanel();
		this.principal.setLayout(new BorderLayout());
		this.tabela = new JTable(dC);
		scroll = new JScrollPane();
		JLabel lblTxto = new JLabel("Palavras no dicionario: ");
		scroll.getViewport().add(tabela);
	
		finalJanela = new JPanel(new FlowLayout());
		JButton add = new JButton("Adicionar");
		JButton pes = new JButton("Pesquisar");
		JButton rem = new JButton("Remover");
		add.addActionListener(this);
		pes.addActionListener(this);
		rem.addActionListener(this);
		
		finalJanela.add(add);
		finalJanela.add(pes);
		finalJanela.add(rem);

		tabela.setBackground(new Color(255,150,0));
		
		principal.add(lblTxto,BorderLayout.NORTH);
		principal.add(scroll, BorderLayout.CENTER);
		principal.add(finalJanela, BorderLayout.SOUTH);
			
		janela.setContentPane(principal);
		
		janela.setSize(500, 500);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new DicionarioBoundary();
	}


	@Override
	public void actionPerformed(ActionEvent eve) {
		String cmd = eve.getActionCommand();
		
		if(cmd.equals("Adicionar")){
			adicionar();
		}
		else if(cmd.equals("Remover")){
			remover();
		}
		else{
			pesquisar();
		}
		tabela.revalidate();
		scroll.repaint();
	}

	public void adicionar(){
		Palavra p = new Palavra();
		p.setPalavra(JOptionPane.showInputDialog("Digite uma palavra"));
		p.setDefinicao(JOptionPane.showInputDialog("Digite a definição"));
		if(!(dC.adicionar(p))){
			if(JOptionPane.showConfirmDialog(null, "Já existe essa palavra, deseja trocá-la?") == JOptionPane.OK_OPTION){
				removerP(p);
				adicionar();
			}
		}
	}
	
	public void remover(){
		String palavra = JOptionPane.showInputDialog("Digite a palavra");
		dC.remover(palavra);
	}
	
	public void removerP(Palavra p){
		dC.remover(p.getPalavra());
	}
	
	public void pesquisar(){
		String palavra = JOptionPane.showInputDialog("Digite a palavra");
		Palavra p = dC.buscar(palavra);
		if(p == null){
			if(JOptionPane.showConfirmDialog(null, "Palavra não encontrada, Deseja adicionar a palavra?") == JOptionPane.OK_OPTION){
				adicionar();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Palavra: " + p.getPalavra() + "\n Definição : " + p.getDefinicao() );
		}
	}
}
