package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Pistola {
    private String titulo;
    private int dano;

    public Pistola (){
        titulo = "pistola";
        dano = 2;
    }

    public int atacar(){
        return dano;
    }
}
