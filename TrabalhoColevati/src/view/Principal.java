package view;

import controller.*;
import javax.swing.JOptionPane;
public class Principal {

	public static void main(String[] args) {
		int opc = 9;
		Calculos a = new Calculos();
		
		while(opc!=0){
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite sua escolha:\n 1 - Primeira Média\n 2 - Situação\n 3 - Média Exame\n 0 - Sair"));
			switch(opc){
			
				case 1:
					String nome = JOptionPane.showInputDialog("Digite seu nome");
					double p1 = Double.parseDouble(JOptionPane.showInputDialog("Digite sua primeira nota"));
					double p2 = Double.parseDouble(JOptionPane.showInputDialog("Digite sua segunda nota"));
					double t = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota do seu trabalho"));
					JOptionPane.showMessageDialog(null, "Aluno: " + nome + "\nMedia: " + a.primeiraMedia(nome, p1, p2, t));
					break;
					
				case 2: 
					double media = Double.parseDouble(JOptionPane.showInputDialog("Digite sua media"));
					boolean exame = Boolean.parseBoolean(JOptionPane.showInputDialog("Fez exame? : \n false - Não \n true - Sim"));
					JOptionPane.showMessageDialog(null, a.situacaoAluno(media, exame));
					break;
					
				case 3:
					String nomeAluno = JOptionPane.showInputDialog("Digite seu nome");
					double mediaAluno = Double.parseDouble(JOptionPane.showInputDialog("Digite sua media"));
					double preExame = Double.parseDouble(JOptionPane.showInputDialog("Digite sua nota de pré - exame (caso não tenha feito o pré - exame, coloque 0)"));
					double exameAluno = Double.parseDouble(JOptionPane.showInputDialog("Digite sua nota de exame (caso não tenha feito o exame, coloque 0)"));
					JOptionPane.showMessageDialog(null, "Aluno: " + nomeAluno + "\nMedia: " + a.mediaExame(nomeAluno, mediaAluno, preExame, exameAluno));
					break;
					
				case 0: System.exit(0); break;
				
				default: JOptionPane.showMessageDialog(null, "Opção Inválida"); break;
			}
		}
	}
}
