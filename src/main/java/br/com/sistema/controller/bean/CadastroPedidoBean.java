package br.com.sistema.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.sistema.service.NegocioException;

@Named
@RequestScoped
public class CadastroPedidoBean {

	private List<Integer> itens;

	public CadastroPedidoBean() {
		itens = new ArrayList<>();
		itens.add(1);
	}

	public void salvar() {
		throw new NegocioException(
				"Pedido não pode ser salvo, pois ainda não foi implementado.");
	}

	public List<Integer> getItens() {
		return itens;
	}

}