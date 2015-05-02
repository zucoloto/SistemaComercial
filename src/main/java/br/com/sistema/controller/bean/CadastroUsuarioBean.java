package br.com.sistema.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sistema.model.entity.Grupo;
import br.com.sistema.model.entity.Usuario;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private List<Grupo> grupos;

	public CadastroUsuarioBean() {
		usuario = new Usuario();
		grupos = new ArrayList<>();
	}

	public void salvar() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

}
