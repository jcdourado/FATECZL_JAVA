package br.fatec.servico;

public class Calculadora {
	
	public int somar(String texto){
		int result = 0;
		String[] array = texto.split(",");
		
		for(String num : array){
			result += Integer.parseInt(num);
		}
		
		return result;
	}
	
}
