import javax.swing.JOptionPane;

import espacoDeEstados.Estado;
import espacoDeEstados.Puzzle8;
import estrategiasDeBusca.cega.BuscaCega;
import estrategiasDeBusca.cega.BuscaEmLargura;
import estrategiasDeBusca.cega.BuscaEmProfundidade;
import estrategiasDeBusca.cega.BuscaEmProfundidadeLimitada;
import estrategiasDeBusca.heuristica.AStar;
import estrategiasDeBusca.heuristica.BestFirst;
import estrategiasDeBusca.heuristica.BuscaInformada;
import estrategiasDeBusca.heuristica.HillClimbing;

public class Main {

    /**
     * Atividade de OAT feita por Luan Kenzley Beserra de Oliveira e Guilherme Cesar
     * Leao da Silva
     *
     **/

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

        String buscaDesejada = JOptionPane.showInputDialog(" 1 - Busca em Largura,\n " + "2 - Busca Em Profundidade,\n "
                + "3 - Busca em profundidade Limitada,\n " + "4 - Busca Informada Best First,\n "
                + "5 - Busca Informada ASTar,\n " + "6 - Busca Informada HillClimbing");

        int recuperaValorBuscaDesejada = Integer.valueOf(buscaDesejada);

        char[] cfgIni = { ' ', '2', '3', '1', '4', '6', '7', '5', '8' }; // Configura��o inicial
        char[] cfgEnd = { '1', '2', '3', '4', '5', '6', '7', ' ', '8' }; // Configura��o Final


        Puzzle8 puzzleInicial = new Puzzle8();
        puzzleInicial.setEstado(cfgIni);
        puzzleInicial.setCusto(0);
        puzzleInicial.setAvaliacao(puzzleInicial.heuristica(cfgEnd));

        Puzzle8 puzzleFinal = new Puzzle8();
        puzzleFinal.setEstado(cfgEnd);
        puzzleFinal.setCusto(0);
        puzzleFinal.setAvaliacao(0);

        /* Realiza escolha de algoritmo */
        switch (recuperaValorBuscaDesejada) {
            case 1:
                long startTime = System.nanoTime();
                BuscaCega busca = new BuscaEmLargura();
                System.out.println("Iniciando em..." + busca.getNomeDaEstrategia());
                busca.setInicio(puzzleInicial);
                busca.setObjetivo(puzzleFinal);
                busca.buscar();
                long endTime = System.nanoTime();

                long duration = (endTime - startTime) / 1000;  //divide by 1000000 to get milliseconds.

                for (Estado e : busca.getCaminhoSolucao()) {
                    System.out.println(e);
                }
                JOptionPane.showMessageDialog(null,
                        "Resultado para " + busca.getNomeDaEstrategia() + " Realizada com sucesso!" + " com dura��o de: " + duration + " milliseconds");
                System.exit(0);
                break;

            case 2:
                long startTimeBProfundidade = System.nanoTime();
                BuscaCega buscaEmProfundidade = new BuscaEmProfundidade();
                System.out.println("Iniciando em..." + buscaEmProfundidade.getNomeDaEstrategia());
                buscaEmProfundidade.setInicio(puzzleInicial);
                buscaEmProfundidade.setObjetivo(puzzleFinal);
                buscaEmProfundidade.buscar();
                long endTimeBProfundidade = System.nanoTime();

                long durationBP = (endTimeBProfundidade - startTimeBProfundidade) / 1000;  //divide by 1000000 to get milliseconds.
                for (Estado e : buscaEmProfundidade.getCaminhoSolucao()) {
                    System.out.println(e);
                }

                JOptionPane.showMessageDialog(null,
                        "Resultado para " + buscaEmProfundidade.getNomeDaEstrategia() + " Realizada com sucesso!" + " com dura��o de: " + durationBP + " milliseconds");
                System.exit(0);
                break;

            case 3:
                long startTimeBPL = System.nanoTime();
                BuscaCega buscaEmProfundidadeLimitada = new BuscaEmProfundidadeLimitada(null, null, 16);
                System.out.println("Iniciando em..." + buscaEmProfundidadeLimitada.getNomeDaEstrategia());
                buscaEmProfundidadeLimitada.setInicio(puzzleInicial);
                buscaEmProfundidadeLimitada.setObjetivo(puzzleFinal);
                buscaEmProfundidadeLimitada.buscar();
                long endTimeBPL = System.nanoTime();

                long durationBPL = (endTimeBPL - startTimeBPL) / 1000;  //divide by 1000000 to get milliseconds.
                for (Estado e : buscaEmProfundidadeLimitada.getCaminhoSolucao()) {
                    System.out.println(e);
                }

                JOptionPane.showMessageDialog(null,
                        "Resultado para " + buscaEmProfundidadeLimitada.getNomeDaEstrategia() + " Realizada com sucesso!" + " com dura��o de: " + durationBPL + " milliseconds");
                System.exit(0);
                break;

            case 4:
                long startTimeBI = System.nanoTime();
                BuscaInformada buscaInformada = new BestFirst();
                System.out.println("Iniciando em..." + buscaInformada.getNomeDaEstrategia());
                buscaInformada.setInicio(puzzleInicial);
                buscaInformada.setObjetivo(puzzleFinal);
                buscaInformada.buscar();
                long endTimeBI = System.nanoTime();

                long durationBI = (endTimeBI - startTimeBI) / 1000;  //divide by 1000000 to get milliseconds.
                for (Estado e : buscaInformada.getCaminhoSolucao()) {
                    System.out.println(e);
                }

                JOptionPane.showMessageDialog(null,
                        "Resultado para " + buscaInformada.getNomeDaEstrategia() + " Realizada com sucesso!" + " com dura��o de: " + durationBI + " milliseconds");
                System.exit(0);
                break;
            case 5:
                long startTimeIASTAR = System.nanoTime();
                BuscaInformada buscaInformataAstar = new AStar();
                System.out.println("Iniciando em..." + buscaInformataAstar.getNomeDaEstrategia());
                buscaInformataAstar.setInicio(puzzleInicial);
                buscaInformataAstar.setObjetivo(puzzleFinal);
                buscaInformataAstar.buscar();
                long endTimeIASTAR = System.nanoTime();

                long durationIASTAR = (endTimeIASTAR - startTimeIASTAR) / 1000;  //divide by 1000000 to get milliseconds.
                for (Estado e : buscaInformataAstar.getCaminhoSolucao()) {
                    System.out.println(e);
                }

                JOptionPane.showMessageDialog(null,
                        "Resultado para " + buscaInformataAstar.getNomeDaEstrategia() + " Realizada com sucesso!" + " com dura��o de: " + durationIASTAR + " milliseconds");
                System.exit(0);
                break;

            case 6:
                long startTimeHill = System.nanoTime();
                BuscaInformada buscaHillClimbing = new HillClimbing();
                System.out.println("Iniciando em..." + buscaHillClimbing.getNomeDaEstrategia());
                buscaHillClimbing.setInicio(puzzleInicial);
                buscaHillClimbing.setObjetivo(puzzleFinal);
                buscaHillClimbing.buscar();
                long endTimeHill = System.nanoTime();

                long durationIHill = (endTimeHill - startTimeHill) / 1000;  //divide by 1000000 to get milliseconds.
                for (Estado e : buscaHillClimbing.getCaminhoSolucao()) {
                    System.out.println(e);
                }

                JOptionPane.showMessageDialog(null,
                        "Resultado para " + buscaHillClimbing.getNomeDaEstrategia() + " Realizada com sucesso!" + " com dura��o de: " + durationIHill + " milliseconds");
                System.exit(0);
        }

    }

}
