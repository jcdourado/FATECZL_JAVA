import javax.swing.JOptionPane;
public class Exercicio3Pag5 {
	public static void main(String[] args) {
		int vetor[] = new int[20];
		int num = 0, contador = 0;
		for(int i = 0; i<20; i++){
			vetor[i] = (int) (Math.random()*20);
		}
		
		for(num = 0; num<20; num++){
			for(int i = 0; i<20; i++){
			
				if(num == vetor[i]){
					contador++;
				}
			}
			if(contador>0){
				JOptionPane.showMessageDialog(null, "O valor "+ num + " foi repetido " +contador + " vezes" );
				contador = 0;
			}
		}
	}
}
