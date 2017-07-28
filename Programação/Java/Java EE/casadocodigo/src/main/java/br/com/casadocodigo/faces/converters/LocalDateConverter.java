package br.com.casadocodigo.faces.converters;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = LocalDate.class, value = "localDateConverter")
public class LocalDateConverter implements Converter {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (null == value || value.trim().isEmpty()) {
			return null;
		}
		
		LocalDate localDate = null;
		
		try {
			localDate = LocalDate.parse(value, formatter);
		} catch (DateTimeParseException e) {
			throw new ConverterException("O formato da data e hora deve ser 13/11/2015 12:00:00.");
		}
		
		return localDate;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (null == value) {
			return "";
		}
		
		return formatter.format((LocalDate) value);
	}

}
