package br.com.systcc.converter;

import br.com.systcc.dao.AvaliadorDAO;
import br.com.systcc.domain.Avaliador;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//https://youtu.be/o87oK_PLnb8?list=PL_GwGUsBlNydMdSOh8nYYRwD4tvPX1EIV&t=466
@FacesConverter("avaliadorConverter")
public class AvaliadorConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
        try{
            Long id = Long.parseLong(valor);
            AvaliadorDAO dao = new AvaliadorDAO();
            Avaliador avaliador = dao.buscarPorMatricula(id);
            return avaliador;
        }catch (RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
        try{
            Avaliador avaliador = (Avaliador) objeto;
            Long id = avaliador.getMatricula();
            return id.toString();
        }catch (RuntimeException ex){
            return null;
        }
    }
    
}
