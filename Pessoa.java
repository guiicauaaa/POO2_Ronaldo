package com.example.lab005; // Ajuste o pacote conforme seu projeto

public class Pessoa {
    private String nome;
    private double altura;
    private double peso;
    private double imc;
    private String classificacao;

    public Pessoa(String nome, double altura, double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        calcularImcEClassificacao();
    }

    // Construtor usado ao carregar do arquivo
    public Pessoa(String nome, double altura, double peso, double imc, String classificacao) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
        this.classificacao = classificacao;
    }

    private void calcularImcEClassificacao() {
        this.imc = this.peso / (this.altura * this.altura);

        if (this.imc < 18.5) {
            this.classificacao = "Abaixo do Peso";
        } else if (this.imc < 25.0) {
            this.classificacao = "Peso Normal";
        } else if (this.imc < 30.0) {
            this.classificacao = "Sobrepeso";
        } else if (this.imc < 35.0) {
            this.classificacao = "Obesidade Grau 1";
        } else if (this.imc < 40.0) {
            this.classificacao = "Obesidade Grau 2";
        } else {
            this.classificacao = "Obesidade Grau 3";
        }
    }

    // Getters são OBRIGATÓRIOS para o TableView do JavaFX funcionar
    public String getNome() { return nome; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }
    public double getImc() { return imc; }
    public String getClassificacao() { return classificacao; }

    // Método utilitário para formatar a linha do CSV
    public String toCSV() {
        return nome + "," + altura + "," + peso + "," + imc + "," + classificacao;
    }
}