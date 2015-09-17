package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.ThreadM;

public class controlador implements ActionListener{
	
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public controlador(JButton btnNewButton,JTextField textField,JTextField textField_1,JTextField textField_2){
		  this.btnNewButton = btnNewButton;
		  this.textField = textField;
		  this.textField_1 = textField_1;
		  this.textField_2 = textField_2;	

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		btnNewButton.setEnabled(false);
		Thread[] vetor = new ThreadM[3];
		vetor[0] = new ThreadM(textField,btnNewButton);
		vetor[1] = new ThreadM(textField_1,btnNewButton);
		vetor[2] = new ThreadM(textField_2,btnNewButton);	
		
		for(int  i = 0 ; i < 3 ; i ++){
			vetor[i].start();
		}
	}
}
