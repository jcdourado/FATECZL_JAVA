package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Design extends JFrame {

	private JPanel contentPane;
	JButton btnIniciar;
	JFormattedTextField ponto2;
	JFormattedTextField ponto1;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(30, 212, 89, 23);
		contentPane.add(btnIniciar);
		
		ponto1 = new JFormattedTextField();
		ponto1.setForeground(new Color(0, 0, 0));
		ponto1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ponto1.setBackground(SystemColor.desktop);
		ponto1.setText(".");
		ponto1.setBounds(45, 44, 11, 9);
		contentPane.add(ponto1);
		
		ponto2 = new JFormattedTextField();
		ponto2.setText(".");
		ponto2.setForeground(Color.RED);
		ponto2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ponto2.setBackground(Color.RED);
		ponto2.setBounds(45, 145, 11, 9);
		contentPane.add(ponto2);
		
		controladorDesign a = new controladorDesign(btnIniciar, ponto1, ponto2);
		btnIniciar.addActionListener(a);
		
	}
}
