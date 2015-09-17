package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.Design;

public class OpCorrer extends Thread{
	private JLabel lblCarro;

	public OpCorrer(JButton btnCorrer,JLabel lblCarro) {
		this.lblCarro = lblCarro;
	}

	public void corre(JLabel label) {
		Rectangle posicao;
		posicao = label.getBounds();
		label.setBounds(posicao);
		
		while(posicao.x<620){
			
			posicao.x += (int)(Math.random()*50);
			label.setBounds(posicao);
			
			try{
				Thread.sleep(100);
			}
			
			catch (InterruptedException ex) {
				 ex.printStackTrace();
			}
		}
		Design.posicao(lblCarro);
	}	
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		corre(lblCarro);
	}
}
