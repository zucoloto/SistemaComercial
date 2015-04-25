package br.com.sistema.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PesquisaProdutosBean {

	private List<Integer> produtosFiltrados;

	public PesquisaProdutosBean() {
		produtosFiltrados = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			produtosFiltrados.add(i);
		}
	}

	public List<Integer> getProdutosFiltrados() {
		return produtosFiltrados;
	}

}