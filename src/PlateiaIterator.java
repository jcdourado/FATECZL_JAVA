
public class PlateiaIterator implements Iterator{
	private String[][] matriz;
	private int indiceGravadoCadeira = 0;
	private int indiceGravadoFileira = 0;
	private int indiceLeituraCadeira = 0;
	private int indiceLeituraFileira = 0;
	
	
	public PlateiaIterator(String[][] mat, int indFil, int indCad) {
		matriz = mat;
		indiceGravadoCadeira = indCad;
		indiceGravadoFileira = indFil;
	}
	
	@Override
	public boolean hasNext() {
		if(indiceLeituraFileira < indiceGravadoFileira){
			return true;
		}
		if(indiceLeituraFileira == indiceGravadoFileira){
			if(indiceLeituraCadeira < indiceGravadoCadeira){
				return true;
			}
		}
		return false;
	}

	@Override
	public String next() {
		String nome = null;
		if(hasNext()){
			if(indiceLeituraCadeira == 16){
				indiceLeituraCadeira=0;
				indiceLeituraFileira++;
			}
			nome = matriz[indiceLeituraFileira][indiceLeituraCadeira];
			indiceLeituraCadeira++;
		}
		return nome;
	}

}
