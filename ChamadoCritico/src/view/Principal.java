package view;

import controller.TreadCritica;

public class Principal {

	public static void main(String[] args) {
		for ( int i = 2 ; i < 4 ; i++ ){
			Thread t = new TreadCritica(i);
			t.start();
		}
	}

}