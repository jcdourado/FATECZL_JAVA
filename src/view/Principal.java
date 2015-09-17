package view;

import java.io.File;
import java.io.IOException;

import controller.ArquivosControler;
import controller.ArquivosControlerImpl;

public class Principal {

	public static void main(String[] args)  {
		String diretorio = System.getProperty("user.home")// diretorio do usuario
		+ File.separator +"desktop";
		
		ArquivosControlerImpl arqControler = new ArquivosControlerImpl();
		try {
//			arqControler.listaDir(diretorio);
			String nomeArquivo = "teste1.csv";
			arqControler.leArquivo(diretorio+ File.separator + nomeArquivo);
			
//			arqControler.gravaArquivo(nomeArquivo, diretorio);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
