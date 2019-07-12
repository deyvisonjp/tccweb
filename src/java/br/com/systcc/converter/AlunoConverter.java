package br.com.systcc.converter;

import br.com.systcc.dao.AlunoDAO;
import br.com.systcc.domain.Aluno;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//https://youtu.be/o87oK_PLnb8?list=PL_GwGUsBlNydMdSOh8nYYRwD4tvPX1EIV&t=466
@FacesConverter("alunoConverter")
public class AlunoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
        try{
            Long id = Long.parseLong(valor);
            AlunoDAO dao = new AlunoDAO();
            Aluno aluno = dao.buscarPorAluno(id);
            return aluno;
        }catch (RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
        try{
            Aluno aluno = (Aluno) objeto;
            Long id = aluno.getMatricula();
            return id.toString();
        }catch (RuntimeException ex){
            return null;
        }
    }
    
}
