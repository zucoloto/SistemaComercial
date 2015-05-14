package br.com.sistema.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sistema.model.entity.Produto;
import br.com.sistema.model.repository.filter.ProdutoFilter;
import br.com.sistema.model.service.exception.NegocioException;
import br.com.sistema.util.jpa.Transactional;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Produto salvar(Produto produto) {
		return em.merge(produto);
	}

	@Transactional
	public void excluir(Produto produto) {
		try {
			produto = buscarPorId(produto.getId());
			em.remove(produto);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído!");
		}
	}

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
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

	@SuppressWarnings("unchecked")
	public List<Produto> filtrados(ProdutoFilter filtro) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);

		if (StringUtils.isNotBlank(filtro.getSku())) {
			criteria.add(Restrictions.eq("sku", filtro.getSku()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nomeProduto", filtro.getNome(),
					MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("nomeProduto")).list();
	}
}
