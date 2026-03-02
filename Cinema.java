public class Cinema {

    private String nomeCinema;
    private boolean[][] assentos;


    public Cinema() {
        this.nomeCinema = "Cinema Desconhecido";
        this.assentos = new boolean[5][5]; // 5 fileiras, 5 assentos cada
    }


    public Cinema(String nomeCinema, boolean[][] assentos) {
        this.nomeCinema = nomeCinema;
        this.assentos = assentos;
    }


    public void imprimirAssentos() {
        System.out.println("Cinema: " + nomeCinema);

        for (int i = 0; i < assentos.length; i++) {
            System.out.print("Fileira " + (i + 1) + ": ");
            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j]) {
                    System.out.print("[O] "); // Ocupado
                } else {
                    System.out.print("[L] "); // Livre
                }
            }
            System.out.println();
        }
    }


    public boolean verificarLotacaoFileira(int numeroFileira, int limiteOcupacao) {

        if (numeroFileira < 0 || numeroFileira >= assentos.length) {
            return false;
        }

        int ocupados = 0;

        for (int j = 0; j < assentos[numeroFileira].length; j++) {
            if (assentos[numeroFileira][j]) {
                ocupados++;
            }
        }

        return ocupados > limiteOcupacao;
    }
}