public class Turma {
    private String nomeTurma;
    private String[] alunos;

    public Turma() {
        this.nomeTurma = "Sem Nome";
        this.alunos = new String[5];
    }

    public Turma(String nomeTurma, String[] alunos) {
        this.nomeTurma = nomeTurma;
        this.alunos = alunos;
    }

    public void imprimirTurma() {
        System.out.println("Turma: " + nomeTurma);
        for (String aluno : alunos) {
            if (aluno != null) {
                System.out.println(aluno);
            }
        }
    }

    public int quantidadeAlunos() {
        int count = 0;
        for (String aluno : alunos) {
            if (aluno != null) {
                count++;
            }
        }
        return count;
    }

    public boolean buscarAluno(String nome) {
        for (String aluno : alunos) {
            if (aluno != null && aluno.equals(nome)) {
                return true;
            }
        }
        return false;
    }
}
