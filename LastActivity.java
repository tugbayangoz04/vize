package com.example.a24mart3;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        ProgressDialog progress = new ProgressDialog(MainActivity.this);
        progress.setTitle("Başlık metni");
        progress.setMessage("mesaj metni");
        progress.setCancelable(true);

        Button buton1 = findViewById(R.id.button1);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.show();
                try
                {
                    Thread.sleep(2000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "işlem tamamlandı", Toast.LENGTH_LONG).show();
            }
        });


    }
}