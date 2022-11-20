package IA.algoritmo;

import IA.Helper;
import lombok.Data;

import java.util.Random;

public class Cromosoma {

    //Madre
    private String x;
    //Padre
    private String y;
    private Integer genExpresion;

    public Cromosoma(){
        this.genExpresion = Helper.random(2);
    }

    public String getValor(){
        return (genExpresion==0)? this.x : this.y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setValor(String valor) {
        if(genExpresion==0) {
            this.x = valor;
        }else{
            this.y = valor;
        }
    }
}
