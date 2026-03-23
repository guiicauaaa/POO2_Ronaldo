package com.example.lab005; // Ajuste o pacote conforme seu projeto

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    public static void salvar(List<Pessoa> pessoas, String caminhoArquivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Pessoa p : pessoas) {
                bw.write(p.toCSV());
                bw.newLine();
            }
        }
    }

    public static List<Pessoa> carregar(String caminhoArquivo) throws IOException {
        List<Pessoa> pessoas = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return pessoas; // Retorna lista vazia se o arquivo não existir ainda
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    String nome = dados[0];
                    double altura = Double.parseDouble(dados[1]);
                    double peso = Double.parseDouble(dados[2]);
                    double imc = Double.parseDouble(dados[3]);
                    String classificacao = dados[4];

                    pessoas.add(new Pessoa(nome, altura, peso, imc, classificacao));
                }
            }
        }
        return pessoas;
    }
}