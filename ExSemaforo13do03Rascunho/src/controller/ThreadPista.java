package controller;

import java.util.concurrent.Semaphore;

public class ThreadPista extends Thread{
	private int escuderia;
	private Semaphore semaforoPista;
	private Semaphore semaforo;
	private int voltaRapida;
	private int carro;
	
	public ThreadPista(int escuderia, Semaphore semaforoPista,  Semaphore semaforo, int carro){
		this.escuderia = escuderia;
		this.semaforoPista = semaforoPista;
		this.semaforo = semaforo;
		this.voltaRapida = 1000;
		this.carro = carro;
	}
	

	public void andando(int i, int carro, int escuderia){
			
			int volta = (int)(Math.random() * 500 + 500);
			voltaRapida = Math.min(volta, voltaRapida);
			
			System.out.println("O carro " + carro + " da escuderia " + escuderia + " completou sua " + (i+1) + "º volta em " + volta + "segundos");
			
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
	
			try {
				semaforo.acquire();
				semaforoPista.acquire();
							
					entraPista(carro, escuderia);
					
					for(int i = 0 ; i < 3 ; i ++){
						andando(i,carro,escuderia);
					}
					
					chega(carro, escuderia);	
	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				semaforoPista.release();
				semaforo.release();
			}
		}
	}

