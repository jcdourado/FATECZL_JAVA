import javax.swing.JOptionPane;
public class Exercicio1Pag3 {
	public static void main(String[] args){
		String nome = JOptionPane.showInputDialog("Digite seu nome");
		double nota1= Integer.parseInt(JOptionPane.showInputDialog("Digite sua nota 1"));
		double nota2= Integer.parseInt(JOptionPane.showInputDialog("Digite sua nota 2"));
		double nota3= Integer.parseInt(JOptionPane.showInputDialog("Digite sua nota 3"));

		double media = 0.3 * nota1 + 0.5 * nota2 + 0.2 *nota3;
		
		if(media>=6){
			JOptionPane.showMessageDialog(null, nome +" Aprovado");
		}
		else if(media>=3 && media <6){
			JOptionPane.showMessageDialog(null, nome +" Exame");
		}
		else{
			JOptionPane.showMessageDialog(null, nome + " Reprovado");
		}
	}
}
