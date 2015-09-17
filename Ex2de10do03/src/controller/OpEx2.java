package controller;

public class OpEx2 extends Thread{
	private int soma;
	private int[][] valores;
	private int posicao;
	
	public OpEx2(int[][] valores, int posicao){
		this.valores = valores;
		this.soma = 0;
		this.posicao = posicao;
	}

	public void somar(){
			for(int y = 0 ; y < 5 ; y++){
				soma += valores[posicao][y];
			}
			
			System.out.println("Linha: " + posicao + "\nValor: " +soma);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		somar();
	}
	
	
}
