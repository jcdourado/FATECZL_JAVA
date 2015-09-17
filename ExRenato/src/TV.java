import java.util.concurrent.Semaphore;


public class TV extends Thread {
	private Semaphore semaforo;
	private int resultado;
	private int idThread;
	
	public TV(int i, Semaphore semaforo) {
		this.idThread = i;
		this.semaforo = semaforo;
	}

	public int conta(int num){
		if (num == 0){
			return 1;
		}
		
		return num * conta(num - 1);
	}
	
	public void mostra(){
		try{
			semaforo.acquire();
			resultado = conta(idThread);
			System.out.println(idThread + " " + resultado);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		finally{
			semaforo.release();
		}
	}
	
	public void run(){
		mostra();
	}
}