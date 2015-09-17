package controller;

public class Calculos {
	
	public double primeiraMedia(String nome, double p1, double p2, double t){
		return (p1 * 0.35 + p2 * 0.35 + t * 0.3);
	}
	
	public String situacaoAluno(double media, boolean exame){
		if(exame){
			if(media>=6){
				return "Aprovado";
			}
			else{
				return "Reprovado";
			}
		}
		else{
			if(media >= 6){
				return "Aprovado";
			}
			else if(media >= 3 && media < 6){
				return "Exame";
			}
			else{
				return "Reprovado";
			}
		}
	}
	
	public double mediaExame(String nome, double media, double preExame, double exame){
		double condicao = media + preExame;
		if(condicao >= 6){
			return (condicao);
		}
		else{
			if((condicao + exame)/2 > 6){
				return 6;
			}
			else{
				return (condicao + exame)/2;
			}
		}
	}
}
