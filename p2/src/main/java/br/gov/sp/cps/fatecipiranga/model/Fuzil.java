package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Fuzil {
    private String titulo;
    private int dano;

    public Fuzil (){
        titulo = "fuzil";
        dano = 3;
    }

    public int atacar(){
        return dano;
    }
}
