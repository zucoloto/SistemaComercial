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
		return em.createQuery(
				"from Categoria where categoriaPai is null order by descricao",
				Categoria.class).getResultList();
	}

	public List<Categoria> subcategoriasDe(Categoria categoriaPai) {
		return em
				.createQuery("from Categoria where categoriaPai = :raiz order by descricao",
						Categoria.class).setParameter("raiz", categoriaPai)
				.getResultList();
	}
}
