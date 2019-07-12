package br.com.systcc.bean;

import br.com.systcc.dao.EtapaDAO;
import br.com.systcc.dao.TccDAO;
import br.com.systcc.domain.Etapa;
import br.com.systcc.domain.Etapa;
import br.com.systcc.domain.Tcc;
import br.com.systcc.domain.Usuario;
import br.com.systcc.util.FacesUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class EtapaBean {

    //Criando Etapa ------------------------------------------------------------
    private Etapa[] etapaCad = new Etapa[6];

    public Etapa[] getEtapaCad() {
        if (etapaCad == null) {
            etapaCad[0] = new Etapa();
            etapaCad[1] = new Etapa();
            etapaCad[2] = new Etapa();
            etapaCad[3] = new Etapa();
            etapaCad[4] = new Etapa();
            etapaCad[5] = new Etapa();

        }
        return etapaCad;
    }

    public void setEtapaCad(Etapa[] etapa) {
        etapa[0] = etapaCad[0];
        etapa[1] = etapaCad[1];
        etapa[2] = etapaCad[2];
        etapa[3] = etapaCad[3];
        etapa[4] = etapaCad[4];
        etapa[5] = etapaCad[5];
    }

    //CRIANDO UMA LISTA PARA BUSCAR DE TCC -------------------------------------
    public List<Tcc> listaTcc;

    public List<Tcc> getListaTcc() {
        return listaTcc;
    }

    public void setListaTcc(List<Tcc> listaTcc) {
        this.listaTcc = listaTcc;
    }

    //CRIANDO UM SELECT ETAPA --------------------------------------------------
    private Etapa[] selectEtapa;

    public Etapa[] getSelectEtapa() {
        return selectEtapa;
    }

    public void setSelectEtapa(Etapa[] selectEtapa) {
        this.selectEtapa = selectEtapa;
    }

    //SALVAR -------------------------------------------------------------------
    public void salvar() {
        try {
            EtapaDAO dao = new EtapaDAO();
            int n = 5;
            for (int i = 0; i < n; i++) {
                dao.salvar(etapaCad[i]);
            }
            FacesUtil.addMsgInfo("Etapa salvo com sucesso!");
            etapaCad[6] = new Etapa();

        } catch (RuntimeException ex) {
            ex.printStackTrace();//Erro para programador
            FacesUtil.addMsgError("erro ao salvar o etapa: " + ex.getMessage());
        }
    }

    //BUSCAR ------------------------------------------------------------------
    
    //EXCLUIR ------------------------------------------------------------------

    //EDITAR -------------------------------------------------------------------
    
    //LISTAR AETPAS BEAN
    
    //CARREGAR ETAPAS BEAN
    
    //CARREGAR CARREGAR CADASTRO BEAN
    
    
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg;
        msg = new FacesMessage("Etapa Selecionado", ((Usuario) event.getObject()).getMatricula().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String listar() {
        return "EtapaBD.xhtml?faces-redirect=true\"";
    }

}
