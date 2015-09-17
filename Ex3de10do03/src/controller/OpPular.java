package controller;
import view.Main;

public class OpPular extends Thread{
	private int num;
	private int salto;
	private int percorrido;
		
	public OpPular(int num){
		this.num = num;
		this.percorrido = 0;
		this.salto = 0;
	}

	public void salta(){
		
		while(percorrido<100){
			salto = (int)(Math.random()*20);
			percorrido += salto;
			
			if(percorrido>100){
				verifica();
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				System.out.println("O sapo " + num + " saltou : "+ salto + " e ja percorreu " + percorrido);
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
		public void verifica(){
				int posicao = Main.posicao();
				System.out.println("\nO sapo " + num + " chegou em " + posicao + "º lugar e percorreu :" + percorrido +"\n");
		}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		salta();
	}
		
}
