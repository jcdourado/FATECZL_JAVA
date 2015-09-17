package controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import view.Triatlo;

public class TreadTriatlo extends Thread{
	private int competidor;
	private Semaphore armasDisponiveis;
	private long tempoInicio;
	private long tempoFim;
	
	public TreadTriatlo(int competidor, Semaphore armasDisponiveis){
		this.competidor = competidor;
		this.armasDisponiveis = armasDisponiveis;
		this.tempoInicio = 0;
		this.tempoFim = 0;
	}
	
	public void corrida(){
		
		int metros = 0;
		
		while(metros < 5000){
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int metrosAgora = (int)(Math.random()*5 + 20);
			
			metros += metrosAgora;
			
			System.out.println("O atleta "+ competidor + " correu " + metrosAgora + " e está com " + metros + " percorridos!");
		}	
	}
	
	public void natacao(){
		
		int metros = 0;
		
		while(metros < 1000){
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int metrosAgora = (int)(Math.random()*4 + 10);
			
			metros += metrosAgora;
			
			System.out.println("O atleta "+ competidor + " nadou " + metrosAgora + " e está com " + metros + " percorridos!");
		}
	}
	
	public int tiro(){
		
		int tempo = (int)(Math.random()*100 + 200);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int pontuacao = (int)(Math.random()*5);
						
			System.out.println("O atleta "+ competidor + " fez pontuação " + pontuacao);
			
			return pontuacao*1000;
			
	}
	
	@Override
	public void run(){
		tempoInicio = System.currentTimeMillis();
		
			int tempoDescontado = 0;
			
			corrida();
			
			try{
				armasDisponiveis.acquire();
				tempoDescontado = tiro();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			} finally{
				armasDisponiveis.release();
			}
			
			natacao();
		
		tempoFim = System.currentTimeMillis();
		tempoFim -= tempoInicio - tempoDescontado;
		
		Triatlo.listar(tempoFim , competidor);
	}
}
