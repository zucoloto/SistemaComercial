package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.sistema.model.entity.Grupo;
import br.com.sistema.model.entity.Usuario;

public class UsuarioGrupo {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("SistemaComercialPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Usuario usuario = new Usuario();
		usuario.setNomeUsuario("Alessandro");
		usuario.setEmail("alessandro@gmail.com");
		usuario.setSenha("123");

		Grupo grupo = new Grupo();
		grupo.setNomeGrupo("Administrador");
		grupo.setDescricao("Administrador da empresa");

		usuario.getGrupos().add(grupo);

		manager.persist(usuario);

		trx.commit();
	}
}
