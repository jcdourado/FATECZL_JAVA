package controller;

import java.io.File;
import java.io.IOException;

public class controlador {
	
	public controlador(){
		super();
	}
	
	public void verificarDir(String dir) throws IOException{
		File diretorio = new File(dir);
		
		if(diretorio.exists() && diretorio.isDirectory()){
			buscaDir(diretorio);			
		}
		else{
			throw new IOException("Diretório inválido");
		}
	}
	
	
	public void buscaDir(File diretorio){
				
		File[] arquivos = diretorio.listFiles();
			
		for(File f : arquivos){
			
			if(f.isDirectory()){
				buscaDir(f);
			}
			
			else if(f.isFile()){
				int tamanho = (int) f.length() / 1000000;
				if(tamanho >= 256){
					System.out.println("Arquivo com mais de 256 MB's");
					System.out.println(f.getName());
					System.out.println(f.getAbsolutePath());
				}
			}
		}
		
		
	}
}
