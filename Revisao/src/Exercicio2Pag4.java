import javax.swing.JOptionPane;
public class Exercicio2Pag4 {
	public static void main(String args[]){
		int[] vetor = new int[6];

		for (int i = 0; i<6; i++){
			vetor[i] = 1 + (int) (Math.random() * 101);
		}

		for (int i = 0; i<6; i++){
			if(vetor[i]%2 == 0){
				JOptionPane.showMessageDialog(null, "N�mero par: " + vetor[i] );
				JOptionPane.showMessageDialog(null, "� par a posi��o de n�mero: " + i );
			}
			else{
				JOptionPane.showMessageDialog(null, "N�mero impar: " + vetor[i] );
				JOptionPane.showMessageDialog(null, "� impar a posi��o de n�mero: " + i );				
			}
		}
	}
}
