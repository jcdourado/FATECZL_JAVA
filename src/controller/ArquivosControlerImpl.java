package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import model.pessoa;

public class ArquivosControlerImpl implements ArquivosControler{

	public ArquivosControlerImpl(){
		super();
	}
	
	private void conteudoArquivo(String nome, String caminho) throws IOException{
		File dir = new File(caminho);
		
		boolean existe = false;
		
		if(dir.exists()){
			File arquivo = new File(caminho, nome);
			if(arquivo.exists()){
				existe = true;
			}
			
			StringBuffer buffer = new StringBuffer();
			
			int proximo = JOptionPane.OK_OPTION;
			
			while(proximo == JOptionPane.OK_OPTION){
				
				pessoa p = new pessoa();
				
				String cpf = JOptionPane.showInputDialog(null, "Digite CPF", "CPF", JOptionPane.INFORMATION_MESSAGE);
				String nomePessoa = JOptionPane.showInputDialog(null, "Digite Nome", "Nome", JOptionPane.INFORMATION_MESSAGE);
				String telefone = JOptionPane.showInputDialog(null, "Digite Telefone", "Telefone", JOptionPane.INFORMATION_MESSAGE);
				
				if(cpf == null || nomePessoa == null || telefone == null){
					JOptionPane.showMessageDialog(null, "Dados Inválidos!", "Erro" , JOptionPane.ERROR_MESSAGE);
				}
				
				else{
					
					if(cpf.trim().equals("") || nomePessoa.trim().equals("") || telefone.trim().equals("")){
						JOptionPane.showMessageDialog(null, "Dados Inválidos!", "Erro" , JOptionPane.ERROR_MESSAGE);
					}
					
					else{
						p.setCPF(cpf);
						p.setNome(nomePessoa);
						p.setTelefone(telefone);
						buffer.append(p.getCPF());
						buffer.append(";");
						buffer.append(p.getNome());
						buffer.append(";");
						buffer.append(p.getTelefone());
						buffer.append("\r\n"); // /r é pro bloco de notas 
					}
				}
				
				proximo = JOptionPane.showConfirmDialog(null, "Próximo", "Próxima pessoa", JOptionPane.OK_CANCEL_OPTION);
			}
			// o existe serve para que não seja necessário pegar todos os dados dentro do arquivo e 
			// manipula-lo, assim ele apenas da o append se o arquivo existe, se não, ele apenas o cria e escreve
			FileWriter abreArquivo = new FileWriter(arquivo, existe);
			PrintWriter gravaArquivo = new PrintWriter(abreArquivo);
			gravaArquivo.write(buffer.toString());
			gravaArquivo.flush(); // se tiver algum problema na escrita, ele força a escrita
			gravaArquivo.close();
			abreArquivo.close();
		}
		else{
			throw new IOException("Diretório inválido!");
		}
	}
	
	private String pegaConteudo(File arquivo) throws IOException {
		StringBuffer buffer = new StringBuffer();
		
		if(arquivo.exists() && arquivo.isFile()){
			
			FileInputStream abreArquivo = new FileInputStream(arquivo);
			InputStreamReader leFluxo = new InputStreamReader(abreArquivo);
			BufferedReader bufferLeitura = new BufferedReader(leFluxo);
			
			String linha = bufferLeitura.readLine();
			
			while(linha!=null){
				
				if(arquivo.getName().contains("cvs")){
					String[] vetorLinha = linha.split(";");
					buffer.append("CPF: ");
					buffer.append(vetorLinha[0]);
					buffer.append("Nome: ");
					buffer.append(vetorLinha[1]);
					buffer.append("Telefone: ");
					buffer.append(vetorLinha[2]);
					buffer.append("\n");
					buffer.append("----------------------------------------------");
					buffer.append("\n");
				}
				else{
					buffer.append(linha);
					buffer.append("\n");
				}
				
				linha = bufferLeitura.readLine(); 
			}
			bufferLeitura.close();
			leFluxo.close();
			abreArquivo.close();
		
		}
		
		else{
			throw new IOException("Arquivo Inválido!"); 
		}
		
		return buffer.toString();
	}
	
	public void leArquivo(String caminhoCompleto) throws IOException {
		File arquivo = new File(caminhoCompleto);
		String conteudo = pegaConteudo(arquivo);
		System.out.println(conteudo);
	}
	
	public void gravaArquivo(String nome, String caminho) throws IOException {
		conteudoArquivo(nome, caminho);
	}
	
	public void listaDir(String diretorio) throws IOException {
		
		File dir = new File(diretorio);

		if(dir.exists() && dir.isDirectory()){
			
			File[] listaArquivos = dir.listFiles();
			
			for(File f : listaArquivos){
				if(f.isDirectory()){
					System.out.println("["+f.getName()+"]");
				}
			}
			
			for(File f : listaArquivos){
				if(f.isFile()){
					System.out.println(f.getName());
				}
			}
		}
		else{
			throw new IOException("Diretório inválido"); 
		}
	}
	
}
