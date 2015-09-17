package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import controller.principal;

public class controladorDesign implements ActionListener{
	
	JButton btnIniciar;
	JFormattedTextField ponto2;
	JFormattedTextField ponto1;
	
	public controladorDesign(JButton btnIniciar, JFormattedTextField ponto2, JFormattedTextField ponto1){
		this.btnIniciar = btnIniciar;
		this.ponto2 = ponto2;
		this.ponto1 = ponto1;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			Thread bolinha1 = new principal(this.ponto1);
			Thread bolinha2 = new principal(this.ponto2);
			
			bolinha1.start();
			bolinha2.start();
			
		}
}
