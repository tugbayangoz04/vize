package com.example.a24subat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buton1 = (Button) findViewById(R.id.button1);
        Button buton2 = (Button) findViewById(R.id.button2);
        EditText edit1 = (EditText) findViewById(R.id.editTextText1);
        EditText edit2 = (EditText) findViewById(R.id.editTextText2);
        TextView text1 = (TextView) findViewById(R.id.textView1);
        TextView text2 = (TextView) findViewById(R.id.textView2);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sayi1 = Integer.parseInt(edit1.getText().toString());
                int sayi2 = Integer.parseInt(edit2.getText().toString());

                int randomSayi = ThreadLocalRandom.current().nextInt(sayi1, sayi2);

                text1.setText(String.valueOf(randomSayi));

            }
        });

        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sayi = Integer.parseInt(text1.getText().toString());
                int faktoriyel = 1;

                for (int i = 1; i <= sayi; i++)
                {
                    faktoriyel = faktoriyel * i;
                }

                text2.setText(String.valueOf(faktoriyel));
            }
        });
    }
}