package br.com.sistema.model.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.sistema.model.entity.Produto;
import br.com.sistema.model.repository.Produtos;
import br.com.sistema.model.service.exception.NegocioException;
import br.com.sistema.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtos.porSku(produto.getSku());

		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException(
					"Já existe um produto com o SKU informado.");
		}

		return produtos.salvar(produto);
	}
}
