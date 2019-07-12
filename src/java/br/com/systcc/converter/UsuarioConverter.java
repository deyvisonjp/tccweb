package br.com.systcc.converter;

import br.com.systcc.dao.UsuarioDAO;
import br.com.systcc.domain.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//https://youtu.be/o87oK_PLnb8?list=PL_GwGUsBlNydMdSOh8nYYRwD4tvPX1EIV&t=466
@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
        try{
            Long id = Long.parseLong(valor);
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.buscarPorUsuario(id);
            return usuario;
        }catch (RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
        try{
            Usuario usuario = (Usuario) objeto;
            Long id = usuario.getMatricula();
            return id.toString();
        }catch (RuntimeException ex){
            return null;
        }
    }
    
}
