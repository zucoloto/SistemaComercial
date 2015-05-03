package br.com.sistema.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistema.model.entity.Categoria;
import br.com.sistema.model.repository.Categorias;
import br.com.sistema.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

	// @Inject (não funciona)

	private Categorias categorias;

	public CategoriaConverter() {
		categorias = CDIServiceLocator.getBean(Categorias.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Categoria retorno = null;

		if (value != null && !value.equals("")) {
			retorno = categorias.buscarPorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long id = ((Categoria) value).getId();
			return id == null ? "" : id.toString();
		}

		return null;
	}

}
