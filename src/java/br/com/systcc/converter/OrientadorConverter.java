package br.com.systcc.converter;

import br.com.systcc.dao.OrientadorDAO;
import br.com.systcc.domain.Orientador;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//https://youtu.be/o87oK_PLnb8?list=PL_GwGUsBlNydMdSOh8nYYRwD4tvPX1EIV&t=466
@FacesConverter("orientadorConverter")
public class OrientadorConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
        try{
            Long id = Long.parseLong(valor);
            OrientadorDAO dao = new OrientadorDAO();
            Orientador orientador = dao.buscarPorMatricula(id);
            return orientador;
        }catch (RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
        try{
            Orientador orientador = (Orientador) objeto;
            Long id = orientador.getMatricula();
            return id.toString();
        }catch (RuntimeException ex){
            return null;
        }
    }
    
}
