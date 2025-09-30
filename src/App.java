import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // loop do jogo
        // p1 = policia && p2 = terrorista
        var p1 = new Policial("Newton", "Fuzil", 10, 5);
        var p2 = new Terrorista("RoBo", "Fuzil", 10, 5);
        var gerador = new Random();
        int primeiro;
        int acao;
        int arma;
        int recuperar;
        int danoGranada;

        while (p1.getEnergia() != 0 && p2.getEnergia() != 0) {

            acao = gerador.nextInt(4) + 1;
            primeiro = gerador.nextInt(2) + 1;
            arma = gerador.nextInt(3) + 1;
            recuperar = gerador.nextInt(2) + 1;
            
            if (arma == 1) {
                p1.setArmamento("Faca");
            } else if (arma == 2) {
                p1.setArmamento("Pistola");
            } else {
                p1.setArmamento("Fuzil");
            }

            danoGranada = gerador.nextInt(6) + 1;
            switch (acao) {
                case 1:
                if (primeiro == 1) {
                    p1.atacar();
                    primeiro++;
                    if (p1.getArmamento() == "Faca") {
                        p2.setEnergiaAtaque(1);
                    } else if (p1.getArmamento() == "Pistola") {
                        p2.setEnergiaAtaque(2);
                        
                    } else if (p1.getArmamento() == "Fuzil") {
                        p2.setEnergiaAtaque(3);
                        
                    }
                    break;
                } else {
                    p2.atacar();
                    primeiro--;
                        if (p2.getArmamento() == "Faca") {
                            p1.setEnergiaAtaque(1);
                            ;
                        } else if (p2.getArmamento() == "Pistola") {
                            p1.setEnergiaAtaque(2);
                            
                        } else if (p2.getArmamento() == "Fuzil") {
                            p1.setEnergiaAtaque(3);
                        }
                        break;
                    }
                    
                    case 2:
                    if (primeiro == 1) {
                        p1.lancarGranada(danoGranada);
                        p2.setEnergiaGranada(danoGranada);
                        primeiro++;
                        break;
                    } else {
                        p2.lancarGranada(danoGranada);
                        p1.setEnergiaGranada(danoGranada);
                        primeiro--;
                        break;
                        
                    }
                    
                    case 3:
                    if (primeiro == 1) {
                        primeiro++;
                        p1.desarmarBomba();
                        break;
                    } else {
                        p2.plantarBomba();
                        primeiro--;
                        break;
                        
                    }
                    
                    case 4:
                    if (primeiro == 1) {
                        primeiro++;
                        p1.passarAVez();
                        p2.setEnergiaPassaVez(recuperar);
                        break;
                    } else {
                        p2.passarAVez();
                        p1.setEnergiaPassaVez(recuperar);
                        primeiro--;
                        break;
                    }
                }
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                arma = gerador.nextInt(3) + 1;
                recuperar = gerador.nextInt(2) + 1;
                acao = gerador.nextInt(4) + 1;
                
                if (arma == 1) {
                    p2.setArmamento("Faca");
                } else if (arma == 2) {
                    p2.setArmamento("Pistola");
                } else {
                    p2.setArmamento("Fuzil");
                }
                danoGranada = gerador.nextInt(6) + 1;

            switch (acao) {
                case 1:
                    if (primeiro == 1) {
                        p1.atacar();
                        primeiro++;
                        if (p1.getArmamento() == "Faca") {
                            p2.setEnergiaAtaque(1);
                        } else if (p1.getArmamento() == "Pistola") {
                            p2.setEnergiaAtaque(2);

                        } else {
                            p2.setEnergiaAtaque(3);

                        }
                        break;
                    } else {
                        p2.atacar();
                        primeiro--;
                        if (p2.getArmamento() == "Faca") {
                            p1.setEnergiaAtaque(1);
                        } else if (p2.getArmamento() == "Pistola") {
                            p1.setEnergiaAtaque(2);

                        } else {
                            p1.setEnergiaAtaque(3);
                        }
                        break;
                    }

                case 2:
                    if (primeiro == 1) {
                        p2.setEnergiaGranada(danoGranada);
                        p1.lancarGranada(danoGranada);
                        primeiro++;
                        break;
                    } else {
                        p1.setEnergiaGranada(danoGranada);
                        p2.lancarGranada(danoGranada);
                        primeiro--;
                        break;

                    }

                case 3:
                    if (primeiro == 1) {
                        primeiro++;
                        p1.desarmarBomba();
                        break;
                    } else {
                        p2.plantarBomba();
                        primeiro--;
                        break;

                    }

                case 4:
                    if (primeiro == 1) {
                        primeiro++;
                        p1.passarAVez();
                        p2.setEnergiaPassaVez(recuperar);
                        break;
                    } else {
                        p2.passarAVez();
                        p1.setEnergiaPassaVez(recuperar);
                        primeiro--;
                        break;
                    }
            }

            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.printf("ENERGIA %s = %d  ENERGIA %s = %d\n", p1.getNome(), p1.getEnergia(), p2.getNome(),
                    p2.getEnergia());
            System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
            Thread.sleep(1000);

            if (p1.getEnergia() == 0) {
                System.out.println(p2.getNome() + " é o vencedor!");
            } else if (p2.getEnergia() == 0) {
                System.out.println(p1.getNome() + " é o vencedor!");
            }
        }
    }
}