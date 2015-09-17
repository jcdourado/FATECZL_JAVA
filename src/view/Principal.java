package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Principal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int verificador;
	public static String caminhoArquivo;
	private JPanel contentPane;
	private JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		verificador = 0;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */


	public Principal() {
		setTitle("Editor de textos");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(!(textArea.getText().equals(""))){
					int teclaDigitada = JOptionPane.showConfirmDialog(null, "Deseja desistir de todo o progresso?", "Salvar?", JOptionPane.OK_CANCEL_OPTION);
					if(teclaDigitada==JOptionPane.OK_OPTION){
						setVisible(false);
					}
					else{
						salvarComo();
						setVisible(false);
					}
				}
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 574, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Novo");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!(textArea.getText().equals(""))){
					int teclaDigitada = JOptionPane.showConfirmDialog(null, "Deseja desistir de todo o progresso?", "Salvar?", JOptionPane.OK_CANCEL_OPTION);
					if(teclaDigitada==JOptionPane.OK_OPTION){
						verificador = 0;
						textArea.setText("");
					}
					else{
						salvarComo();
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				verificador = 1;
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de texto (.txt)", "txt"); // filtro de extensão

				String diretorioBase = System.getProperty("user.home"); // daonde ele parte
				File dir = new File(diretorioBase); // pra setar daonde ele parte na janela
				
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(dir);
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false); // filtro de todos os arquivos
				chooser.addChoosableFileFilter(filtro); // setando o filtro
				
				caminhoArquivo = "";
				
				int retorno = chooser.showOpenDialog(null); // pode ser outro pra salvar
				
				if(retorno == JFileChooser.APPROVE_OPTION){
					caminhoArquivo = chooser.getSelectedFile().getAbsolutePath(); // caminho completo
					
					StringBuffer buffer = new StringBuffer();
					
					try {
						FileInputStream abreArq = new FileInputStream(chooser.getSelectedFile());
						InputStreamReader fluxo = new InputStreamReader(abreArq);
						BufferedReader bufferLeitura = new BufferedReader(fluxo);
						
						String linha = bufferLeitura.readLine();
						
						while(linha!=null){
							buffer.append(linha);
							buffer.append("\n");
							
							linha = bufferLeitura.readLine();

						}
						
						bufferLeitura.close();
						fluxo.close();
						abreArq.close();
						
						textArea.setText(buffer.toString());
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		mnNewMenu.add(mntmAbrir);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(verificador==0){
					salvarComo();
				}
				else{
					try {
						if(caminhoArquivo.contains(".txt")){
							BufferedWriter gravar = new BufferedWriter(new FileWriter(caminhoArquivo));
							gravar.write(textArea.getText());
							gravar.close();
						}
						else{
							BufferedWriter gravar = new BufferedWriter(new FileWriter(caminhoArquivo+".txt"));
							gravar.write(textArea.getText());
							gravar.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		mnNewMenu.add(mntmSalvar);
		
		JMenuItem mntmSalvarComo = new JMenuItem("Salvar como...");
		mntmSalvarComo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				salvarComo();
			}
		});
		mnNewMenu.add(mntmSalvarComo);
		
		JMenu mnNewMenu_2 = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmLimpar = new JMenuItem("Limpar");
		mntmLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textArea.setText("");
			}
		});
		mnNewMenu_2.add(mntmLimpar);
		
		JMenu mnNewMenu_3 = new JMenu("Sobre");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmAEquipe = new JMenuItem("Desenvolvedor");
		mntmAEquipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Desenvolvido por Julio Cezar", "Desenvolvedor", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_3.add(mntmAEquipe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 554, 410);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	
	public void salvarComo(){
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de texto (.txt)", "txt"); // filtro de extensão
		
		String diretorioBase = System.getProperty("user.home"); // daonde ele parte
		File dir = new File(diretorioBase); // pra setar daonde ele parte na janela
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(dir);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false); // filtro de todos os arquivos
		chooser.addChoosableFileFilter(filtro); // setando o filtro
		
		chooser.showSaveDialog(textArea);
		
		caminhoArquivo = chooser.getSelectedFile().getAbsolutePath();
		File arquivo = new File(caminhoArquivo+".txt");

		String caminho = chooser.getSelectedFile().getParent();
		File diretorio = new File(caminho);
		
		File[] files = diretorio.listFiles();
		
		int opc= JOptionPane.OK_OPTION;
		
		for(File f : files){
			if(f.equals(arquivo)){
				opc = JOptionPane.showConfirmDialog(null, "Há um arquivo com o mesmo nome, deseja sobrescrever?", "Erro!", JOptionPane.OK_CANCEL_OPTION);
			}
		}
		
		if(opc==JOptionPane.OK_OPTION){
			FileWriter abreArquivo;
			try {
				abreArquivo = new FileWriter(arquivo, false);
				PrintWriter gravaArquivo = new PrintWriter(abreArquivo);
				gravaArquivo.write(textArea.getText());
				gravaArquivo.flush(); // se tiver algum problema na escrita, ele força a escrita
				gravaArquivo.close();
				abreArquivo.close();
				verificador = 1;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
