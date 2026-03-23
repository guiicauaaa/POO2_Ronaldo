public class Main {
    public static void main(String[] args) {

        // ===== TESTE ALUNO =====
        System.out.println("=== TESTE ALUNO ===");
        Aluno aluno = new Aluno("João", 7.5, 8.0, 6.5, 9.0);
        aluno.imprimirInformacoes();
        System.out.println("Média: " + aluno.calcularMedia());
        System.out.println("Aprovado em todas >= 6? " + aluno.verificarNotaAprovacao(6));
        System.out.println();

        // ===== TESTE TURMA =====
        System.out.println("=== TESTE TURMA ===");
        String[] alunosTurma = {"João", "Maria", "Pedro", null, null};
        Turma turma = new Turma("Turma A", alunosTurma);
        turma.imprimirTurma();
        System.out.println("Quantidade de alunos: " + turma.quantidadeAlunos());
        System.out.println("Maria está na turma? " + turma.buscarAluno("Maria"));
        System.out.println();

        // ===== TESTE BIBLIOTECA =====
        System.out.println("=== TESTE BIBLIOTECA ===");
        String[] livros = {"Java Básico", "POO Avançado", null, "Estruturas de Dados"};
        Biblioteca biblioteca = new Biblioteca("Minha Biblioteca", livros);
        biblioteca.imprimirLivros();
        System.out.println("Livros disponíveis: " + biblioteca.contarLivrosDisponiveis());
        System.out.println("Livro 'Java Básico' disponível? " + biblioteca.verificarDisponibilidade("Java Básico"));
        System.out.println();

        // ===== TESTE EMPRESA =====
        System.out.println("=== TESTE EMPRESA ===");
        String[] funcionarios = {"Carlos", "Ana", null, "Marcos"};
        Empresa empresa = new Empresa("Tech Ltda", funcionarios);
        empresa.imprimirFuncionarios();
        System.out.println("Total de funcionários: " + empresa.contarFuncionarios());
        System.out.println("Ana trabalha aqui? " + empresa.verificarFuncionario("Ana"));
        System.out.println();

        // ===== TESTE ESTOQUE =====
        System.out.println("=== TESTE ESTOQUE ===");
        Estoque estoque = new Estoque("Notebook", 10, 5, 0, 8, 3);
        estoque.imprimirEstoque();
        System.out.println("Total em estoque: " + estoque.calcularTotalEstoque());
        System.out.println("Algum lote > 6? " + estoque.verificarDisponibilidade(6));
    }
}