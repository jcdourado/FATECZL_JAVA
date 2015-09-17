package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPista;

public class Carros {

	public static void main(String[] args) {
		int permissaoPista = 5;
		Semaphore semaforoPista = new Semaphore(permissaoPista);
		
		Semaphore[] semaforos = new Semaphore[7];
		
		for(int i = 0; i < 7; i++){
			semaforos[i] = new Semaphore(1);
		}
		
		for(int i = 0; i < 7 ; i ++){
			for(int j = 0; j < 2 ; j ++){
				Thread carro = new ThreadPista(i,semaforoPista, semaforos[i], j);
				carro.start();
			}
		}
	}

}
