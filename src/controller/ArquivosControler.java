package controller;

import java.io.IOException;

public interface ArquivosControler {
	public void leArquivo(String caminhoCompleto) throws IOException;
	public void gravaArquivo(String nome, String caminho) throws IOException;
	public void listaDir(String diretorio) throws IOException;
}
