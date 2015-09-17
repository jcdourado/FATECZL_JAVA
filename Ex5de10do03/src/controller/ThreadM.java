package controller;

import javax.swing.JButton;
import javax.swing.JTextField;

import view.Design;

public class ThreadM extends Thread{
	private JTextField textField;
	private JButton btnNewButton;
	
	public ThreadM(JTextField textField, JButton btnNewButton){
		this.textField = textField;
		this.btnNewButton = btnNewButton;
	}
	
	public void sorteia(JTextField textField) {
		
		int numeroVoltas = (int)(Math.random()*150+1);
		
		for(int i = 0 ; i < numeroVoltas ; i++){
			
			int numero = (int)(Math.random()*7+1);
			String numeroTexto = Integer.toString(numero);
			textField.setText(numeroTexto);
			
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		int volta = Design.getContador();
		verifica(volta, btnNewButton);
	}
	
	public void verifica(int volta, JButton btnNewButton){
		if (volta==2){
			Design.vence();
			btnNewButton.setEnabled(true);
			Design.contador = 0;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sorteia(textField);
	}				
}
