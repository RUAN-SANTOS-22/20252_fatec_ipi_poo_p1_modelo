package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Fuzil {
    private int dano = 3;

    public int atacar(){
        return dano;
    }
}
