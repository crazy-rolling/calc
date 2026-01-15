package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Calculator {

    @FXML
    private TextField display;

    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    @FXML
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    @FXML
    private Button btnEquals, btnClear, btnDecimal;
    @FXML
    private Button btn00, btnSqrt, btnLog;

    private double firstNumber = 0;
    private String operator = "";
    private boolean newNumber = true;

    @FXML
    public void initialize() {
        // 数字ボタンの処理
        btn0.setOnAction(e -> appendNumber("0"));
        btn1.setOnAction(e -> appendNumber("1"));
        btn2.setOnAction(e -> appendNumber("2"));
        btn3.setOnAction(e -> appendNumber("3"));
        btn4.setOnAction(e -> appendNumber("4"));
        btn5.setOnAction(e -> appendNumber("5"));
        btn6.setOnAction(e -> appendNumber("6"));
        btn7.setOnAction(e -> appendNumber("7"));
        btn8.setOnAction(e -> appendNumber("8"));
        btn9.setOnAction(e -> appendNumber("9"));
        btn00.setOnAction(e -> appendNumber("00"));

        // 演算子ボタンの処理
        btnAdd.setOnAction(e -> setOperator("+"));
        btnSubtract.setOnAction(e -> setOperator("-"));
        btnMultiply.setOnAction(e -> setOperator("*"));
        btnDivide.setOnAction(e -> setOperator("/"));

        // その他のボタン
        btnEquals.setOnAction(e -> calculate());
        btnClear.setOnAction(e -> clear());
        btnDecimal.setOnAction(e -> appendNumber("."));
        btnSqrt.setOnAction(e -> calculateSqrt());
        btnLog.setOnAction(e -> calculateLog());
    }

    private void appendNumber(String num) {
        if (newNumber) {
            display.setText(num);
            newNumber = false;
        } else {
            display.setText(display.getText() + num);
        }
    }

    private void setOperator(String op) {
        try {
            String currentDisplay = display.getText();

            // 既に演算子が設定されている場合は先に計算
            if (!operator.isEmpty() && !newNumber) {
                double secondNumber = Double.parseDouble(currentDisplay);
                double result = performCalculation(firstNumber, secondNumber, operator);
                firstNumber = result;
                display.setText(result + getOperatorSymbol(op));
            } else {
                firstNumber = Double.parseDouble(currentDisplay);
                display.setText(currentDisplay + getOperatorSymbol(op));
            }

            operator = op;
            newNumber = true;
        } catch (NumberFormatException e) {
            display.setText("エラー");
        }
    }

    private String getOperatorSymbol(String op) {
        switch (op) {
            case "+":
                return "＋";
            case "-":
                return "－";
            case "*":
                return "×";
            case "/":
                return "÷";
            default:
                return "";
        }
    }

    private double performCalculation(double num1, double num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    display.setText("0で割れません");
                    return 0;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }

    private void calculate() {
        try {
            if (operator.isEmpty()) {
                return;
            }

            String displayText = display.getText();
            // 表示から演算子以降を削除して2番目の数値を取得
            String operatorSymbol = getOperatorSymbol(operator);
            int operatorIndex = displayText.lastIndexOf(operatorSymbol);

            String secondNumberStr = displayText.substring(operatorIndex + operatorSymbol.length());
            double secondNumber = Double.parseDouble(secondNumberStr);

            double result = performCalculation(firstNumber, secondNumber, operator);

            // 結果を見やすく表示
            if (result == (long) result) {
                display.setText(String.valueOf((long) result));
            } else {
                display.setText(String.format("%.2f", result));
            }

            operator = "";
            newNumber = true;
        } catch (NumberFormatException e) {
            display.setText("エラー");
        }
    }

    private void clear() {
        display.setText("");
        firstNumber = 0;
        operator = "";
        newNumber = true;
    }

    private void calculateSqrt() {
        try {
            double num = Double.parseDouble(display.getText());
            double result = Math.sqrt(num);
            display.setText(String.valueOf(result));
            newNumber = true;
        } catch (NumberFormatException e) {
            display.setText("エラー");
        }
    }

    private void calculateLog() {
        try {
            double num = Double.parseDouble(display.getText());
            double result = Math.log10(num);
            display.setText(String.valueOf(result));
            newNumber = true;
        } catch (NumberFormatException e) {
            display.setText("エラー");
        }
    }
}
