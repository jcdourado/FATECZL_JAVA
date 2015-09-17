import javax.swing.JOptionPane;
public class Exemplo1 {

	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Digite seu nome");
		int numeroInt = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		double numeroDouble = Double.parseDouble(JOptionPane.showInputDialog("Digite um numero"));

		int numAleatorio = (int) (Math.random()*100);

		double result = numAleatorio * numeroInt * numeroDouble;

		JOptionPane.showMessageDialog(null, nome + " " + result);
	}

}
