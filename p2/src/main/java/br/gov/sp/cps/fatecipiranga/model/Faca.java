package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Faca {
    private int dano = 1;

    public int atacar(){
        return dano;
    }
}
