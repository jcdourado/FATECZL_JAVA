package controller;

public class ThreadControl extends Thread{
	private int id;
	
	public ThreadControl(int id){
		this.id = id;
	}

	private void exibir(){
		System.out.println("Thread #" + id);
	}
	
	// nao chama o run direto
	@Override
	public void run() {
		exibir();
	}		
}
