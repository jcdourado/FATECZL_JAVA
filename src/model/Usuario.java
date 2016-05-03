package model;

import java.util.List;

public class Usuario {
	private int id;
	private String nome;
	private int userId;
	private String password;
	private String email;
	private List<Endereco> enderecos;
	private List<Telefone> telefones;
	private List<ProdutoComprado> produtosComprados;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<ProdutoComprado> getProdutosComprados() {
		return produtosComprados;
	}
	public void setProdutosComprados(List<ProdutoComprado> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}
}
