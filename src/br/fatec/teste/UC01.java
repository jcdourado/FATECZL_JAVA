package br.fatec.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.fatec.servico.Calculadora;

public class UC01 {

	static Calculadora calculadora;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calculadora = new Calculadora();
	}

	@Test
	public void CT01_dados_validos() {
		assertEquals("Resultado:", 35, calculadora.somar("15,15,5"));		
	}
	
	@Test(expected = RuntimeException.class)
	public void CT02_dados_invalidos(){
		assertEquals("Resultado:", 35, calculadora.somar("x"));		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}