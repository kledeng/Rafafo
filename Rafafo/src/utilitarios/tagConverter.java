package utilitarios;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Tag;

@FacesConverter(value="tagConverter")
public class tagConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesCtx, UIComponent uiCmp, String value) {
		if (value != null && !value.isEmpty()) {
			Tag tag = (Tag) uiCmp.getAttributes().get(value);
			return tag;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesCtx, UIComponent uiCmp, Object value) {
		if (value instanceof Tag) {
            Tag tag = (Tag) value;
            if (tag != null && tag instanceof Tag && tag.getNome() != null) {
                uiCmp.getAttributes().put( tag.getNome(), tag);
                return tag.getNome();
            }
        }
        return "";
	}

}
