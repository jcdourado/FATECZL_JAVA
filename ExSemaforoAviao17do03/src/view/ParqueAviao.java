package view;

import java.util.concurrent.Semaphore;

import controller.ThreadDecolagem;

public class ParqueAviao {
	public static void main(String args[]){
		Semaphore semaforo = new Semaphore(2);
		Semaphore semaforoCeu = new Semaphore(1);
		
		for(int aviao = 0 ; aviao < 15 ; aviao++){
			Thread i = new ThreadDecolagem(semaforo, semaforoCeu, aviao);
			i.start();
		}
	}
}
