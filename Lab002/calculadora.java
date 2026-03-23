package calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Locale;

public class ImcController {

    // Estas variáveis precisam ter o mesmo nome do fx:id no FXML
    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtAltura;

    @FXML
    private Label lblResultadoImc;

    @FXML
    private Label lblClassificacao;

    // Este método precisa ter o mesmo nome do onAction no FXML
    @FXML
    void onCalcularClick(ActionEvent event) {
        try {
            // Garante que o parse aceite ponto ou vírgula dependendo da região
            // Mas para simplificar, vamos assumir ponto decimal aqui.
            double peso = Double.parseDouble(txtPeso.getText().replace(",", "."));
            double altura = Double.parseDouble(txtAltura.getText().replace(",", "."));

            // Lógica do cálculo
            double imc = peso / (altura * altura);

            // Formata o resultado para 2 casas decimais
            lblResultadoImc.setText(String.format(Locale.US, "%.2f", imc));

            // Classificação do IMC
            String classificacao = interpretarImc(imc);
            lblClassificacao.setText(classificacao);

            // Opcional: Mudar cor do texto dependendo do resultado
            if (classificacao.equals("Peso Normal")) {
                lblClassificacao.setStyle("-fx-text-fill: green;");
            } else {
                lblClassificacao.setStyle("-fx-text-fill: red;");
            }

        } catch (NumberFormatException e) {
            lblResultadoImc.setText("Erro");
            lblClassificacao.setText("Digite números válidos (ex: 70.5)");
            lblClassificacao.setStyle("-fx-text-fill: darkred;");
        } catch (ArithmeticException e) {
            lblResultadoImc.setText("Erro");
            lblClassificacao.setText("Altura não pode ser zero");
        }
    }

    // Método auxiliar de lógica
    private String interpretarImc(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25.0) return "Peso Normal";
        if (imc < 30.0) return "Sobrepeso";
        if (imc < 35.0) return "Obesidade Grau I";
        if (imc < 40.0) return "Obesidade Grau II";
        return "Obesidade Grau III (Mórbida)";
    }
}