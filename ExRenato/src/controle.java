import javax.swing.JOptionPane;
import java.util.concurrent.Semaphore;

public class controle {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int  i = 1 ; i <= 4 ; i ++ ){
			Thread t = new TV(i, semaforo);
			t.start();
		}
	}
}
