public class Main {

    public static void main(String[] args) {


        // TESTE 1 - SalaDeAula

        System.out.println("===== TESTE SALA DE AULA =====");

        int[][] notas = {
                {7, 8, 9},
                {6, 5, 7},
                {10, 9, 8},
                {4, 6, 5},
                {8, 7, 9}
        };

        SalaDeAula sala = new SalaDeAula("ESN4", notas);
        sala.imprimirInformacoes();

        System.out.println("Todas as notas >= 5? " + sala.verificarNotasAcima(5));
        System.out.println();


        // ==========================
        // TESTE 2 - EstoqueLoja
        // ==========================
        System.out.println("===== TESTE ESTOQUE =====");

        int[][] lotes = {
                {100, 30},
                {80, 60},
                {50, 20},
                {120, 90}
        };

        EstoqueLoja estoque = new EstoqueLoja("Notebook", lotes);
        estoque.imprimirEstoque();

        System.out.println("Algum lote vendeu mais que 70? "
                + estoque.verificarLoteCritico(70));
        System.out.println();


        // ==========================
        // TESTE 3 - Cinema
        // ==========================
        System.out.println("===== TESTE CINEMA =====");

        boolean[][] assentos = {
                {true, false, true, false, false},
                {true, true, true, false, false},
                {false, false, false, false, false},
                {true, true, true, true, false},
                {false, false, true, false, true}
        };

        Cinema cinema = new Cinema("Cine Central", assentos);
        cinema.imprimirAssentos();

        System.out.println("Fileira 1 tem mais de 2 ocupados? "
                + cinema.verificarLotacaoFileira(0, 2));
        System.out.println();


        // ==========================
        // TESTE 4 - MatrizNumerica
        // ==========================
        System.out.println("===== TESTE MATRIZ NUMÉRICA =====");

        int[][] numeros = {
                {5, 2, 3},
                {4, 6, 1},
                {7, 8, 9}
        };

        MatrizNumerica matriz = new MatrizNumerica("Matriz Teste", numeros);
        matriz.imprimirMatriz();

        System.out.println("Diagonal principal > 4? "
                + matriz.verificarDiagonal(4));
    }
}