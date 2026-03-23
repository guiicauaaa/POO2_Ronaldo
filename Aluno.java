public class Aluno {
    private String nome;
    private double[] notas;

    // Construtor sem parâmetros
    public Aluno() {
        this.nome = "Desconhecido";
        this.notas = new double[4];
    }

    // Construtor com parâmetros
    public Aluno(String nome, double n1, double n2, double n3, double n4) {
        this.nome = nome;
        this.notas = new double[]{n1, n2, n3, n4};
    }

    public void imprimirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.print("Notas: ");
        for (double nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println();
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public boolean verificarNotaAprovacao(double valor) {
        for (double nota : notas) {
            if (nota < valor) {
                return false;
            }
        }
        return true;
    }
}