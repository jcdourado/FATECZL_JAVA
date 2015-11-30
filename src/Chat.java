import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chat extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField texto;
	private Socket socket;
	private PrintWriter escreve;
	private String nome;
	
	public Chat(String n){
		super("Chat " + n);
		nome = n;
		texto = new JTextField();
		JButton btn = new JButton("Enviar");
		btn.addActionListener(new EnviarMSG());
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(texto, BorderLayout.CENTER);
		panel.add(btn, BorderLayout.EAST);
		rede();
		setContentPane(panel);
		setVisible(true);
		setSize(400,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class EnviarMSG implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			escreve.println(": "+nome+": "  + texto.getText());
			escreve.flush();
			texto.setText("");
			texto.requestFocus();
		}
		
	}
	
	private void rede(){
		try {
			socket = new Socket("localhost", 4000);
			escreve = new PrintWriter(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Chat("Julio");
		new Chat("Luana");
		new Chat("Matheus");
	}
}
