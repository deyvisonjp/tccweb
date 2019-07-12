package br.com.systcc.test;

import br.com.systcc.dao.CronogramaDAO;
import br.com.systcc.dao.EtapaDAO;
import br.com.systcc.dao.TccDAO;
import br.com.systcc.domain.Cronograma;
import br.com.systcc.domain.Etapa;
import br.com.systcc.domain.Tcc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class CronogramaTesteDao {
    
    @Test
    public void salvar() throws ParseException{
        Cronograma crono = new Cronograma();
        CronogramaDAO daoCrono = new CronogramaDAO();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("23/05/2018");
        crono.setSemestre("2018_2");
        crono.setLim_etapa1(data);
        crono.setLim_etapa2(data);
        crono.setLim_etapa3(data);
        crono.setLim_etapa4(data);
        crono.setLim_etapa5(data);
        crono.setLim_etapa6(data);
        
        daoCrono.salvar(crono);
    }
    
    @Test
    @Ignore
    public void buscarPorMatricula(){
        EtapaDAO dao = new EtapaDAO();
        Etapa et = dao.buscarPorEtapa(3L);
            System.out.println(et);
    }

    
    @Test
    @Ignore
    public void excluir(){
        EtapaDAO dao = new EtapaDAO();
        Etapa etp = dao.buscarPorEtapa(4L);
        if(etp != null){
            dao.excluir(etp);
        }
    }

    
    @Test
    public void listar(){
        CronogramaDAO dao = new CronogramaDAO();
        List<Cronograma> cronogramas = dao.listar();
        
        for (Cronograma cronograma : cronogramas){
            System.out.println(cronograma);
        }
        
    }
    
    
    @Test
    @Ignore
    public void editar() throws ParseException{
        
        Tcc tcc = new Tcc();
        TccDAO daoTcc = new TccDAO();
        tcc = daoTcc.buscarPorId(1L);
        
        Etapa etapa1 = new Etapa();
        etapa1.setId_etapa(2L);
        etapa1.setEtapa_num(1);
        etapa1.setCumEtapa(true);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("20/03/2018");
        etapa1.setDataLimEtapa(data);
        etapa1.setNotaEtapa(5.6);
        etapa1.setObservacao("Ok.");
        etapa1.setTcc(tcc);
        
        EtapaDAO dao = new EtapaDAO();
        dao.editar(etapa1);
        
    }


    
}
