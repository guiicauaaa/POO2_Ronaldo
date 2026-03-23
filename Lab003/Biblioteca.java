public class Biblioteca {
    private String nome;
    private String[] livros;

    public Biblioteca() {
        this.nome = "Biblioteca Desconhecida";
        this.livros = new String[10];
    }

    public Biblioteca(String nome, String[] livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public void imprimirLivros() {
        System.out.println("Biblioteca: " + nome);
        for (String livro : livros) {
            if (livro != null) {
                System.out.println(livro);
            }
        }
    }

    public int contarLivrosDisponiveis() {
        int count = 0;
        for (String livro : livros) {
            if (livro != null) {
                count++;
            }
        }
        return count;
    }

    public boolean verificarDisponibilidade(String nomeLivro) {
        for (String livro : livros) {
            if (livro != null && livro.equals(nomeLivro)) {
                return true;
            }
        }
        return false;
    }
}
