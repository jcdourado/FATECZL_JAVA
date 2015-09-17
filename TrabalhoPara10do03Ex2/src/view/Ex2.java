package view;

import controller.controlador;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Font;

public class Ex2 extends JFrame {
			
	/**
	 * 
	 */
	private static final long serialVersionUID = 6410908747930121045L;
	private JPanel contentPane;
	private JTextField txtFldValor;
	private JButton btnAcao;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
						
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex2 frame = new Ex2();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ex2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJlLabel = new JLabel("Nome");
		lblJlLabel.setBounds(34, 14, 39, 14);
		contentPane.add(lblJlLabel);
		
		txtFldValor = new JTextField();
		txtFldValor.setEditable(false);
		txtFldValor.setBounds(103, 11, 415, 22);
		contentPane.add(txtFldValor);
		txtFldValor.setColumns(10);
		
		btnAcao = new JButton("Mostra");
		btnAcao.setBounds(539, 10, 89, 23);
		contentPane.add(btnAcao);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 636, 393);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Courier New", Font.PLAIN, 11));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);

		
		controlador controler = new controlador(txtFldValor, textPane);
		btnAcao.addActionListener(controler);
		
	}
}
