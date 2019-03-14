package com.coba.pengenalan;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String nilai;
    TextView textViewNilai;
    Button buttonLihatUrl;
    String alamatUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textViewNilai = findViewById(R.id.main_textview_nilai);
        buttonLihatUrl = findViewById(R.id.main_button_lihat_link_url);
        nilai = getIntent().getStringExtra("nilai");
        alamatUrl = "codelabs.unikom.ac.id";
        textViewNilai.setText(nilai);
        buttonLihatUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!alamatUrl.startsWith("http://") && !alamatUrl.startsWith("https://"))
                    alamatUrl = "http://" + alamatUrl;

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(alamatUrl));
                startActivity(browserIntent);
            }
        });
    }
}
