package br.gov.sp.cps.fatecipiranga;

import java.util.Random;

import javax.swing.JOptionPane;

import br.gov.sp.cps.fatecipiranga.model.Policial;

import br.gov.sp.cps.fatecipiranga.model.Terrorista;

import br.gov.sp.cps.fatecipiranga.db.HistoricoAtaqueDAO;


public class App {
    public static void main(String[] args) throws Exception {
        // loop do jogo
        // p1 = policia && p2 = terrorista
        var p1 = new Policial("Newton", 10, 5);
        var p2 = new Terrorista("RoBo", 10, 5);
        var gerador = new Random();
        int primeiro;
        int acao;
        int recuperar;
        int danoGranada;
        int armarBomba;
        int desarmarBomba;
        int rodada;
        int p1Vence = 0;
        int p2Vence = 0;
        String mapa;
        int opcaoMapa;

        opcaoMapa = Integer.parseInt(JOptionPane.showInputDialog("Escolha um mapa para jogar\n0 = Roma   1 = Fatec Ipiranga"));

        if (opcaoMapa == 0) {
            mapa = "em Roma";
        } else {
            mapa = "na Fatec Ipiranga";
        }

        while (opcaoMapa != 0 && opcaoMapa != 1) {
            opcaoMapa = Integer.parseInt(JOptionPane.showInputDialog("ZERO = Roma    UM = Fatec Ipiranga"));
        }

        rodada = Integer.parseInt(
                JOptionPane.showInputDialog("Digite um número impar de 1 a 20 que definirá a quantidade de rodadas"));

        while (rodada % 2 == 0 || rodada <= 0 || rodada >= 20) {
            rodada = Integer.parseInt(JOptionPane
                    .showInputDialog("Digite UM número ÍMPAR de UM a VINTE que definirá a quantidade de rodadas"));
        }

        for (int i = 0; i < rodada; i++) {
         
            while (p1.getEnergia() != 0 && p2.getEnergia() != 0) {

                armarBomba = 0;
                desarmarBomba = 0;
                acao = gerador.nextInt(4) + 1;
                primeiro = gerador.nextInt(2) + 1;
                recuperar = gerador.nextInt(2) + 1;

                danoGranada = gerador.nextInt(6) + 1;
                switch (acao) {
                    case 1:
                        if (primeiro == 1) {
                            p2.setEnergiaAtaque(p1.atacar(mapa));
                            primeiro++;
                            break;

                        } else {
                            p1.setEnergiaAtaque(p2.atacar(mapa));
                            primeiro--;
                            break;
                        }

                    case 2:
                        if (primeiro == 1) {
                            p1.lancarGranada(danoGranada, mapa);
                            p2.setEnergiaGranada(danoGranada);
                            primeiro++;
                            break;
                        } else {
                            p2.lancarGranada(danoGranada, mapa);
                            p1.setEnergiaGranada(danoGranada);
                            primeiro--;
                            break;

                        }

                    case 3:
                        if (primeiro == 1) {
                            primeiro++;
                            p1.desarmarBomba(mapa);
                            desarmarBomba = 1;
                            break;
                        } else {
                            p2.plantarBomba(mapa);
                            primeiro--;
                            armarBomba = 1;
                            break;

                        }

                    case 4:
                        if (primeiro == 1) {
                            primeiro++;
                            p1.passarAVez(mapa);
                            p2.setEnergiaPassaVez(recuperar);
                            break;
                        } else {
                            p2.passarAVez(mapa);
                            p1.setEnergiaPassaVez(recuperar);
                            primeiro--;
                            break;
                        }
                }
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                recuperar = gerador.nextInt(2) + 1;
                acao = gerador.nextInt(4) + 1;
                danoGranada = gerador.nextInt(6) + 1;

                switch (acao) {
                    case 1:
                        if (primeiro == 1) {
                            p2.setEnergiaAtaque(p1.atacar(mapa));
                            primeiro++;   
                            break;

                        } else {
                            p1.setEnergiaAtaque(p2.atacar(mapa));
                            primeiro--;
                            break;
                        }

                    case 2:
                        if (primeiro == 1) {
                            p2.setEnergiaGranada(danoGranada);
                            p1.lancarGranada(danoGranada, mapa);
                            primeiro++;
                            break;
                        } else {
                            p1.setEnergiaGranada(danoGranada);
                            p2.lancarGranada(danoGranada, mapa);
                            primeiro--;
                            break;

                        }

                    case 3:
                        if (primeiro == 1) {
                            primeiro++;
                            p1.desarmarBomba(mapa);
                            desarmarBomba = 1;
                            break;
                        } else {
                            p2.plantarBomba(mapa);
                            primeiro--;
                            armarBomba = 1;
                            break;

                        }

                    case 4:
                        if (primeiro == 1) {
                            primeiro++;
                            p1.passarAVez(mapa);
                            p2.setEnergiaPassaVez(recuperar);
                            break;
                        } else {
                            p2.passarAVez(mapa);
                            p1.setEnergiaPassaVez(recuperar);
                            primeiro--;
                            break;
                        }
                }
                // P2 plantou P1 n desarmou
                if (armarBomba == 1 && desarmarBomba == 0 || desarmarBomba == 0 && armarBomba == 1) {
                    p1.setMecanismoBomba(10);
                } // Se p1 desarmar e P2 n plantar

                // } //Se P2 plantar e P1 desarmar
                else if (armarBomba == 1 && desarmarBomba == 1) {
                    p2.setMecanismoBomba(10);
                }

                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.printf("ENERGIA %s = %d  ENERGIA %s = %d\n", p1.getNome(), p1.getEnergia(), p2.getNome(),p2.getEnergia());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++\n");
                Thread.sleep(1000);

                if (p1.getEnergia() == 0) {
                    System.out.println(p2.getNome() + " venceu a rodada\n");
                    p2Vence++;
                } else if (p2.getEnergia() == 0) {
                    System.out.println(p1.getNome() + " venceu a rodada\n");
                    p1Vence++;
                }
            }
            System.out.println("\n=================================================");
            p1.exibeHistoricoArmas();
            p2.exibeHistoricoArmas();
            System.out.println("=================================================\n");
            // p1.limpaHistoricoArma();
            // p2.limpaHistoricoArma();
            
            p1.setResetaEnergia();
            p1.setResetaGranada();
            p2.setResetaEnergia();
            p2.setResetaGranada();
        }


        if (p1Vence > p2Vence) {
            System.out.println(
                    p1.getNome() + " venceu a partida com " + p1Vence + " vitória(s) e " + p2Vence + " derrota(s)! ");
            System.out.println(
                    p2.getNome() + " perdeu a partida com " + p1Vence + " derrota(s) e " + p2Vence + " vitória(s)! ");
        } else {
            System.out.println(
                    p2.getNome() + " venceu a partida com " + p2Vence + " vitória(s) e " + p1Vence + " derrota(s)! ");
            System.out.println(
                    p1.getNome() + " perdeu a partida com " + p2Vence + " derrota(s) e " + p1Vence + " vitória(s)! ");
        }

        
        try {
            var historicoAtaqueDAO = new HistoricoAtaqueDAO();
            
            var historicosP1 = p1.processaHistoricoBanco();
            for (var historico : historicosP1) {
                historicoAtaqueDAO.cadastrar(historico);
            }
            
            var historicosP2 = p2.processaHistoricoBanco();
            for (var historico : historicosP2) {
                historicoAtaqueDAO.cadastrar(historico);
            }
            
            System.out.println("Histórico de ataques salvo no banco de dados!");

        } catch (Exception e) {
            System.out.println("Erro ao salvar histórico no banco: " + e.getMessage());
            e.printStackTrace();
        }

        p1.limpaHistoricoArma();
        p2.limpaHistoricoArma();

    }
    

}
