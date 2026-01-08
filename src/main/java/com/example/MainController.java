package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField text1;
    @FXML
    private TextField Text2;
    @FXML
    private Button plus, minus, kakeru, walu;
    @FXML
    private Label Text_Answer;
    @FXML
    private Button BMI;
    @FXML
    private Button triangle;
    @FXML
    private Label lavel1;
    @FXML
    private Label lavel2;

    @FXML
    private void onPlusClicked() {
        resetLabels();
        calculate('+');
    }

    @FXML
    private void onMinusClicked() {
        resetLabels();
        calculate('-');
    }

    @FXML
    private void onKakeruClicked() {
        resetLabels();
        calculate('*');
    }

    @FXML
    private void onWaluClicked() {
        resetLabels();
        calculate('/');
    }

    @FXML
    private void onTriangleClicked() {
        lavel1.setText("底辺");
        lavel2.setText("高さ");
        calculateTriangle();
    }

    private void resetLabels() {
        lavel1.setText("1");
        lavel2.setText("2");
    }

    private void calculateTriangle() {
        try {
            // 入力値を取得
            String input1 = Text2.getText().trim();
            String input2 = text1.getText().trim();

            // 入力値の確認
            if (input1.isEmpty() || input2.isEmpty()) {
                Text_Answer.setText("値を入力してください");
                return;
            }

            double base = Double.parseDouble(input1);
            double height = Double.parseDouble(input2);

            // 三角形の面積 = 底辺 × 高さ ÷ 2
            double area = (base * height) / 2;

            // 結果を見やすく表示
            if (area == (long) area) {
                // 整数の場合
                Text_Answer.setText(String.valueOf((long) area));
            } else {
                // 小数の場合（小数点以下2桁まで）
                Text_Answer.setText(String.format("%.2f", area));
            }

            // 計算実行後、入力フィールドをクリア
            Text2.clear();
            text1.clear();

        } catch (NumberFormatException e) {
            Text_Answer.setText("数値を入力してください");
        }
    }

    private void calculate(char operator) {
        try {
            // 入力値を取得
            String input1 = Text2.getText().trim();
            String input2 = text1.getText().trim();

            // 入力値の確認
            if (input1.isEmpty() || input2.isEmpty()) {
                Text_Answer.setText("値を入力してください");
                return;
            }

            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double result = 0;
            String operatorSymbol = "";

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    operatorSymbol = "＋";
                    break;
                case '-':
                    result = num1 - num2;
                    operatorSymbol = "－";
                    break;
                case '*':
                    result = num1 * num2;
                    operatorSymbol = "×";
                    break;
                case '/':
                    if (num2 == 0) {
                        Text_Answer.setText("0で割ることはできません");
                        return;
                    }
                    result = num1 / num2;
                    operatorSymbol = "÷";
                    break;
            }

            // 結果を見やすく表示
            if (result == (long) result) {
                // 整数の場合
                Text_Answer.setText(String.valueOf((long) result));
            } else {
                // 小数の場合（小数点以下2桁まで）
                Text_Answer.setText(String.format("%.2f", result));
            }

            // 計算実行後、入力フィールドをクリア
            Text2.clear();
            text1.clear();

        } catch (NumberFormatException e) {
            Text_Answer.setText("数値を入力してください");
        }
    }
}
