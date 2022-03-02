package com.example.suhuberatbadan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = findViewById(R.id.suhu1);
        Spinner spinner2 = findViewById(R.id.suhu2);
        EditText inputSuhu = findViewById(R.id.input_suhu);
        TextView txtHasil = findViewById(R.id.txthasil);
        Button btnHitung = findViewById(R.id.btn_hitung);
        TextView txtRumus = findViewById(R.id.txtrumus);
        Button btnPindah = findViewById(R.id.btn_pindah);


        List<String> Suhu = new ArrayList<>();
        Suhu.add("°C");
        Suhu.add("°F");
        Suhu.add("K");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Suhu);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double suhuInput = Double.parseDouble(inputSuhu.getText().toString());
                String suhu1 = spinner1.getSelectedItem().toString();
                String suhu2 = spinner2.getSelectedItem().toString();
                double hasil;
                String rumus = null;

                if (suhu1 == "°C" && suhu2 == "°F"){
                    hasil = (suhuInput * 1.8) + 32;
                    rumus = suhu2 + " = (" + suhuInput + " x 1.8) + 32" + "\n" + suhu2 + " = " + hasil;
                }else if (suhu1 == "°C" && suhu2 == "K"){
                    hasil = suhuInput + 273.15;
                    rumus = suhu2 + " = " + suhuInput + " + 273.15" + "\n" + suhu2 + " = " + hasil;
                }else if (suhu1 == "°C" && suhu2 == "°C"){
                    hasil = suhuInput;
                    rumus = "-";
                }else if (suhu1 == "°F" && suhu2 == "°C"){
                    hasil = (suhuInput - 32) * 1.8;
                    rumus = suhu2 + " = (" + suhuInput + " - 32) x 1.8" + "\n" + suhu2 + " = " + hasil;
                }else  if (suhu1 == "°F" && suhu2 == "K"){
                    hasil = (suhuInput -32) * 5 / 9 + 273.15;
                    rumus = suhu2 + " = (" + suhuInput + " - 32) x 5 / 9 + 273.15" + "\n" + suhu2 + " = " + hasil;
                }else  if (suhu1 == "°F" && suhu2 == "°F"){
                    hasil = suhuInput;
                    rumus = "-";
                }else if (suhu1 == "K" && suhu2 == "°F"){
                    hasil = (suhuInput - 273.15) * 9 / 5 + 32;
                    rumus = suhu2 + " = (" + suhuInput + " - 273.15) x 9 / 5 + 32" + "\n" + suhu2 + " = " + hasil;
                }else if (suhu1 == "K" && suhu2 == "°C"){
                    hasil = suhuInput - 273.15;
                    rumus = suhu2 + " = " + suhuInput + " - 273.15" + "\n" + suhu2 + " = " + hasil;
                }else if (suhu1 == "K" && suhu2 == "K"){
                    hasil = suhuInput;
                    rumus = "-";
                }else {
                    hasil = 0;
                }

                txtHasil.setText(String.valueOf(hasil) + " " + suhu2);
                txtRumus.setText(rumus);

                btnPindah.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, beratBadan.class);
                        startActivity(intent);
                    }
                });

            }
        });

    }
}