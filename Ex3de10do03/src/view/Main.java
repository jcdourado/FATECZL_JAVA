package view;

import controller.OpPular;

public class Main {
	static int posi = 0;
	public static int posicao = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] sapos = new OpPular[5];
		int vencedor = 0;
		
		for(int i = 0 ; i < 5 ; i++){
			sapos[i] = new OpPular(i);
		}
		
		for(int i = 0 ; i < 5; i++){
			sapos[i].start();	
		}
		
	}
	
	public static int posicao(){
		posi++;
		return posi;
	}

}
