package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.sistema.model.entity.Cliente;
import br.com.sistema.model.entity.EnderecoCliente;
import br.com.sistema.model.entity.TipoPessoa;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SistemaComercialPU");
		EntityManager manager = managerFactory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setNomeCliente("Joao das Couves2");
		cliente.setEmail("couves@gmail.com");
		cliente.setDocumentoReceitaFederal("034");
		cliente.setTipo(TipoPessoa.FISICA);
		
		EnderecoCliente endereco = new EnderecoCliente();
		endereco.setLogradouro("Rua");
		endereco.setNumero("1");
		endereco.setComplemento("Ap");
		endereco.setCidade("BSA");
		endereco.setUf("DF");
		endereco.setCep("70");
		endereco.setCliente(cliente);
		
		cliente.getEnderecos().add(endereco);
		
		manager.persist(cliente);
		
		trx.commit();
	}
}
