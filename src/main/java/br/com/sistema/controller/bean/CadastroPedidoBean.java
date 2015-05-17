package br.com.sistema.controller.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sistema.model.entity.EnderecoEntrega;
import br.com.sistema.model.entity.Pedido;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedido pedido;

	public CadastroPedidoBean() {
		limpar();
		
	}

	private void limpar() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
	}

	public void salvar() {

	}

	public Pedido getPedido() {
		return pedido;
	}

}