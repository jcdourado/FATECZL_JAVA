package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class controlador implements ActionListener {
	
	private JTextField txtFldValor;
	private JTextPane textPane;
	
	public controlador(	JTextField txtFldValor, JTextPane textPane){
		this.txtFldValor = txtFldValor;
		this.textPane = textPane;
	}
	

	public void mostraTela(){
		String tabela;
		String nomeSO = System.getProperty("os.name");
		if(nomeSO.contains("Window")){
			tabela = "tasklist /FO TABLE";
		}
		else{
			tabela = "ps aux";
		}
		
		try{
			Process processos = Runtime.getRuntime().exec(tabela);
			
			InputStream fluxo = processos.getInputStream();
			
			InputStreamReader leitor = new InputStreamReader(fluxo);
			
			BufferedReader bufferLeitura = new BufferedReader(leitor);
			
			String linha = bufferLeitura.readLine();
			
			StringBuffer exibir = new StringBuffer();
			
			while(linha != null){
				
				exibir.append(linha);
				
				exibir.append("\n");
				
				linha = bufferLeitura.readLine();
				
			}
			
			textPane.setText(exibir.toString());
			txtFldValor.setText(nomeSO);
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		mostraTela();
	}
	
	
}