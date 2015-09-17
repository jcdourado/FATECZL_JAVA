package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class principal extends Thread{
	
	JFormattedTextField ponto2;
	
	public principal(JFormattedTextField ponto2){
		this.ponto2 = ponto2;
	}
	
	public static void mexeBolinha(JFormattedTextField ponto2){
		 Rectangle posicao;
		 posicao = ponto2.getBounds();
		 ponto2.setBounds(posicao);
		 int contadorDeMov = 0;
		 while (contadorDeMov <= 12){
			 if (contadorDeMov <= 2){
				 posicao.y = posicao.y + 10;
			 } else {
			 if (contadorDeMov > 2 && contadorDeMov <= 6){
				 posicao.x = posicao.x + 20;
			 } else {
				 if (contadorDeMov > 6 && contadorDeMov <= 9){
					 posicao.y = posicao.y - 10;
				 } else {
					 if (contadorDeMov > 9 && contadorDeMov <= 12){
						 posicao.x = posicao.x - 20;
					 }
				 }
			 }
		 }
		 ponto2.setBounds(posicao);
		 try {
			 Thread.sleep(50);
		 } catch (InterruptedException ex) {
			 ex.printStackTrace();
		 }
		 	contadorDeMov++;
		 }
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		mexeBolinha(ponto2);
	}
	
	
}
