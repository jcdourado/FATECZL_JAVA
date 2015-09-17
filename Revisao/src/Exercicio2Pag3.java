import javax.swing.JOptionPane;
public class Exercicio2Pag3 {
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Digite seu nome");
		int diaN= Integer.parseInt(JOptionPane.showInputDialog("Digite seu dia de nascimento"));
		int mesN= Integer.parseInt(JOptionPane.showInputDialog("Digite seu mês de nascimento"));
		int anoN= Integer.parseInt(JOptionPane.showInputDialog("Digite seu ano de nascimento"));
		int diaA= Integer.parseInt(JOptionPane.showInputDialog("Digite o dia atual"));
		int mesA= Integer.parseInt(JOptionPane.showInputDialog("Digite o mes atual"));
		int anoA= Integer.parseInt(JOptionPane.showInputDialog("Digite o ano atual"));
		int mes = 0;
		int anos = 0;
		
		int dias = diaA - diaN;
		if(dias >= 0){
			mes = mesA - mesN;
		}
		else {
			mes = mesA - mesN - 1;
		}

		if(mes>=0){
			anos = anoA - anoN;
		}
		else{
			anos = anoA - anoN - 1;
		}

		JOptionPane.showMessageDialog(null, nome + " tem " + anos + " de idade");

	}
}
