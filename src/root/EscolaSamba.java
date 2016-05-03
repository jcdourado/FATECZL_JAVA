package root;

import java.util.Date;

public class EscolaSamba {
	private int id;
	private String nome;
	private int numeroAlas;
	private int qtdComponentes;
	private float totalPontos;
	private Date apresentacao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroAlas() {
		return numeroAlas;
	}
	public void setNumeroAlas(int numeroAlas) {
		this.numeroAlas = numeroAlas;
	}
	public int getQtdComponentes() {
		return qtdComponentes;
	}
	public void setQtdComponentes(int qtdComponentes) {
		this.qtdComponentes = qtdComponentes;
	}
	public float getTotalPontos() {
		return totalPontos;
	}
	public void setTotalPontos(float totalPontos) {
		this.totalPontos = totalPontos;
	}
	public Date getApresentacao() {
		return apresentacao;
	}
	public void setApresentacao(Date apresentacao) {
		this.apresentacao = apresentacao;
	}
}
