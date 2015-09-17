package view;

import java.io.File;
import java.io.IOException;

import controller.controlador;

public class Principal {

	public static void main(String[] args) {
		String diretorio = "E:"+ File.separator + "Julio";
		
		controlador ctr = new controlador();
		
		try {
			ctr.verificarDir(diretorio);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
