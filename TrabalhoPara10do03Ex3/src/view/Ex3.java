package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import controller.controlador;

public class Ex3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8730307263284995133L;
	private JPanel contentPane;
	private final JLabel lblLabel = new JLabel("Digite o caminho:");
	private final JTextField textField = new JTextField();
	private JButton btnCancelar;
	private JButton btnOk;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex3 frame = new Ex3();
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
	public Ex3() {
		setTitle("Abre Programas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 131);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblLabel.setBounds(24, 11, 98, 31);
		contentPane.add(lblLabel);
		textField.setBounds(132, 16, 230, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(93, 63, 89, 23);
		contentPane.add(btnOk);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(199, 63, 89, 23);
		contentPane.add(btnCancelar);
		
		controlador a = new controlador(textField, btnCancelar, btnOk);
		btnOk.addActionListener(a);
		btnCancelar.addActionListener(a);

	}

}
