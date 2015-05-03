package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.sistema.model.entity.Cliente;
import br.com.sistema.model.entity.EnderecoCliente;
import br.com.sistema.model.entity.TipoPessoa;

public class ClienteEndereco {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("SistemaComercialPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Cliente cliente = new Cliente();
		cliente.setNomeCliente("BIGBOX");
		cliente.setEmail("bigbox@gmail.com");
		cliente.setDocumentoReceitaFederal("034");
		cliente.setTipo(TipoPessoa.JURIDICA);

		EnderecoCliente endereco = new EnderecoCliente();
		endereco.setLogradouro("SQCN 105/106");
		endereco.setNumero("s/nº");
		endereco.setComplemento("Bloco A");
		endereco.setCidade("Brasília");
		endereco.setUf("DF");
		endereco.setCep("70740-000");
		endereco.setCliente(cliente);

		cliente.getEnderecos().add(endereco);

		manager.persist(cliente);

		trx.commit();
		manager.close();
	}
}
