package br.com.systcc.bean;

import br.com.systcc.dao.AlunoDAO;
import br.com.systcc.dao.AvaliaDAO;
import br.com.systcc.dao.AvaliadorDAO;
import br.com.systcc.dao.OrientadorDAO;
import br.com.systcc.domain.Aluno;
import br.com.systcc.domain.Avalia;
import br.com.systcc.domain.Avaliador;
import br.com.systcc.domain.Orientador;
import br.com.systcc.domain.Usuario;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 * @author Deyvison and Maurilio
 */
@ManagedBean
@ViewScoped
public class AvaliaBean {

    //Criando Avalia ------------------------------------------------------------
    private Avalia avaliaCad;

    public Avalia getAvaliaCad() {
        if (avaliaCad == null) {
            avaliaCad = new Avalia();

        }
        return avaliaCad;
    }

    public void setAvaliaCad(Avalia avalia) {
        avalia = avaliaCad;
    }

    //CRIANDO UMA LISTA PARA BUSCAR DE ALUNO -----------------------------------
    public List<Aluno> listaAluno;

    public List<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    //CRIANDO UMA LISTA PARA BUSCAR DE AVALIADOR ---------------------------
    public List<Avaliador> listaAvaliador;

    public List<Avaliador> getListaAvaliador() {
        return listaAvaliador;
    }

    public void setListaAvaliador(List<Avaliador> listaAvaliador) {
        this.listaAvaliador = listaAvaliador;
    }
    
     //CRIANDO UMA LISTA PARA BUSCAR DE ORIENTADOR -----------------------------
    public List<Orientador> listaOrientador;

    public List<Orientador> getListaOrientador() {
        return listaOrientador;
    }

    public void setListaOrientador(List<Orientador> listaOrientador) {
        this.listaOrientador = listaOrientador;
    }
    
    //CRIANDO UM SELECT AVALIA -------------------------------------------------
    private Avalia selectAvalia;

    public Avalia getSelectAvalia() {
        return selectAvalia;
    }

    public void setSelectAvalia(Avalia selectAvalia) {
        this.selectAvalia = selectAvalia;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            AvaliaDAO dao = new AvaliaDAO();
            dao.salvar(avaliaCad);
            FacesUtil.addMsgInfo("Avaliação salvo com sucesso!");
            avaliaCad = new Avalia();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao salvar avaliação: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            AvaliaDAO dao = new AvaliaDAO();
            dao.excluir(selectAvalia);
            FacesUtil.addMsgInfo("Avaliação removida com sucesso!");
            selectAvalia = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover avaliação: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            AvaliaDAO dao = new AvaliaDAO();
            dao.editar(selectAvalia);
            FacesUtil.addMsgInfo("Avaliação editada com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro na alteração da avaliação: " + ex.getMessage());
        }
    }

    //LISTAR AVALIA BEAN
    private List<Avalia> listaAvalia;
    private List<Avalia> listaAvaliaFiltro;

    public void setListaAvalia(List<Avalia> listaAvalia) {
        this.listaAvalia = listaAvalia;
    }

    public List<Avalia> getListaAvalia() {
        return listaAvalia;
    }

    public void setListaAvaliasFiltro(List<Avalia> listaAvaliaFiltro) {
        this.listaAvaliaFiltro = listaAvaliaFiltro;
    }

    public List<Avalia> getListaAvaliaFiltro() {
        return listaAvaliaFiltro;
    }

    public void carregar() {
        try {
            AvaliaDAO dao = new AvaliaDAO();
            listaAvalia = dao.listar();

            AlunoDAO daoAluno = new AlunoDAO();
            listaAluno = daoAluno.listar();
            AvaliadorDAO daoAvaliador = new AvaliadorDAO();
            listaAvaliador = daoAvaliador.listar();
            OrientadorDAO daoOrientador = new OrientadorDAO();
            listaOrientador = daoOrientador.listar();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os avaliações: " + ex.getMessage());
        }
    }

    public void carregarCadastro() {
        try {
            String valor = FacesUtil.getParam("alCod");
            if (valor != null) {
                Long mat = Long.parseLong(valor);
                AvaliaDAO dao = new AvaliaDAO();
                avaliaCad = dao.buscarPorId(mat);
            }
            AlunoDAO daoAluno = new AlunoDAO();
            listaAluno = daoAluno.listar();
            AvaliadorDAO daoAvaliador = new AvaliadorDAO();
            listaAvaliador = daoAvaliador.listar();
            OrientadorDAO daoOrientador = new OrientadorDAO();
            listaOrientador = daoOrientador.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao carregar a tabela: " + ex.getMessage());
        }
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg;
        msg = new FacesMessage("Avalia Selecionado", ((Usuario) event.getObject()).getMatricula().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String listar() {
        return "AvaliaBD.xhtml?faces-redirect=true\"";
    }

}
