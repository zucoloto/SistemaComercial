package br.com.sistema.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sistema.model.entity.Pedido;
import br.com.sistema.model.entity.StatusPedido;
import br.com.sistema.model.repository.Pedidos;
import br.com.sistema.model.repository.filter.PedidoFilter;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;

	private PedidoFilter filtro;
	private List<Pedido> pedidosFiltrados;

	public PesquisaPedidosBean() {
		filtro = new PedidoFilter();
		pedidosFiltrados = new ArrayList<Pedido>();
	}

	public void pesquisar() {
		pedidosFiltrados = pedidos.filtrados(filtro);
	}

	public StatusPedido[] getStatuses() {
		return StatusPedido.values();
	}

	public PedidoFilter getFiltro() {
		return filtro;
	}

	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

}