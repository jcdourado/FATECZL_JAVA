package model;

public class ProdutoComprado {
	private int id;
	private int idComprado;
	private int quantidade;
	private float custoUnitario;
	private float custoTotal;
	private float frete;
	private float impostos;
	private String estadoDestinoPedido;
	float precoFinal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdComprado() {
		return idComprado;
	}
	public void setIdComprado(int idComprado) {
		this.idComprado = idComprado;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getCustoUnitario() {
		return custoUnitario;
	}
	public void setCustoUnitario(float custoUnitario) {
		this.custoUnitario = custoUnitario;
	}
	public float getCustoTotal() {
		return custoTotal;
	}
	public void setCustoTotal(float custoTotal) {
		this.custoTotal = custoTotal;
	}
	public float getFrete() {
		return frete;
	}
	public void setFrete(float frete) {
		this.frete = frete;
	}
	public float getImpostos() {
		return impostos;
	}
	public void setImpostos(float impostos) {
		this.impostos = impostos;
	}
	public String getEstadoDestinoPedido() {
		return estadoDestinoPedido;
	}
	public void setEstadoDestinoPedido(String estadoDestinoPedido) {
		this.estadoDestinoPedido = estadoDestinoPedido;
	}
	public float getPrecoFinal() {
		return precoFinal;
	}
	public void setPrecoFinal(float precoFinal) {
		this.precoFinal = precoFinal;
	}
}
