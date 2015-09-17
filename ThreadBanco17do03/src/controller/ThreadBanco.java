package controller;

import java.util.concurrent.Semaphore;

public class ThreadBanco extends Thread{
	private int conta;
	private int transacao;
	private Semaphore semaforoDeposito;
	private Semaphore semaforoSaque;
	private int valorConta;
	
	public ThreadBanco(int conta,int transacao, Semaphore semaforoDeposito, Semaphore semaforoSaque){
		this.conta = conta;
		this.transacao = transacao;
		this.semaforoDeposito = semaforoDeposito;
		this.semaforoSaque = semaforoSaque;		
		this.valorConta = 1000;
	}
	
	public void deposita(){
		int deposito = (int)(Math.random() * 100 + 1);
		valorConta += deposito;
		System.out.println("Foram depositados "+ deposito + " na conta " + conta + "e tem agora " + valorConta);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saca(){
		int saque = (int)(Math.random() * 100 + 1);
		valorConta -= saque;
		System.out.println("Foram sacados "+ saque + " da conta " + conta + "e tem agora " + valorConta);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Override
	public void run(){
		switch (transacao){
			case 0: 
				try{
					semaforoDeposito.acquire();
					deposita();
				} catch(InterruptedException e){
					e.printStackTrace();
				} finally {
					semaforoDeposito.release();
				}
				break;
				
			case 1: 				
				try{
					semaforoSaque.acquire();
					saca();
				} catch(InterruptedException e){
					e.printStackTrace();
				} finally {
					semaforoSaque.release();
				}
				break;
			default: break;
		}
		
	}
	
	
}
