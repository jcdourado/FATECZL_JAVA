package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPista;

public class Carros {

	public static void main(String[] args) {
		int permissaoPista = 5;
		
		Semaphore semaforoPista = new Semaphore(permissaoPista);
		
		for(int i = 0; i < 7 ; i ++){
			Thread carro = new ThreadPista(i,semaforoPista);
			carro.start();
		}
	}

}
