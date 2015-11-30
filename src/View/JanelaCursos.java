package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.ControllerAluno;
import Entity.Curso;
import TableModel.ControllerTable;

public class JanelaCursos implements ListSelectionListener, ActionListener{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JFrame janela;
	private JPanel panelPrincipal;
	private JPanel panelBtn;
	private JPanel panelCampos;
	private JScrollPane paneTable;
	private ControllerTable ctr = new ControllerTable();
	private ControllerAluno ctrCurso;
	private JTable tabela = new JTable(ctr);
	private JTextField id;
	private JTextField nome;
	private JTextField descricao;
	private JCheckBox ativo;
	private JTextField inicio;
	private JTextField termino;
	
	public JanelaCursos() {
		janela = new JFrame("Formulário de cursos");
		janela.setSize(400, 600);
		panelPrincipal = new JPanel(new BorderLayout());
		panelBtn = new JPanel(new FlowLayout());
		panelCampos= new JPanel(new GridLayout(6,2));
		
		paneTable = new JScrollPane();
		paneTable.getViewport().add(tabela);

		tabela.getSelectionModel().addListSelectionListener(this);
		
		JLabel lblId = new JLabel("ID:");
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblDescricao = new JLabel("Descrição:");
		JLabel lblAtivo = new JLabel("Ativo");
		JLabel lblInicio = new JLabel("Inicio:");
		JLabel lblTermino = new JLabel("Término:");
		
		id = new JTextField();
		nome = new JTextField();
		descricao = new JTextField();
		ativo = new JCheckBox();
		inicio = new JTextField();
		termino = new JTextField();
		
		panelCampos.add(lblId);
		panelCampos.add(id);
		panelCampos.add(lblNome);
		panelCampos.add(nome);
		panelCampos.add(lblDescricao);
		panelCampos.add(descricao);
		panelCampos.add(lblAtivo);
		panelCampos.add(ativo);
		panelCampos.add(lblInicio);
		panelCampos.add(inicio);
		panelCampos.add(lblTermino);
		panelCampos.add(termino);
		
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
	public void valueChanged(ListSelectionEvent arg0) {
		int linha = tabela.getSelectionModel().getMinSelectionIndex();
		toCurso(ctr.getCursos().get(linha));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		try {
			ctrCurso = new ControllerAluno();
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro","Erro!",JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		switch(cmd){
		case "Adicionar": 
			try {
				ctr.setCursos(ctrCurso.adicionar(fromCurso()));
				tabela.revalidate();
				paneTable.repaint();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro","Erro!",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			break;
		case "Remover": 
			try {
				ctr.setCursos(ctrCurso.remover(fromCurso()));
				tabela.revalidate();
				paneTable.repaint();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro","Erro!",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			break;
		case "Atualizar": 
			try {
				ctr.setCursos(ctrCurso.atualizar(fromCurso()));
				tabela.revalidate();
				paneTable.repaint();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro","Erro!",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			break;
		case "Pesquisar": 
			try {
				ctr.setCursos(ctrCurso.pesquisar(fromCurso()));
				tabela.revalidate();
				paneTable.repaint();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro","Erro!",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			break;
		}
	}
	
	public void toCurso(Curso c){
		id.setText(String.valueOf(c.getId()));
		nome.setText(c.getNome());
		descricao.setText(c.getDescricao());
		ativo.setSelected(c.isAtivo());
		inicio.setText(sdf.format(c.getHorarioInicio()));
		termino.setText(sdf.format(c.getHorarioTermino()));
	}
	
	public Curso fromCurso(){
		Curso c = new Curso();
		try{
			c.setId(Integer.parseInt(id.getText()));
		}
		catch(NumberFormatException e ){}
		c.setNome(nome.getText());
		c.setDescricao(descricao.getText());
		c.setAtivo(ativo.isSelected());
		try{
			c.setHorarioInicio(sdf.parse(inicio.getText()));
			c.setHorarioTermino(sdf.parse(termino.getText()));
		}
		catch(ParseException e ){}
		return c;
	}
	
	public static void main(String[] args) {
		new JanelaCursos();
	}
}
