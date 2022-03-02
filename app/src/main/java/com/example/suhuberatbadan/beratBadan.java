package com.example.suhuberatbadan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class beratBadan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat_badan);

        TextView beratBadan = findViewById(R.id.berat_badan);
        TextView tinggiBadan = findViewById(R.id.tinggi_badan);
        TextView txtHasil = findViewById(R.id.txthasil);
        TextView txtStatus = findViewById(R.id.txtstatus);
        Button btnHitung = findViewById(R.id.btn_hitung);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float bb = Float.parseFloat(beratBadan.getText().toString());
                float tb = Float.parseFloat(tinggiBadan.getText().toString());
                String status;

                float hasil = bb/(tb*tb);

                if (hasil < 18.5){
                    status = "Kekurangan Berat Badan";
                }else if (hasil >= 18.5 && hasil < 25.0){
                    status = "Normal (ideal)";
                }else if (hasil >= 25.0 && hasil < 30.0){
                    status = "Kelebihan Berat Badan";
                }else if (hasil >= 30.0){
                    status = "Kegemukan (Obesitas)";
                }else {
                    status = "Ga tau lagi lah cape gua";
                }

                txtHasil.setText(String.valueOf(hasil));
                txtStatus.setText(status);

            }
        });

    }
}