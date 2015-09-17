package controller;

import java.util.concurrent.Semaphore;

public class ThreadPista extends Thread{
	private int escuderia;
	private Semaphore semaforoPista;
	private int voltaRapida;
	
	public ThreadPista(int escuderia, Semaphore semaforoPista){
		this.escuderia = escuderia;
		this.semaforoPista = semaforoPista;
		this.voltaRapida = 1000;
	}
	

	public void andando(int i, int carro){
			
			int volta = (int)(Math.random() * 500 + 500);
			voltaRapida = Math.min(volta, voltaRapida);
			
			System.out.println("O carro " + carro + " completou sua " + (i+1) + "º volta em " + volta + "segundos");
			
			try {
				Thread.sleep(volta);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void chega(int carro, int escuderia){
		System.out.println("O carro " + carro + " da escuderia " + escuderia +  " chegou");
	}
		
	public void entraPista(int carro, int escuderia){
		System.out.println("O carro " + carro + " da escuderia " + escuderia +  " entrou");
	}
	
	@Override
	public void run(){

		for(int carro = 0 ; carro < 2 ; carro ++){
		
			try {
				semaforoPista.acquire();
							
					entraPista(carro, escuderia);
					
					for(int i = 0 ; i < 3 ; i ++){
						andando(i,carro);
					}
					
					chega(carro, escuderia);	
	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				semaforoPista.release();
			}
		}
	}
}
