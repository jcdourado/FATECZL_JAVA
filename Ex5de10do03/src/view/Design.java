package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

public class Design extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	public static int contador = 0;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 33));
		textField.setEditable(false);
		textField.setBounds(30, 120, 70, 54);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(192, 120, 70, 54);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 33));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(361, 120, 70, 54);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Rodar");
		btnNewButton.setBounds(184, 288, 89, 23);
		contentPane.add(btnNewButton);
		
		controlador a = new controlador(btnNewButton, textField, textField_1, textField_2);
		btnNewButton.addActionListener(a);

	}
	
	public static int getContador(){
		return contador++;
	}
	
	public static void vence(){
		String texto = textField.getText();
		String texto1 = textField_1.getText();
		String texto2 = textField_2.getText();
		
		int numero = Integer.parseInt(texto);
		int numero1 = Integer.parseInt(texto1);
		int numero2 = Integer.parseInt(texto2);
		
		if(numero == numero1 && numero == numero2){
			JOptionPane.showMessageDialog(null, "Você venceu!!");
		}
	}
	
}
