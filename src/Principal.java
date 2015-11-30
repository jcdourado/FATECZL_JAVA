
public class Principal {

	public static void main(String[] args) {
		Pessoa maria = new Pessoa();
		Pessoa joao = new Pessoa();
		Pessoa josa = new Pessoa();
		Pessoa luis = new Pessoa();
		Pessoa augusto = new Pessoa();
		
		Vejo veja = new Vejo();
		Vejo superInteressante = new Vejo();
		Vejo globo = new Vejo();
		
		veja.adicionar(maria);
		veja.adicionar(joao);
		superInteressante.adicionar(josa);
		superInteressante.adicionar(luis);
		globo.adicionar(augusto);
		
		globo.publicar("Dilma");
		veja.publicar("kkk");
		
	}

}
