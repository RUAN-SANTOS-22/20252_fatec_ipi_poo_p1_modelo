package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class HistoricoAtaque {
    private int codigo;
    private String personagem;
    private String armamento;
    private int vezesUsouArma;

    public HistoricoAtaque(String personagem, String armamento, int vezesUsouArma){
        this(0, personagem, armamento, vezesUsouArma);
    }
    public HistoricoAtaque(int codigo, String personagem, String armamento, int vezesUsouArma){
        setCodigo(codigo);
        setPersonagem(personagem);
        setArmamento(armamento);
        setVezesUsouArma(vezesUsouArma);
    }
}
