package br.com.sistema.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sistema.model.entity.Cliente;
import br.com.sistema.model.entity.EnderecoCliente;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private EnderecoCliente endereco;
	private List<EnderecoCliente> enderecos;

	public CadastroClienteBean() {
		cliente = new Cliente();
		endereco = new EnderecoCliente();
	}

	public void salvar() {
	}
	
	public void adicionarEndereco() {
		cliente.getEnderecos().add(endereco);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<EnderecoCliente> getEnderecos() {
		return enderecos;
	}

}
