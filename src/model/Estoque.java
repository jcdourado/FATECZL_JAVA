package model;

import java.util.List;

public class Estoque {
	private List<ProdutoEmEstoque> listaProdutos;

	public List<ProdutoEmEstoque> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutoEmEstoque> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public void add(ProdutoEmEstoque p){
		listaProdutos.add(p);
	}
	
	public void remove(ProdutoEmEstoque p){
		listaProdutos.remove(p);
	}
}
