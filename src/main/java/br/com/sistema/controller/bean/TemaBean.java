package br.com.sistema.controller.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TemaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String temaSelecionado = "bootstrap";

	public List<String> getTemasDisponiveis() {
		return Arrays.asList("afterdark", "afterwork", "aristo", "bootstrap", "vader");
	}

	public String getTemaSelecionado() {
		return temaSelecionado;
	}

	public void setTemaSelecionado(String temaSelecionado) {
		this.temaSelecionado = temaSelecionado;
	}

}