package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.Ex3;

public class controlador implements ActionListener{
	private JTextField textField;
	private JButton btnCancelar;
	private JButton btnOk;
	public String caminho;
	
	public controlador(JTextField textField, JButton btnCancelar, JButton btnOk){
		this.textField = textField;
		this.btnOk = btnOk;
		this.btnCancelar = btnCancelar;
	}
	
	public void chamaProcesso(String path){
		try{
			Process processo = Runtime.getRuntime().exec(path);
		}
		catch (IOException e){
			if(e.getMessage().contains("eleva")){
				StringBuffer buffer = new StringBuffer();
				
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(path);
				
				try {
					Process processAdm = Runtime.getRuntime().exec(buffer.toString());					
				}
				catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);				
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//GAMBIARRA, FAVOR NAO MEXER, VERIFIQUEI SE NA SAIDA HAVIA OK OU CANCELAR E AI EXECUTA, COISA DE DOIDO
		String gambi = arg0.toString();
		if(gambi.contains("Ok")){
			caminho = textField.getText();
			System.out.println(caminho);
			chamaProcesso(caminho);
		}
		else{
			System.exit(0);
		}
		

	}
}
