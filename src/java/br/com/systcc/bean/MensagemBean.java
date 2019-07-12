package br.com.systcc.bean;

import br.com.systcc.dao.MensagemDAO;
import br.com.systcc.dao.UsuarioDAO;
import br.com.systcc.domain.Mensagem;
import br.com.systcc.domain.Usuario;
import br.com.systcc.util.FacesUtil;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@ViewScoped
public class MensagemBean {

    //Criando ------------------------------------------------------------------
    private Mensagem mensagemCad;

    public Mensagem getMensagemCad() {
        if (mensagemCad == null) {
            mensagemCad = new Mensagem();
            Date msgData = new Date();
            mensagemCad.setData(msgData);
        }

        return mensagemCad;
    }

    public void setMensagemCad(Mensagem mensagem) {
        mensagem = mensagemCad;
    }

    //CRIANDO UM SELECT --------------------------------------------------------
    private Mensagem selectMensagem;

    public Mensagem getSelectMensagem() {
        return selectMensagem;
    }

    public void setSelectMensagem(Mensagem selectMensagem) {
        this.selectMensagem = selectMensagem;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            MensagemDAO dao = new MensagemDAO();
            dao.salvar(mensagemCad);
            FacesUtil.addMsgInfo("Mensagem Enviada!");
            mensagemCad = new Mensagem();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao enviar a mensagem: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            MensagemDAO dao = new MensagemDAO();
            dao.excluir(selectMensagem);
            FacesUtil.addMsgInfo("Mensagem removido com sucesso!");
            selectMensagem = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover o mensagem: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            MensagemDAO dao = new MensagemDAO();
            dao.editar(selectMensagem);
            FacesUtil.addMsgInfo("Alteração realizada com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro na alteração do mensagem: " + ex.getMessage());
        }
    }
    //CRIANDO UMA LISTA PARA BUSCAR DE USUARIO -------------------------------------
    public List<Usuario> listaUsuario;

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    //LISTAR Mensagens BEAN
    private List<Mensagem> listaMensagem;
    private List<Mensagem> listaMensagemFiltro;

    public List<Mensagem> getListaMensagem() {
        return listaMensagem;
    }

    public void setListaMensagem(List<Mensagem> listaMensagem) {
        this.listaMensagem = listaMensagem;
    }

    public List<Mensagem> getListaMensagemFiltro() {
        return listaMensagemFiltro;
    }

    public void setListaMensagemFiltro(List<Mensagem> listaMensagemFiltro) {
        this.listaMensagemFiltro = listaMensagemFiltro;
    }

    public void carregar() {
        try {
            MensagemDAO dao = new MensagemDAO();
            listaMensagem = dao.listar();

            UsuarioDAO daoUsuario = new UsuarioDAO();
            listaUsuario = daoUsuario.listar();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os mensagens: " + ex.getMessage());
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
    
                TccDAO daoTcc = new TccDAO();
            listaTcc = daoTcc.listar();
    
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
        return "MensagemBD.xhtml?faces-redirect=true\"";
    }

}
