package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBanco;

public class Banco {
	public static void main(String args[]){
		Semaphore semaforoDeposito = new Semaphore(1);
		Semaphore semaforoSaque = new Semaphore(1);
		
		
		
		for(int i = 0 ; i < 20 ; i++){
			int transacao = (int)(Math.random() * 2);
			Thread conta = new ThreadBanco(i, transacao, semaforoDeposito, semaforoSaque);
			conta.start();
		}
	}
}
