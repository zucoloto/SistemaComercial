package br.com.sistema.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.sistema.model.entity.Categoria;
import br.com.sistema.model.entity.Produto;
import br.com.sistema.model.repository.Categorias;
import br.com.sistema.model.service.CadastroProdutoService;
import br.com.sistema.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;

	@Inject
	private CadastroProdutoService cadastroProdutoService;

	private Produto produto;
	private Categoria categoriaPai;
	private List<Categoria> categoriaRaiz;
	private List<Categoria> subcategorias;

	public CadastroProdutoBean() {
		limpar();
	}

	public void init() {
		if (FacesUtil.isNotPostback()) {
			categoriaRaiz = categorias.buscarCategoriaRaiz();

			if (this.categoriaPai != null) {
				carregarSubcategorias();
			}
		}
	}

	public void carregarSubcategorias() {
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}

	private void limpar() {
		produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();
	}

	public void salvar() {
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();

		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}

	public boolean isEditando() {
		return this.produto.getId() != null;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;

		if (this.produto != null) {
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategoriaRaiz() {
		return categoriaRaiz;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

}
