public class Estoque {
    private String produto;
    private int[] quantidades;

    public Estoque() {
        this.produto = "Produto Desconhecido";
        this.quantidades = new int[5];
    }

    public Estoque(String produto, int q1, int q2, int q3, int q4, int q5) {
        this.produto = produto;
        this.quantidades = new int[]{q1, q2, q3, q4, q5};
    }

    public void imprimirEstoque() {
        System.out.println("Produto: " + produto);
        for (int q : quantidades) {
            System.out.println("Quantidade: " + q);
        }
    }

    public int calcularTotalEstoque() {
        int total = 0;
        for (int q : quantidades) {
            total += q;
        }
        return total;
    }

    public boolean verificarDisponibilidade(int minimo) {
        for (int q : quantidades) {
            if (q > minimo) {
                return true;
            }
        }
        return false;
    }
}
