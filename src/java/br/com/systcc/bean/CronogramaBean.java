package br.com.systcc.bean;



import br.com.systcc.dao.CronogramaDAO;
import br.com.systcc.domain.Cronograma;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@ViewScoped
public class CronogramaBean {

    //Criando ------------------------------------------------------------------
    private Cronograma cronogramaCad;

    public Cronograma getCronogramaCad() {
        if (cronogramaCad == null) {
            cronogramaCad = new Cronograma();
        }

        return cronogramaCad;
    }

    public void setCronogramaCad(Cronograma cronograma) {
        cronograma = cronogramaCad;
    }

    //CRIANDO UM SELECT --------------------------------------------------------
    private Cronograma selectCronograma;

    public Cronograma getSelectCronograma() {
        return selectCronograma;
    }

    public void setSelectCronograma(Cronograma selectCronograma) {
        this.selectCronograma = selectCronograma;
    }
    
    //BUSCAR
    public Cronograma buscarCronograma(){
        CronogramaDAO dao = new CronogramaDAO();
        Cronograma cro = new Cronograma();
        cro = dao.buscarPorCronograma("2018_1");
        return cro;
    }


    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            CronogramaDAO dao = new CronogramaDAO();
            dao.salvar(cronogramaCad);
            FacesUtil.addMsgInfo("Cronograma salvo com sucesso!");
            cronogramaCad = new Cronograma();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao salvar o cronograma: " + ex.getMessage());
        }
    }

    //EXCLUIR ------------------------------------------------------------------
    public void excluir() {
        try {
            CronogramaDAO dao = new CronogramaDAO();
            dao.excluir(selectCronograma);
            FacesUtil.addMsgInfo("Cronograma removido com sucesso!");
            selectCronograma = null;
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao remover o cronograma: " + ex.getMessage());
        }
    }

    //EDITAR -------------------------------------------------------------------
    public void editar() {
        try {
            CronogramaDAO dao = new CronogramaDAO();
            dao.editar(selectCronograma);
            FacesUtil.addMsgInfo("Alteração realizada com sucesso!");

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro na alteração do cronograma: " + ex.getMessage());
        }
    }

    //LISTAR Cronogramaes BEAN
    private List<Cronograma> listaCronograma;
    private List<Cronograma> listaCronogramaFiltro;

    public List<Cronograma> getListaCronograma() {
        return listaCronograma;
    }

    public void setListaCronograma(List<Cronograma> listaCronograma) {
        this.listaCronograma = listaCronograma;
    }

    public List<Cronograma> getListaCronogramaFiltro() {
        return listaCronogramaFiltro;
    }

    public void setListaCronogramaFiltro(List<Cronograma> listaCronogramaFiltro) {
        this.listaCronogramaFiltro = listaCronogramaFiltro;
    }

    public void carregar() {
        try {
            CronogramaDAO dao = new CronogramaDAO();
            listaCronograma = dao.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("Erro ao listar os cronogramaes: " + ex.getMessage());
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
        return "CronogramaBD.xhtml?faces-redirect=true\"";
    }

}
