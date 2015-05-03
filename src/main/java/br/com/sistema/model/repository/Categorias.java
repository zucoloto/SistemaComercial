package br.com.sistema.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.sistema.model.entity.Categoria;

public class Categorias implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}

	public List<Categoria> buscarCategoriaRaiz() {
		return em.createQuery("from Categoria", Categoria.class)
				.getResultList();
	}
}
