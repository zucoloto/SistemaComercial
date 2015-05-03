package teste;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.sistema.model.entity.Cliente;
import br.com.sistema.model.entity.EnderecoEntrega;
import br.com.sistema.model.entity.FormaPagamento;
import br.com.sistema.model.entity.ItemPedido;
import br.com.sistema.model.entity.Pedido;
import br.com.sistema.model.entity.Produto;
import br.com.sistema.model.entity.StatusPedido;
import br.com.sistema.model.entity.Usuario;

public class PedidoItens {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("SistemaComercialPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Cliente cliente = manager.find(Cliente.class, 1L);
		Produto produto = manager.find(Produto.class, 1L);
		Usuario vendedor = manager.find(Usuario.class, 1L);

		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		enderecoEntrega.setLogradouro("SQN 306 - Bloco B");
		enderecoEntrega.setNumero("s/nº");
		enderecoEntrega.setCidade("Brasília");
		enderecoEntrega.setUf("DF");
		enderecoEntrega.setCep("70745-020");

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacao(new Date());
		pedido.setDataEntrega(new Date());
		pedido.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
		pedido.setObservacao("Aberto das 08 às 18h");
		pedido.setStatus(StatusPedido.ORCAMENTO);
		pedido.setValorDesconto(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);
		pedido.setValorTotal(new BigDecimal(23.2));
		pedido.setVendedor(vendedor);
		pedido.setEnderecoEntrega(enderecoEntrega);

		ItemPedido item = new ItemPedido();
		item.setProduto(produto);
		item.setQuantidade(10);
		item.setValorUnitario(new BigDecimal(2.32));
		item.setPedido(pedido);

		pedido.getItens().add(item);

		manager.persist(pedido);

		trx.commit();
		manager.close();
	}
}
