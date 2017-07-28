package br.com.casadocodigo.faces.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.casadocodigo.models.Autor;

@FacesConverter(forClass = Autor.class, value = "autorConverter")
public class AutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (null == value || value.trim().isEmpty()) {
			return null;
		}
		
		Long id = null;
		
		try {
			id = Long.parseLong(value);
		} catch(NumberFormatException e) {
			throw new ConverterException("ID inválido");
		}
		
		return new Autor(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(null == value) {
			return "";
		}
		
		Autor autor = (Autor) value;
		
		return autor.getId().toString();
	}

}
