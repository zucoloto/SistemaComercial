package teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.sistema.model.entity.Categoria;
import br.com.sistema.model.entity.Produto;

public class ProdutoCategoria {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("SistemaComercialPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		// instanciamos a categoria pai (Bebidas)
		Categoria categoriaPai = new Categoria();
		categoriaPai.setDescricao("Bebidas");

		// instanciamos a categoria filha (Refrigerantes)
		Categoria categoriaFilha = new Categoria();
		categoriaFilha.setDescricao("Refrigerantes");
		categoriaFilha.setCategoriaPai(categoriaPai);

		// adicionamos a categoria Refrigerantes como filha de Bebidas
		categoriaPai.getSubcategorias().add(categoriaFilha);

		// ao persistir a categoria pai (Refrigerantes), a filha (Bebidas)
		// deve ser persistida também
		manager.persist(categoriaPai);

		// instanciamos e persistimos um produto
		Produto produto = new Produto();
		produto.setCategoria(categoriaFilha);
		produto.setNomeProduto("Guaraná 2L");
		produto.setQuantidadeEstoque(10);
		produto.setSku("GUA00123");
		produto.setValorUnitario(new BigDecimal(2.21));

		manager.persist(produto);

		trx.commit();
		manager.close();
	}
}
