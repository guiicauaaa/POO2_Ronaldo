package com.example.lab005; // Ajuste o pacote conforme seu projeto

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ImcApp extends Application {

    private TableView<Pessoa> tabela;
    private ObservableList<Pessoa> dadosPessoas;
    private final String ARQUIVO_DADOS = "dados_pessoas.txt";

    @Override
    public void start(Stage primaryStage) {
        // --- Componentes de Entrada ---
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome");

        TextField txtAltura = new TextField();
        txtAltura.setPromptText("Altura (ex: 1.75)");

        TextField txtPeso = new TextField();
        txtPeso.setPromptText("Peso (ex: 70.5)");

        Label lblResultado = new Label("IMC: ");
        lblResultado.setStyle("-fx-font-weight: bold; -fx-text-fill: blue;");

        // --- Botões ---
        Button btnCalcular = new Button("Calcular IMC");
        Button btnSalvar = new Button("Salvar");
        Button btnCarregar = new Button("Carregar");

        HBox boxBotoes = new HBox(10, btnCalcular, btnSalvar, btnCarregar);

        // --- Tabela (TableView) ---
        tabela = new TableView<>();
        dadosPessoas = FXCollections.observableArrayList();
        tabela.setItems(dadosPessoas);

        TableColumn<Pessoa, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Pessoa, Double> colAltura = new TableColumn<>("Altura");
        colAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));

        TableColumn<Pessoa, Double> colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));

        TableColumn<Pessoa, Double> colImc = new TableColumn<>("IMC");
        colImc.setCellValueFactory(new PropertyValueFactory<>("imc"));

        TableColumn<Pessoa, String> colClassificacao = new TableColumn<>("Classificação");
        colClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));

        tabela.getColumns().addAll(colNome, colAltura, colPeso, colImc, colClassificacao);

        // --- Ações dos Botões ---
        btnCalcular.setOnAction(e -> {
            try {
                String nome = txtNome.getText();
                double altura = Double.parseDouble(txtAltura.getText().replace(",", "."));
                double peso = Double.parseDouble(txtPeso.getText().replace(",", "."));

                Pessoa p = new Pessoa(nome, altura, peso);
                dadosPessoas.add(p);

                lblResultado.setText(String.format("IMC de %s: %.2f (%s)", p.getNome(), p.getImc(), p.getClassificacao()));

                // Limpar campos
                txtNome.clear(); txtAltura.clear(); txtPeso.clear();
            } catch (NumberFormatException ex) {
                mostrarAlerta("Erro de Entrada", "Por favor, insira valores numéricos válidos para peso e altura.");
            }
        });

        btnSalvar.setOnAction(e -> {
            try {
                ArquivoUtil.salvar(dadosPessoas, ARQUIVO_DADOS);
                mostrarAlerta("Sucesso", "Dados salvos com sucesso no arquivo CSV.");
            } catch (IOException ex) {
                mostrarAlerta("Erro de Arquivo", "Não foi possível salvar os dados.");
            }
        });

        btnCarregar.setOnAction(e -> {
            try {
                List<Pessoa> carregados = ArquivoUtil.carregar(ARQUIVO_DADOS);
                dadosPessoas.setAll(carregados);
                mostrarAlerta("Sucesso", "Dados carregados com sucesso.");
            } catch (IOException ex) {
                mostrarAlerta("Erro de Arquivo", "Não foi possível ler o arquivo.");
            }
        });

        // --- Layout Principal ---
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                new Label("Cadastro de IMC"),
                txtNome, txtAltura, txtPeso,
                boxBotoes, lblResultado, tabela
        );

        Scene scene = new Scene(root, 500, 600);
        primaryStage.setTitle("Calculadora de IMC - Laboratório");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}