package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Esquina {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int i = 0 ; i < 4 ; i++){
			Thread t = new ThreadCarro(i,semaforo);
			t.start();
		}
	}
}
