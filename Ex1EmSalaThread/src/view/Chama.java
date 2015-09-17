package view;

import controller.ThreadControl;

public class Chama {

	public static void main(String[] args) {
		
		for(int id = 0; id < 10 ; id++){
			Thread t = new ThreadControl(id);
			
			// da o start msm, nao chama o run direto
			t.start();
		}
	}
	
}
