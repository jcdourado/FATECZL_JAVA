package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	
	private int idThread;
	private static final int DISTANCIA_TOTAL = 1000;
	private Semaphore semaforo;
	
	public ThreadCarro(int idThread, Semaphore semaforo){
		this.idThread = idThread;
		this.semaforo = semaforo;
	}
	
	public void carroAndando(){
		
		int distanciaPercorrida = 0;
		while (distanciaPercorrida < DISTANCIA_TOTAL){
			int rodada = (int)(Math.random() * 50 + 50);
			distanciaPercorrida += rodada;
			System.out.println("O carro " + idThread + " percorreu " + distanciaPercorrida + " metros");
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void carroChega(){
		System.out.println("O carro " + idThread + " chegou");
	}
	
	public void carroParado(){
		System.out.println("O carro " + idThread + " estacionou" );
		int tempoParado = (int)(Math.random() * 200 + 800);
		
		try {
			Thread.sleep(tempoParado);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void carroSai(){
		System.out.println("O carro " + idThread + " foi embora");
	}
	
	@Override
	public void run(){
		carroAndando();
		carroChega();
		
		try {
			semaforo.acquire(); // da o tempo para o carro
			carroParado();
			carroSai();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			semaforo.release(); // solta o semaforo
		}		
	}
}
