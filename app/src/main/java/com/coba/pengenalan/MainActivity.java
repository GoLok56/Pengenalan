package com.coba.pengenalan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNilai;
    Button buttonKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNilai = findViewById(R.id.main_edittext_nilai_yang_dikirim);
        buttonKirim = findViewById(R.id.main_button_second_activity);
        buttonKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNilai.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Isi dahulu nilai yang ingin dikirim ke Activity kedua", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                    intentSecondActivity.putExtra("nilai", editTextNilai.getText().toString());
                    startActivity(intentSecondActivity);
                }
            }
        });
    }
}
