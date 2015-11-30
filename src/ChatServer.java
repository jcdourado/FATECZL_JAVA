import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	public ChatServer(){
		ServerSocket server;
		try {
			server = new ServerSocket(4000);
			while(true){
				Socket cliente = server.accept();
				new Thread(new Monitor(cliente)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class Monitor implements Runnable {
		Scanner scn;
		
		public Monitor(Socket s){
			try {
				scn = new Scanner(s.getInputStream());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		public void run() {
			String texto;
			while((texto = scn.nextLine()) != null){
				System.out.println("Recebido" + texto);
			}
			
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}
}
