import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class View implements ActionListener, ListSelectionListener{
	private JFrame janela;
	private JPanel panelCampos;
	private JPanel panelBtn;
	private JTable table;
	private JScrollPane scroll;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JPanel principal;
	private int onde = 0;
	
	private Usuario user = new Usuario();
	private Controller ctr = new Controller();
	
	public View() {
		janela = new JFrame("Usuarios");
		panelCampos = new JPanel(new GridLayout(2,2));
		panelBtn = new JPanel(new FlowLayout());
		principal = new JPanel(new BorderLayout());
		
		table = new JTable(ctr);
		scroll = new JScrollPane();
		
		scroll.getViewport().add(table);
		
		table.getSelectionModel().addListSelectionListener(this);
		
		JLabel lblUser = new JLabel("Usuário:");
		JLabel lblEnderero = new JLabel("Endereço:");
		
		txtNome = new JTextField(10);
		txtEndereco = new JTextField(10);
		
		panelCampos.add(lblUser);
		panelCampos.add(txtNome);
		panelCampos.add(lblEnderero);
		panelCampos.add(txtEndereco);
		
		principal.add(panelCampos, BorderLayout.NORTH);
		principal.add(scroll, BorderLayout.CENTER);
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(this);
		JButton btnRem = new JButton("Remover");
		btnRem.addActionListener(this);
		JButton btnAlt = new JButton("Alterar");
		btnAlt.addActionListener(this);
		
		panelBtn.add(btnAdd);
		panelBtn.add(btnRem);
		panelBtn.add(btnAlt);
		principal.add(panelBtn,BorderLayout.SOUTH);
		
		janela.setContentPane(principal);
		janela.setSize(600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Adicionar")){
			ctr.add(toUsuario());
			table.revalidate();
			scroll.repaint();
		} else if(cmd.equals("Remover")){
			ctr.rem(user);
			table.revalidate();
			scroll.repaint(); 
		} else if(cmd.equals("Alterar")){
			ctr.alterar(onde, toUsuario());
			table.revalidate();
			scroll.repaint(); 
		}
	}
	
	public void fromUsuario(Usuario user){
		txtNome.setText(user.getNome());
		txtEndereco.setText(user.getEndereço());
	}
	
	public Usuario toUsuario(){
		Usuario user = new Usuario();
		user.setNome(txtNome.getText());
		user.setEndereço(txtEndereco.getText());
		return user;
	}
	
	public static void main(String[] args) {
		new View();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		onde = table.getSelectionModel().getMinSelectionIndex();
		user = ctr.getUsuarios().get(onde);
		fromUsuario(user);
	}
}
