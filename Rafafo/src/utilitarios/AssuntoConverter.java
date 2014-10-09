package utilitarios;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Assunto;

@FacesConverter(value="assuntoConverter")
public class AssuntoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesCtx, UIComponent uiCmp, String value) {
		if (value != null && !value.isEmpty()) {
			Assunto assunto = (Assunto) uiCmp.getAttributes().get(value);
			return assunto;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesCtx, UIComponent uiCmp, Object value) {
		if (value instanceof Assunto) {
            Assunto assunto = (Assunto) value;
            if (assunto != null && assunto instanceof Assunto && assunto.getNome() != null) {
                uiCmp.getAttributes().put( assunto.getNome(), assunto);
                return assunto.getNome();
            }
        }
        return "";
	}

}
