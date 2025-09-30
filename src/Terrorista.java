public class Terrorista {
    private String nome;
    private String armamento;
    private int energia;
    private int quantidadeGranadas;

    Terrorista(String nome, String armamento, int energia, int quantidadeGranadas) {
        if (nome.length() >= 4) {
            this.nome = nome;
        }
        if (armamento == "Faca" || armamento == "Pistola" || armamento == "Fuzil") {
            this.armamento = armamento;
        }
        if (energia >= 0 && energia <= 10) {
            this.energia = energia;
        }
        if (quantidadeGranadas >= 0 && quantidadeGranadas <= 5) {
            this.quantidadeGranadas = quantidadeGranadas;
        }
    }

    // setter e getter
    public String getArmamento() {
        return armamento;
    }

    public void setArmamento(String armamento) {
        this.armamento = armamento;
    }

    public int getEnergia() {
        return energia;
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
        this.energia = 5;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnergiaGranada(int energia){
        this.energia = Math.max(this.energia - energia, 0);
    }
    public int getEnergiaGranada(){
        return energia;
    }

    public int plantarBomba(String mapa) {
        System.out.println(nome + " plantando bomba " + mapa);
        return 1;
    }

    public void lancarGranada(int danoGranada,String mapa) {
        if (quantidadeGranadas > 0) {
            System.out.println(nome + " lançando granada (" + danoGranada + ") " + mapa);
            quantidadeGranadas--;
        } else {
            System.out.println(nome + " não tem granada");
        }
    }

    public void atacar(String mapa) {
        System.out.println(nome + " atacando com " + armamento + mapa);
    }

    public void passarAVez(String mapa) {
        System.out.println(nome + " passou a vez " + mapa);
    }
}