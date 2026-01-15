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
    private Button bmi;
    @FXML
    private Button triangle;
    @FXML
    private Label lavel1;
    @FXML
    private Label lavel2;
    @FXML
    private Button circle;

    @FXML
    private void onPlusClicked() {
        removeSpeedStyle();
        resetLabels();
        calculate('+');
    }

    @FXML
    private void onMinusClicked() {
        removeSpeedStyle();
        resetLabels();
        calculate('-');
    }

    @FXML
    private void onKakeruClicked() {
        removeSpeedStyle();
        resetLabels();
        calculate('*');
    }

    @FXML
    private void onWaluClicked() {
        removeSpeedStyle();
        resetLabels();
        calculate('/');
    }

    @FXML
    private void onTriangleClicked() {
        removeSpeedStyle();
        lavel1.setText("底辺");
        lavel2.setText("高さ");
        calculateTriangle();
    }

    @FXML
    private void onBMIClicked() {
        removeSpeedStyle();
        lavel1.setText("体重(kg)");
        lavel2.setText("身長(m)");
        calculateBMI();
    }

    private void resetLabels() {
        lavel1.setText("1");
        lavel2.setText("2");
    }

    @FXML
    private void onCircleClicked() {
        removeSpeedStyle();
        lavel1.setText("半径");
        lavel2.setText("半径");
        calculateCricle();
    }

    @FXML
    private Button speed;

    @FXML
    private void onSpeedClicked() {
        lavel1.setText("距離");
        lavel2.setText("時間");
        addSpeedStyle();
        calculateSpeed();
    }

    private void removeSpeedStyle() {
        text1.setStyle("");
        Text2.setStyle("");
    }

    private void addSpeedStyle() {
        text1.setStyle("-fx-border-color: #FF6B6B; -fx-border-width: 2; -fx-border-radius: 5;");
        Text2.setStyle("-fx-border-color: #FF6B6B; -fx-border-width: 2; -fx-border-radius: 5;");
    }

    private void calculateSpeed() {
        try {
            // 入力値を取得
            String input1 = Text2.getText().trim();
            String input2 = text1.getText().trim();

            // 入力値の確認
            if (input1.isEmpty() || input2.isEmpty()) {
                Text_Answer.setText("値を入力してください");
                Text2.clear();
                text1.clear();
                return;
            }

            double distance = Double.parseDouble(input1); // 距離
            double time = Double.parseDouble(input2); // 時間

            if (time <= 0) {
                Text_Answer.setText("時間は正の数でなければなりません");
                return;
            }

            // 速度 = 距離 / 時間
            double speed = distance / time;

            // 結果を見やすく表示（小数点以下2桁まで）
            Text_Answer.setText(String.format("%.2f", speed));

            // 計算実行後、入力フィールドをクリア
            Text2.clear();
            text1.clear();

        } catch (NumberFormatException e) {
            Text_Answer.setText("数値を入力してください");
            Text2.clear();
            text1.clear();
        }
    }

    private void calculateTriangle() {
        try {
            // 入力値を取得
            String input1 = Text2.getText().trim();
            String input2 = text1.getText().trim();

            // 入力値の確認
            if (input1.isEmpty() || input2.isEmpty()) {
                Text_Answer.setText("値を入力してください");
                Text2.clear();
                text1.clear();
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
            Text2.clear();
            text1.clear();
        }
    }

    private void calculateBMI() {
        // BMI計算ロジックをここに実装
        try {
            // 入力値を取得
            String input1 = Text2.getText().trim();
            String input2 = text1.getText().trim();

            // 入力値の確認
            if (input1.isEmpty() || input2.isEmpty()) {
                Text_Answer.setText("値を入力してください");
                Text2.clear();
                text1.clear();
                return;
            }

            double weight = Double.parseDouble(input1); // 体重(kg)
            double height = Double.parseDouble(input2); // 身長(m)

            if (height <= 0) {
                Text_Answer.setText("身長は正の数でなければなりません");
                return;
            }

            // BMI = 体重(kg) / (身長(m) * 身長(m))
            double bmi = weight / (height * height);

            // 結果を見やすく表示（小数点以下2桁まで）
            Text_Answer.setText(String.format("%.2f", bmi));

            // 計算実行後、入力フィールドをクリア
            Text2.clear();
            text1.clear();

        } catch (NumberFormatException e) {
            Text_Answer.setText("数値を入力してください");
            Text2.clear();
            text1.clear();
        }
    }

    private void calculateCricle() {
        try {
            // 入力値を取得（テキストフィールド1の値を使用）
            String input1 = text1.getText().trim();

            // 入力値の確認
            if (input1.isEmpty()) {
                Text_Answer.setText("値を入力してください");
                Text2.clear();
                text1.clear();
                return;
            }

            double radius = Double.parseDouble(input1);

            if (radius <= 0) {
                Text_Answer.setText("半径は正の数でなければなりません");
                return;
            }

            // 円の面積 = 半径 × 半径 × π
            double area = radius * radius * Math.PI;

            // 結果を見やすく表示（小数点以下2桁まで）
            Text_Answer.setText(String.format("%.2f", area));

            // 計算実行後、入力フィールドをクリア
            Text2.clear();
            text1.clear();

        } catch (NumberFormatException e) {
            Text_Answer.setText("数値を入力してください");
            Text2.clear();
            text1.clear();
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
                Text2.clear();
                text1.clear();
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
            Text2.clear();
            text1.clear();
        }
    }
}
