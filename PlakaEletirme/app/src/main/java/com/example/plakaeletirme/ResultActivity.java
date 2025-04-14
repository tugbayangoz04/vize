package com.example.plakaeletirme;

package com.example.listviewmatching;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewSonuc = findViewById(R.id.textViewSonuc);

        // Verileri al
        ArrayList<Integer> plakaListesi = getIntent().getIntegerArrayListExtra("plakaListesi");
        ArrayList<String> karisikSehirListesi = getIntent().getStringArrayListExtra("karisikSehirListesi");
        ArrayList<String> orijinalSehirListesi = getIntent().getStringArrayListExtra("orijinalSehirListesi");

        // Sonuçları oluştur
        StringBuilder sonucText = new StringBuilder();
        for (int i = 0; i < plakaListesi.size(); i++) {
            int plaka = plakaListesi.get(i);
            String karisikSehir = karisikSehirListesi.get(i);
            String dogruSehir = orijinalSehirListesi.get(plaka - 1);

            if (karisikSehir.equals(dogruSehir)) {
                sonucText.append(plaka).append(" - ").append(karisikSehir).append(": ✅ Doğru\n");
            } else {
                sonucText.append(plaka).append(" - ").append(karisikSehir)
                        .append(": ❌ Yanlış, doğru: ").append(dogruSehir).append("\n");
            }
        }

        textViewSonuc.setText(sonucText.toString());
    }
}
