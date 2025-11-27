package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Faca {
    private String titulo;
    private int dano;

    public Faca (){
        titulo = "faca";
        dano = 1;
    }

    public int atacar(){
        return dano;
    }
}
