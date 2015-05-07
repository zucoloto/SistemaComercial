package br.com.sistema.model.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import br.com.sistema.model.entity.Produto;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Produto salvar(Produto produto) {
		EntityTransaction trx = em.getTransaction();
		trx.begin();

		produto = em.merge(produto);

		trx.commit();

		return produto;
	}

	public Produto porSku(String sku) {
		try {
			return em
					.createQuery("from Produto where upper(sku) = :sku",
							Produto.class)
					.setParameter("sku", sku.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
