/*
 * É uma calculadora!!!
 */

package controller;

public class ThreadCalc extends Thread {
	
	private int a;
	private int b;
	private int codigo;
	
	public ThreadCalc(int a, int b, int codigo){
		this.a = a;
		this.b = b;
		this.codigo = codigo;
	}

	private void calcula(){
		int resultado = 0;
		String op = "";
		switch (codigo) {
		case 0:
			resultado = a + b;
			op = "+";
			break;
		case 1:
			resultado = a - b;
			op = "-";
			break;
		case 2:
			resultado = a * b;
			op = "*";
			break;
		case 3:
			resultado = a / b;
			op = "/";
			break;
		default:
			resultado = a + b;
			op = "+";
			break;
		}
		System.out.println(a + " " + op + " " + b + " = " + resultado);
	}
	
	
	// botao direito, source, override etc...
	@Override
	public void run() {
		calcula();
	}
}
