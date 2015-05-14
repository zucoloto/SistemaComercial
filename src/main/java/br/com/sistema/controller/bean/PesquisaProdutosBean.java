package br.com.sistema.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sistema.model.entity.Produto;
import br.com.sistema.model.repository.Produtos;
import br.com.sistema.model.repository.filter.ProdutoFilter;
import br.com.sistema.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	private Produto produtoSelecionado;
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;

	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();
	}

	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}

	public void excluir() {
		produtos.excluir(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getSku()
				+ " excluído com sucesso!");
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

}