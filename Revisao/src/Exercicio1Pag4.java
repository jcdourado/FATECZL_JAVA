import javax.swing.JOptionPane;
public class Exercicio1Pag4 {
	public static void main(String args[]){
		int[] vetor = new int[50];
		int cont = 101;

		for(int i = 0; i < 50; i++){
			vetor[i] = cont;
			cont++;
		}

		for(int i = 0; i<50; i++){
			JOptionPane.showMessageDialog(null, vetor[i]);
		}		
	}
}
