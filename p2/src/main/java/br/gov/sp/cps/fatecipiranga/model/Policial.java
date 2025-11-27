package br.gov.sp.cps.fatecipiranga.model;

import java.util.ArrayList;

import java.util.Random;

import lombok.Data;

@Data
public class Policial {
    private String nome;
    private int armamento;
    private int energia;
    private int quantidadeGranadas;
    private Faca faca = new Faca();
    private Fuzil fuzil = new Fuzil();
    private Pistola pistola = new Pistola(); 
    private ArrayList<String> historicoArma = new ArrayList<>();

    public Policial(String nome, int energia, int quantidadeGranadas) {
        if (nome.length() >= 4) {
            this.nome = nome;
        }
        if (energia >= 0 && energia <= 10) {
            this.energia = energia;
        }
        if (quantidadeGranadas >= 0 && quantidadeGranadas <= 5) {
            this.quantidadeGranadas = quantidadeGranadas;
        }
    }

    public void setEnergiaAtaque(int energia) {
        this.energia = Math.max(this.energia - energia, 0);
        // this.energia -= energia;
    }
    public void setMecanismoBomba(int energia) {
        this.energia = Math.max(this.energia - energia, 0);
        // this.energia -= energia;
    }

    public void setEnergiaPassaVez(int energia) {
        this.energia = Math.min(this.energia + energia, 10);
    }

    public void setResetaEnergia() {
        this.energia = 10;
    }

    public void setResetaGranada() {
        this.quantidadeGranadas = 5;  
    }

    public void setEnergiaGranada(int energia){
        this.energia = Math.max(this.energia - energia, 0);
    }
    public int getEnergiaGranada(){
        return energia;
    }

    public int desarmarBomba(String mapa) {
        System.out.println(nome + " desarmando bomba " + mapa);
        return 1;
    }

    public void lancarGranada(int danoGranada, String mapa) {
        if (quantidadeGranadas > 0) {
            System.out.println(nome + " lançando granada (" + danoGranada + ") " + mapa);
            quantidadeGranadas--;
        } else {
            System.out.println(nome + " não tem granada");
        }
    }

    public int atacar(String mapa) {
        var gerador = new Random();
        armamento = gerador.nextInt(3) + 1;

        if (armamento == 1) {
            System.out.println(nome + " atacando com faca " + mapa);
            historicoArma.add("faca");
            return faca.atacar();

        } else if (armamento == 2) {
            System.out.println(nome + " atacando com pistola " + mapa);
            historicoArma.add("pistola");
            return pistola.atacar();

        } else {
            System.out.println(nome + " atacando com fuzil " + mapa);
            historicoArma.add("fuzil");
            return fuzil.atacar();
        }
    }

    public void passarAVez(String mapa) {
        System.out.println(nome + " passou a vez " + mapa);
    }

    public void exibeHistoricoArmas(){
        // for (ArrayList exibeHistoricoArmas:  )
            System.out.println("Historico de armas do "+ nome + historicoArma);
    }
    
    public void limpaHistoricoArma(){
        historicoArma.clear();
    }

    public ArrayList<HistoricoAtaque> processaHistoricoBanco() {

    ArrayList<HistoricoAtaque> historicos = new ArrayList<>();
    int contadorFaca = 0;
    int contadorPistola = 0;
    int contadorFuzil = 0;

    for (String arma : historicoArma) {
        if (arma == "faca") {
            contadorFaca++;
        } else if (arma == "pistola") {
            contadorPistola++;
        } else if (arma =="fuzil") {
            contadorFuzil++;
        }
    }

    if (contadorFaca > 0) {
        historicos.add(new HistoricoAtaque(this.nome, "faca", contadorFaca));
    }
    if (contadorPistola > 0) {
        historicos.add(new HistoricoAtaque(this.nome, "pistola", contadorPistola));
    }
    if (contadorFuzil > 0) {
        historicos.add(new HistoricoAtaque(this.nome, "fuzil", contadorFuzil));
    }

    return historicos;
}

}