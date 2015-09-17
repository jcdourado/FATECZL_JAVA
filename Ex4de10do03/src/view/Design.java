package view;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;

public class Design extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textFieldVencedor;
	private static JTextField textFieldPerdedor;
	private static String nomeVencedor;
	static String carro = "Carro ";
	static int posicao = 0;
	private JTextField textField;
	private static JButton btnCorrer;
	public static Rectangle posicaoCarro1;
	public static Rectangle posicaoCarro2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Design frame = new Design();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Design() {
		setResizable(false);
		setTitle("Corrida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setForeground(SystemColor.activeCaption);
		lblCarro1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCarro1.setBounds(20, 73, 64, 14);
		contentPane.add(lblCarro1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 112, 633, 2);
		contentPane.add(separator);
		
		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setForeground(Color.GREEN);
		lblCarro2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCarro2.setBounds(20, 136, 64, 14);
		contentPane.add(lblCarro2);
		
		btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(69, 363, 89, 23);
		contentPane.add(btnCorrer);
		
		JLabel lblNewLabel_1 = new JLabel("Vencedor");
		lblNewLabel_1.setBounds(392, 302, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldVencedor = new JTextField();
		textFieldVencedor.setEditable(false);
		textFieldVencedor.setBounds(376, 327, 86, 20);
		contentPane.add(textFieldVencedor);
		textFieldVencedor.setColumns(10);
		
		textFieldPerdedor = new JTextField();
		textFieldPerdedor.setEditable(false);
		textFieldPerdedor.setColumns(10);
		textFieldPerdedor.setBounds(580, 327, 86, 20);
		contentPane.add(textFieldPerdedor);
		
		JLabel labelPerdedor = new JLabel("Perdedor");
		labelPerdedor.setBounds(595, 302, 86, 14);
		contentPane.add(labelPerdedor);
		
		MetodosEspeciais a = new MetodosEspeciais(lblCarro1, lblCarro2, btnCorrer);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBackground(Color.BLACK);
		textField.setBounds(659, 73, 7, 87);
		contentPane.add(textField);
		textField.setColumns(10);
		btnCorrer.addActionListener(a);
	}
	
	public static void posicao(JLabel lblCarro){
		posicao++;
		
		String nome = lblCarro.getText();
		if(posicao==1){
			nomeVencedor = nome;
		}
		System.out.println(nome);
		
		if(posicao==1){
			textFieldVencedor.setText(nome);
			textFieldVencedor.setText(nomeVencedor);
			posicaoCarro1 = lblCarro.getBounds();
		}
		else{
			textFieldPerdedor.setText(nome);
			try {
				Thread.sleep(1000);
				btnCorrer.setEnabled(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			posicaoCarro2 = lblCarro.getBounds();
			MetodosEspeciais.setaPosicao(posicaoCarro1,posicaoCarro2);
			posicao = 0 ;
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
