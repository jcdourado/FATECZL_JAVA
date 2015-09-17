package view;

import controller.OpEx2;

public class main {
	public static void main(String args[]){
		int[][] matriz = new int[3][5];
		
		for(int x = 0 ; x < 3 ; x++){
			for(int y = 0 ; y < 5 ; y++){
				matriz[x][y] = (int)(Math.random()*100+1);
			}
		}
		
		
		for(int i = 0 ; i < 3 ; i++){
			Thread t = new OpEx2(matriz, i);
			t.start();
		}
		
	}
}
