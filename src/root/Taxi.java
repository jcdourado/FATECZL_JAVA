package root;

import java.util.Date;

public class Taxi{
	private String registro;
	private String alvara;
	private String cnh;
	private Date validade;
	private String nome;

	public Taxi() {
		super();
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getAlvara() {
		return alvara;
	}
	public void setAlvara(String alvara) {
		this.alvara = alvara;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
