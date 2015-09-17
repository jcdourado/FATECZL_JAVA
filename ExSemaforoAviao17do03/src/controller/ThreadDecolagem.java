package controller;

import java.util.concurrent.Semaphore;

public class ThreadDecolagem extends Thread{
	
	private Semaphore semaforo; 
	private int aviao;
	private Semaphore semaforoCeu;
	
	public ThreadDecolagem(Semaphore semaforo, Semaphore semaforoCeu,int aviao){
		this.semaforo = semaforo;
		this.aviao = aviao;
		this.semaforoCeu = semaforoCeu;
	}
	
	public void manobrar(){
		int tempo = (int) (Math.random()* 4000 + 3000);
		System.out.println("Aviao " + aviao + " está manobrando");
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void taxiar(){
		int tempo = (int) (Math.random()* 3000 + 2000);
		System.out.println("Aviao " + aviao + " está taxiando");
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void posicionar(){
		int tempo = (int) (Math.random()* 3000 + 1000);
		System.out.println("Aviao " + aviao + " está posicionando a cabeçeira");
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void acelerar(){
		int tempo = (int) (Math.random()* 2000 + 3000);
		System.out.println("Aviao " + aviao + " está manobrando");
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void decolar(){
		int tempo = (int) (Math.random()* 3000 + 4000);
		System.out.println("Aviao " + aviao + " está decolando");
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void afastar(){
		int tempo = (int) (Math.random()* 4000 + 2000);
		System.out.println("Aviao " + aviao + " está afastando");
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		try {
			semaforo.acquire();
			manobrar();
			taxiar();
			posicionar();
			acelerar();
			afastar();
			
			try {
				semaforoCeu.acquire();	
				decolar();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforoCeu.release();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
}
