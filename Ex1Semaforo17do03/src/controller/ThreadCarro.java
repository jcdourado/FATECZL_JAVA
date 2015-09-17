package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	private int num;
	private Semaphore semaforo;
	private static final int ESQUINA = 100;
	
	
	public ThreadCarro(int num, Semaphore semaforo){
		this.num = num;
		this.semaforo = semaforo;
	}
	
	public void andando(){
		
		int distPercorrida = 0;
		
		while(distPercorrida  < ESQUINA){
			int andada = (int)(Math.random() * 20 + 1);
			distPercorrida += andada;
			System.out.println("O carro " + num + " percorreu " + distPercorrida + " metros");

			try{
				Thread.sleep(300);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void chega(){
		System.out.println("O carro " + num + " chegou");
	}
	
	public void sai(){
		System.out.println("O carro " + num + " saiu");
	}
	
	public void passa(){
		System.out.println("O carro " + num + " está passando");
		int tempo = (int)(Math.random() * 200 + 800);
		
		try{
			Thread.sleep(tempo);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		andando();
		chega();
		
		try {
			semaforo.acquire();
			passa();
			sai();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			semaforo.release(); // solta o semaforo
		}	
		
	}
	
	
}
