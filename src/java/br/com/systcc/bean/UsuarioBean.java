package br.com.systcc.bean;


import br.com.systcc.dao.UsuarioDAO;
import br.com.systcc.domain.Usuario;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    //Criando ------------------------------------------------------------------
    private Usuario usuarioCad;

    public Usuario getUsuarioCad() {
        if (usuarioCad == null) {
            usuarioCad = new Usuario();
        }

        return usuarioCad;
    }

    public void setUsuarioCad(Usuario usuario) {
        usuario = usuarioCad;
    }

    //CRIANDO UM SELECT --------------------------------------------------------
    private Usuario selectUsuario;

    public Usuario getSelectUsuario() {
        return selectUsuario;
    }

    public void setSelectUsuario(Usuario selectUsuario) {
        this.selectUsuario = selectUsuario;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuarioCad.setNivelUsuario("Usuario");
            dao.salvar(usuarioCad);
            FacesUtil.addMsgInfo("Usuario salvo com sucesso!");
            usuarioCad = new Usuario();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao salvar o usuario: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.excluir(selectUsuario);
            FacesUtil.addMsgInfo("Usuario removido com sucesso!");
            selectUsuario = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover o usuario: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.editar(selectUsuario);
            FacesUtil.addMsgInfo("Alteração realizada com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro na alteração do usuario: " + ex.getMessage());
        }
    }

    //LISTAR Usuarioes BEAN
    private List<Usuario> listaUsuario;
    private List<Usuario> listaUsuarioFiltro;

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<Usuario> getListaUsuarioFiltro() {
        return listaUsuarioFiltro;
    }

    public void setListaUsuarioFiltro(List<Usuario> listaUsuarioFiltro) {
        this.listaUsuarioFiltro = listaUsuarioFiltro;
    }

    public void carregar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            listaUsuario = dao.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os usuarioes: " + ex.getMessage());
        }
    }

    /*
    public void carregarCadastro() {
        try {
            String valor = FacesUtil.getParam("orCod");
            if (valor != null) {
                Long mat = Long.parseLong(valor);
                AlunoDAO dao = new AlunoDAO();
                alunoCad = dao.buscarPorAluno(mat);
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao carregar a  tabela: " + ex.getMessage());
        }
    }
     */
    
    /*
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg;
        msg = new FacesMessage("Aluno Selecionado", ((Aluno) event.getObject()).getMatricula().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    */

    public String listar() {
        return "UsuarioBD.xhtml?faces-redirect=true\"";
    }

}
