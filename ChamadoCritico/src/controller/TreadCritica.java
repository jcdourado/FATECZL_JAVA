package controller;

public class TreadCritica extends Thread{

	private int idThread;
	private static float x;
	
	public TreadCritica(int idThread){
		this.idThread = idThread;
	}

	
	private void conta(){
		if(idThread % 2 == 0){
			for(int i = 1 ; i <= 10 ; i++){
				x = (float) (x + Math.pow(idThread, i));
				System.out.println(x);
			}
		}
		else{
			for( float i = 1 ; i <= 10 ; i++){
				x = x + (1 / i );
				System.out.println(x);
			}
		}
	}
	
	@Override
	public void run() {
		conta();
	}
}
