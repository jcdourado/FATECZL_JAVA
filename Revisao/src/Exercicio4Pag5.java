import javax.swing.JOptionPane;
public class Exercicio4Pag5 {
	public static void main(String[] args) {
		int vetorOri[] = new int[500];
		int vetorDiv[] = new int[500];
		int maior = 0;
		
		for(int i = 0; i<vetorOri.length; i++){
			vetorOri[i] = (int) (Math.random() * 51);
			if(i==0){
				maior = vetorOri[i];
			}
			else{
				if(vetorOri[i]>maior){
					maior = vetorOri[i];
				}
			}
		}
		
		for(int i = 0; i<vetorDiv.length ; i++){
			vetorDiv[i] = vetorOri[i] / maior;
			JOptionPane.showMessageDialog(null, vetorDiv[i]);
		}
	}
}
