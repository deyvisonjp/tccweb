package br.com.systcc.bean;

import br.com.systcc.dao.Historico_loginDAO;
import br.com.systcc.dao.UsuarioDAO;
import br.com.systcc.domain.Historico_login;
import br.com.systcc.domain.Usuario;
import br.com.systcc.util.FacesUtil;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Deyvison Jose de Paula e Maurlio Costa Bastos
 */
@ManagedBean
@SessionScoped //Enquanto usuario estiver logado
public class AtenticacaoBean {

    private Usuario usuarioLogado;

    public Usuario getUsuarioLogado() {
        if (usuarioLogado == null) {
            usuarioLogado = new Usuario();
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    //Instancia para HistoricoLogin --------------------------------------------
    private Historico_login histLoginCad;

    public Historico_login getHistLoginCad() {
        return histLoginCad;
    }

    public void setHistLoginCad(Historico_login histLoginCad) {
        this.histLoginCad = histLoginCad;
    }

    //LOGAR --------------------------------------------------------------------
    Historico_loginDAO hisDao = new Historico_loginDAO();

    public String logar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuarioLogado = dao.Logar(usuarioLogado.getEmail(), usuarioLogado.getSenha());
            if (usuarioLogado != null) {
                FacesUtil.addMsgInfo("Usuário autenticado com sucesso");
                return "principal.xhtml?faces-redirect=true";
            } else {
                FacesUtil.addMsgError("E-mail e/ou senha incorretos");
            }

        } catch (RuntimeException ex) {
            ex.printStackTrace();
            FacesUtil.addMsgError("Erro ao logar no sistema: " + ex.getMessage());
        }
        return "";
    }

    public String deslogar() {
        usuarioLogado = null;
        return "login.xhtml?faces-redirect = true";
    }

    //FAZ HIST DE LOGIN
    public void salvar(){
        if (logar() != ""){
                histLoginCad.setUsuario(usuarioLogado);
                histLoginCad.setHora_entrada(new Date());
                hisDao.salvar(histLoginCad);
        }
    }
    
}
