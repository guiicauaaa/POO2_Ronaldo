public class Empresa {
    private String nome;
    private String[] funcionarios;

    public Empresa() {
        this.nome = "Empresa Desconhecida";
        this.funcionarios = new String[8];
    }

    public Empresa(String nome, String[] funcionarios) {
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public void imprimirFuncionarios() {
        System.out.println("Empresa: " + nome);
        for (String func : funcionarios) {
            if (func != null) {
                System.out.println(func);
            }
        }
    }

    public int contarFuncionarios() {
        int count = 0;
        for (String func : funcionarios) {
            if (func != null) {
                count++;
            }
        }
        return count;
    }

    public boolean verificarFuncionario(String nomeFunc) {
        for (String func : funcionarios) {
            if (func != null && func.equals(nomeFunc)) {
                return true;
            }
        }
        return false;
    }
}
