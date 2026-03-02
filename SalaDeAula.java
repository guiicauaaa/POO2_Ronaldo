public class SalaDeAula {

    private String nomeTurma;
    private int[][] notasAlunos;


    public SalaDeAula() {
        this.nomeTurma = "Turma Desconhecida";
        this.notasAlunos = new int[5][3];
    }


    public SalaDeAula(String nomeTurma, int[][] notasAlunos) {
        this.nomeTurma = nomeTurma;
        this.notasAlunos = notasAlunos;
    }


    public void imprimirInformacoes() {
        System.out.println("Nome da Turma: " + nomeTurma);

        for (int i = 0; i < notasAlunos.length; i++) {
            System.out.print("Aluno " + (i + 1) + ": ");
            for (int j = 0; j < notasAlunos[i].length; j++) {
                System.out.print(notasAlunos[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean verificarNotasAcima(int valorMinimo) {
        for (int i = 0; i < notasAlunos.length; i++) {
            for (int j = 0; j < notasAlunos[i].length; j++) {
                if (notasAlunos[i][j] < valorMinimo) {
                    return false;
                }
            }
        }
        return true;
    }
}