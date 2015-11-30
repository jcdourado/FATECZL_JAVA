import java.util.ArrayList;
import java.util.List;


public class AlunoControle {
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adiciona(Aluno a){
		alunos.add(a);
	}
	
	public Aluno pesquisar(String nome){
		Aluno ret = null;
		for(Aluno a : alunos){
			if(a.getNome().contains(nome)){
				ret = a;
				break;
			}
		}
		return ret;
	}
}
