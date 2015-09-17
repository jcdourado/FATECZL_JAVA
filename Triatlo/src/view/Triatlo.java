package view;

import java.util.concurrent.Semaphore;

import controller.TreadTriatlo;

public class Triatlo {
	static TreadTriatlo competidores[] = new TreadTriatlo[5];

	public static void main(String[] args) {
		int armas = 3;
		Semaphore armasDisponiveis = new Semaphore(armas);
	
		for(int i = 0 ; i < 5 ; i ++){
			competidores[i] = new TreadTriatlo(i, armasDisponiveis);
			competidores[i].start();
		}
	}
	
	public static void listar(long tempo, int competidor){
			
		try {
			competidores[competidor].sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Competidor : " + competidor + " fez " + tempo);
		
	}

}
