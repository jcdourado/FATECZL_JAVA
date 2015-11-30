import java.util.ArrayList;
import java.util.List;


public class Vejo implements Revista {

	List<Assinante> assinantes = new ArrayList<Assinante>();
	
	public void adicionar(Assinante a) {
		// TODO Auto-generated method stub
		assinantes.add(a);
	}

	public void remover(Assinante a) {
		// TODO Auto-generated method stub
		assinantes.remove(a);
	}

	public void publicar(String artigo) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < assinantes.size(); i ++){
			Assinante a = assinantes.get(i);
			a.ler(artigo);
		}
	}

}
