/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ahnaf
 */


package com.kalkulator.kalkulatorbmi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BmiController {

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtBerat;

    @FXML
    private TextField txtTinggi;

    @FXML
    private Label lblHasil;

    @FXML
    private Label lblKategori;

    @FXML
    private void hitungBMI() {
        try {
            String nama = txtNama.getText().trim();
            double berat = Double.parseDouble(txtBerat.getText().trim());
            double tinggi = Double.parseDouble(txtTinggi.getText().trim());

            if (berat <= 0 || tinggi <= 0) {
                lblHasil.setText("Input harus lebih dari 0");
                lblKategori.setText("");
                return;
            }

            tinggi = tinggi / 100.0;
            double bmi = berat / (tinggi * tinggi);

            lblHasil.setText(String.format("BMI: %.2f", bmi));

            String kategori;

            if (bmi < 18.5) {
                kategori = "Berat Badan Kurang";
            } else if (bmi < 25) {
                kategori = "Berat Badan Normal";
            } else if (bmi < 30) {
                kategori = "Berat Badan Berlebih";
            } else {
                kategori = "Obesitas";
            }

            if (nama.isEmpty()) {
                lblKategori.setText(kategori);
            } else {
                lblKategori.setText(nama + " - " + kategori);
            }

        } catch (NumberFormatException e) {
            lblHasil.setText("Masukkan angka yang valid");
            lblKategori.setText("");
        }
    }

    @FXML
    private void reset() {
        txtNama.clear();
        txtBerat.clear();
        txtTinggi.clear();
        lblHasil.setText("Hasil BMI");
        lblKategori.setText("Kategori akan muncul di sini");
    }
}
