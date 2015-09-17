import javax.swing.JOptionPane;
public class Exercicio2Pag4 {
	public static void main(String args[]){
		int[] vetor = new int[6];

		for (int i = 0; i<6; i++){
			vetor[i] = 1 + (int) (Math.random() * 101);
		}

		for (int i = 0; i<6; i++){
			if(vetor[i]%2 == 0){
				JOptionPane.showMessageDialog(null, "Número par: " + vetor[i] );
				JOptionPane.showMessageDialog(null, "É par a posição de número: " + i );
			}
			else{
				JOptionPane.showMessageDialog(null, "Número impar: " + vetor[i] );
				JOptionPane.showMessageDialog(null, "É impar a posição de número: " + i );				
			}
		}
	}
}
