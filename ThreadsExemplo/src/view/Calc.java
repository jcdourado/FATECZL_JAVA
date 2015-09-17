/*
 * Menu da calculadora
 */

package view;

import controller.ThreadCalc;

public class Calc {

	public static void main(String[] args){
		int a = 100, b = 10;
		
		for(int codigo = 0; codigo < 4; codigo++){
			
			// pode ser outro nome do construtor, porem deve ter o extends
			Thread t = new ThreadCalc(a, b, codigo);
			
			t.start();			
		}	
	}
}
