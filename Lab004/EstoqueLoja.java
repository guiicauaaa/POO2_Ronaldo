public class EstoqueLoja {

    private String nomeProduto;
    private int[][] quantidadesPorLote;


    public EstoqueLoja() {
        this.nomeProduto = "Produto Desconhecido";
        this.quantidadesPorLote = new int[4][2];
    }


    public EstoqueLoja(String nomeProduto, int[][] quantidadesPorLote) {
        this.nomeProduto = nomeProduto;
        this.quantidadesPorLote = quantidadesPorLote;
    }


    public void imprimirEstoque() {
        System.out.println("Produto: " + nomeProduto);

        for (int i = 0; i < quantidadesPorLote.length; i++) {
            System.out.println("Lote " + (i + 1) +
                    " - Disponível: " + quantidadesPorLote[i][0] +
                    " | Vendido: " + quantidadesPorLote[i][1]);
        }
    }


    public boolean verificarLoteCritico(int limiteVenda) {
        for (int i = 0; i < quantidadesPorLote.length; i++) {
            if (quantidadesPorLote[i][1] > limiteVenda) {
                return true;
            }
        }
        return false;
    }
}
