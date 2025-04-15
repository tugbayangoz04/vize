package com.example.plakaapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class sonucEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sonuc_ekrani);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView sonucText = findViewById(R.id.textView);
        Button geriButton = findViewById(R.id.button2);

        Intent intent = getIntent();
        int dogruPlaka = intent.getIntExtra("plaka", 0);
        String sehir = intent.getStringExtra("sehir");
        int sonuc = intent.getIntExtra("sonuc", 0);

        if (sonuc == 1)
        {

        }
        else if (sonuc == 0)
        {
            sonucText.setText("Yanlış Seçim! \n" + sehir + " için doğru plaka " + dogruPlaka);
        }

        geriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sonucEkrani.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}