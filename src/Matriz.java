
public class Matriz implements Agregada{
	private String[][] matriz = new String[16][16];
	private int fileira = 0;
	private int cadeira = 0;
	
	public void adicionar(String nome){
		cadeira++;
		if(fileira <= 16 && cadeira <= 16){
			matriz[fileira][cadeira -1] = nome;
		}
		if(cadeira == 16){
			fileira++;
			cadeira=0;
		}
	}

	@Override
	public Iterator createIterator() {
		return (new PlateiaIterator(matriz, fileira, cadeira));
	}
	
	public static void main(String[] args) {
		Matriz mat = new Matriz();
		mat.adicionar("Julio");
		mat.adicionar("Luana");
		mat.adicionar("Matheus");
		mat.adicionar("Mario");
		mat.adicionar("Lucas");
		mat.adicionar("João");
		mat.adicionar("Julio");
		mat.adicionar("Luana");
		mat.adicionar("Matheus");
		mat.adicionar("Mario");
		mat.adicionar("Lucas");
		mat.adicionar("João");
		mat.adicionar("Julio");
		mat.adicionar("Luana");
		mat.adicionar("Matheus");
		mat.adicionar("Mario");
		mat.adicionar("Lucas");
		mat.adicionar("João");
		mat.adicionar("Julio");
		mat.adicionar("Luana");
		mat.adicionar("Matheus");
		mat.adicionar("Mario");
		mat.adicionar("Lucas");
		mat.adicionar("João");
		mat.adicionar("Julio");
		mat.adicionar("Luana");
		mat.adicionar("Matheus");
		mat.adicionar("Mario");
		mat.adicionar("Lucas");
		mat.adicionar("João");
		mat.adicionar("Julio");
		mat.adicionar("Luana");
		mat.adicionar("Matheus");
		mat.adicionar("Mario");
		mat.adicionar("Lucas");
		mat.adicionar("João");
		
		Iterator i = mat.createIterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
