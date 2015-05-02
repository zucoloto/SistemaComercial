package br.com.sistema.controller.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sistema.model.entity.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;

	public CadastroProdutoBean() {
		produto = new Produto();
	}

	public void salvar() {
	}

	public Produto getProduto() {
		return produto;
	}

}
