package com.coba.pengenalan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextDiameter;
    TextView textViewLuas;
    Button buttonHitungLuas;

    private static double phi = 3.14;
    private double diameter = 0;
    private double jariJari = 0;
    private double luasLingkaran = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDiameter = findViewById(R.id.main_edit_text_diameter);
        textViewLuas = findViewById(R.id.main_textview_luas);
        buttonHitungLuas = findViewById(R.id.main_button_hitung);

        buttonHitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextDiameter.getText().toString() == null || editTextDiameter.getText().toString().isEmpty()) {
                    diameter = 0.0;
                } else {
                    diameter = Double.parseDouble(editTextDiameter.getText().toString());
                }
                jariJari = diameter / 2;

                luasLingkaran = phi * jariJari * jariJari;
                textViewLuas.setText("Luas = " + luasLingkaran);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        luasLingkaran = 0;
        Log.e("onStart", "Inisialisasi luas Lingkaran" + String.valueOf(luasLingkaran));
        Toast.makeText(this, "Luas lingkaran saat activity dimulai " + String.valueOf(luasLingkaran), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "Luas Lingkaran Saat activity berhenti" + String.valueOf(luasLingkaran));
        Toast.makeText(this, "Luas lingkaran saat activity berhenti (Stop) " + String.valueOf(luasLingkaran), Toast.LENGTH_SHORT).show();
    }
}
