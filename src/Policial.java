public class Policial {
    private String nome;
    private String armamento;
    private int energia;
    private int quantidadeGranadas;

    Policial(String nome, String armamento, int energia, int quantidadeGranadas) {
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

    public void setEnergiaPassaVez(int energia) {
        this.energia = Math.min(this.energia + energia, 10);
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


    public void desarmarBomba() {
        System.out.println(nome + " desarmando bomba... ");
    }

    public void lancarGranada(int danoGranada) {
        if (quantidadeGranadas > 0) {
            System.out.println(nome + " lançando granada...   (" + danoGranada + ")");
            quantidadeGranadas--;
        } else {
            System.out.println(nome + " não tem granada");
        }
    }

    public void atacar() {
        System.out.println(nome + " atacando com " + armamento);
    }

    public void passarAVez() {
        System.out.println(nome + " passou a vez... ");
    }
}