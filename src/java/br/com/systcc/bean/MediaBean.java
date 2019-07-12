package br.com.systcc.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Deyvison
 */
@ManagedBean
@RequestScoped
public class MediaBean {

    public double CalcMedia(){
        result = (n1+n2)/2;
        return result;
    }
    
    private double n1,n2, result;

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    
}
