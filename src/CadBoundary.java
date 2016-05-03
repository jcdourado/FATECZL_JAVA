import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CadBoundary extends JFrame implements ActionListener, ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPreco;
	private JTextField txtLanca;
	private JTextField txtNome;
	private JTextField txtId;
	private JTable tabela;
	private JScrollPane panTable;

	private CadControle CC = new CadControle();

	public CadBoundary() {
		this.setTitle("Cadastro Jogo");
		this.setSize(600, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel botoes = new JPanel(new FlowLayout());
		JPanel campos = new JPanel(new FlowLayout());
		JLabel lblId = new JLabel("Id: ");
		JLabel lblNome = new JLabel("Nome: ");
		JLabel lblLanca = new JLabel("Lançamento: ");
		JLabel lblPreco = new JLabel("Preço: ");

		tabela = new JTable(CC);
		panTable = new JScrollPane();
		panTable.getViewport().add(tabela);

		tabela.getSelectionModel().addListSelectionListener(this);

		panel.add(panTable, BorderLayout.CENTER);
		panel.add(botoes, BorderLayout.SOUTH);
		panel.add(campos, BorderLayout.NORTH);

		txtPreco = new JTextField(8);
		txtLanca = new JTextField(8);
		txtNome = new JTextField(8);
		txtId = new JTextField(8);
		JButton btnAdd = new JButton("Adicionar");
		JButton btnRem = new JButton("Remover");
		JButton btnAtt = new JButton("Atualizar");
		JButton btnPes = new JButton("Pesquisar");
		btnAdd.addActionListener(this);
		btnRem.addActionListener(this);
		btnAtt.addActionListener(this);
		btnPes.addActionListener(this);
		campos.add(lblId);
		campos.add(txtId);
		campos.add(lblNome);
		campos.add(txtNome);
		campos.add(lblLanca);
		campos.add(txtLanca);
		campos.add(lblPreco);
		campos.add(txtPreco);
		botoes.add(btnAdd);
		botoes.add(btnRem);
		botoes.add(btnAtt);
		botoes.add(btnPes);
		this.setContentPane(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CadBoundary();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if (cmd.equals("Adicionar")) {
			try {
				CC.add(fromJogo());
			} catch (NumberFormatException erro) {
				System.out.println("Erro com campos");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erro com campos");

				e1.printStackTrace();
			}
			CC.pesquisar("");
			tabela.revalidate();
			panTable.repaint();
		} else if (cmd.equals("Remover")) {
			try {
				CC.rem(Integer.parseInt(txtId.getText()));
			} catch (NumberFormatException erro) {
				System.out.println("Erro com campos");
			}
			CC.pesquisar("");
			tabela.revalidate();
			panTable.repaint();
			Jogo j = new Jogo();
			j.setNome("");
			j.setLancamento(new Date());
			toJogo(j);
		} else if (cmd.equals("Atualizar")) {
			try {
				CC.atualizar(fromJogo());
			} catch (NumberFormatException erro) {
				System.out.println("Erro com campos");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			CC.pesquisar("");
			tabela.revalidate();
			panTable.repaint();
		} else {
			CC.pesquisar(txtNome.getText());
			tabela.revalidate();
			panTable.repaint();
		}
	}

	public Jogo fromJogo() throws ParseException {
		Jogo j = new Jogo();
		j.setId(Integer.parseInt(txtId.getText()));
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		j.setLancamento(in.parse(txtLanca.getText()));
		j.setNome(txtNome.getText());
		j.setPreço(Float.parseFloat(txtPreco.getText()));
		return j;
	}

	public void toJogo(Jogo j) {
		txtId.setText(String.valueOf(j.getId()));
		txtNome.setText(j.getNome());
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		txtLanca.setText(in.format(j.getLancamento()));
		txtPreco.setText(String.valueOf(j.getPreço()));
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linha = tabela.getSelectionModel().getMinSelectionIndex();
		toJogo(CC.getJogos().get(linha));
	}
}
