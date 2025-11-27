package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField text1;
    @FXML
    private TextField Text2;
    @FXML
    private Button plus, minus, kakeru, walu;
    @FXML
    private TextField Text_Answer;

    @FXML
    private void onPlusClicked() {
        calculate('+');
    }

    @FXML
    private void onMinusClicked() {
        calculate('-');
    }

    
    @FXML
    private void onKakeruClicked() {
        calculate('*');
    }

    @FXML
    private void onWaluClicked() {
        calculate('/');
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(Text2.getText());
            double num2 = Double.parseDouble(text1.getText());
            double result = 0;

           switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        Text_Answer.setText("エラー");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            Text_Answer.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            Text_Answer.setText("入力エラー");
        }
    }
}