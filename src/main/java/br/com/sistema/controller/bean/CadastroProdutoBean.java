package br.com.sistema.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.sistema.model.entity.Categoria;
import br.com.sistema.model.entity.Produto;
import br.com.sistema.model.repository.Categorias;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	private Produto produto;
	private Categoria categoriaPai;
	private List<Categoria> categoriaRaiz;

	public CadastroProdutoBean() {
		produto = new Produto();
	}

	public void init() {
		categoriaRaiz = categorias.buscarCategoriaRaiz();
	}

	public void salvar() {
		System.out.println("Categoria Pai: " + categoriaPai.getDescricao());
	}

	public Produto getProduto() {
		return produto;
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

}
