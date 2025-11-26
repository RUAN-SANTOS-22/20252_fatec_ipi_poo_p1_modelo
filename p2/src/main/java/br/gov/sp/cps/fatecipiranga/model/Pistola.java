package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Pistola {
    private int dano = 2;

    public int atacar(){
        return dano;
    }
}
