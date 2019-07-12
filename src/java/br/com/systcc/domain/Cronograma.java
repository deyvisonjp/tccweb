package br.com.systcc.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Deyvison and Maurilio
 */
@Entity
@Table(name = "cronograma")
@NamedQueries({
    @NamedQuery(name = "Cronograma.listar", query = "SELECT cronograma FROM Cronograma cronograma")
    ,
    @NamedQuery(name = "Cronograma.buscarPorId", query = "SELECT cronograma FROM Cronograma cronograma WHERE cronograma.semestre = :semestre")
})
public class Cronograma implements Serializable {
    
    @Id
    @Column(name = "semestre", nullable = false, unique = true)
    private String semestre;

    @Column(name = "lim_etapa1", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date lim_etapa1;

    @Column(name = "lim_etapa2", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date lim_etapa2;

    @Column(name = "lim_etapa3", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date lim_etapa3;

    @Column(name = "lim_etapa4", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date lim_etapa4;

    @Column(name = "lim_etapa5", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date lim_etapa5;
    
    @Column(name = "lim_etapa6", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date lim_etapa6;

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Date getLim_etapa1() {
        return lim_etapa1;
    }

    public void setLim_etapa1(Date lim_etapa1) {
        this.lim_etapa1 = lim_etapa1;
    }

    public Date getLim_etapa2() {
        return lim_etapa2;
    }

    public void setLim_etapa2(Date lim_etapa2) {
        this.lim_etapa2 = lim_etapa2;
    }

    public Date getLim_etapa3() {
        return lim_etapa3;
    }

    public void setLim_etapa3(Date lim_etapa3) {
        this.lim_etapa3 = lim_etapa3;
    }

    public Date getLim_etapa4() {
        return lim_etapa4;
    }

    public void setLim_etapa4(Date lim_etapa4) {
        this.lim_etapa4 = lim_etapa4;
    }

    public Date getLim_etapa5() {
        return lim_etapa5;
    }

    public void setLim_etapa5(Date lim_etapa5) {
        this.lim_etapa5 = lim_etapa5;
    }

    public Date getLim_etapa6() {
        return lim_etapa6;
    }

    //---------------------------------------------------
    public void setLim_etapa6(Date lim_etapa6) {
        this.lim_etapa6 = lim_etapa6;
    }

    @Override
    public String toString() {
        return "Cronograma{semestre=" + semestre + ", lim_etapa1=" + lim_etapa1 + ", lim_etapa2=" + lim_etapa2 + ", lim_etapa3=" + lim_etapa3 + ", lim_etapa4=" + lim_etapa4 + ", lim_etapa5=" + lim_etapa5 + ", lim_etapa6=" + lim_etapa6 + '}';
    }
       
}
