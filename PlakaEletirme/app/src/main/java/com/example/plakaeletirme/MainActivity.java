package com.example.plakaeletirme;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listViewPlaka, listViewSehir;
    Button btnKaristir;
    ArrayList<Integer> plakaListesi;
    ArrayList<String> sehirListesi, karisikSehirListesi;

    String[] sehirler = {
            "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa",
            "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan",
            "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta",
            "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir",
            "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla",
            "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop",
            "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van",
            "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman",
            "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPlaka = findViewById(R.id.listViewPlaka);
        listViewSehir = findViewById(R.id.listViewSehir);
        btnKaristir = findViewById(R.id.btnKaristir);

        // Rastgele 1-81 arasındaki plakaları oluştur
        plakaListesi = new ArrayList<>();
        for (int i = 1; i <= 81; i++) {
            plakaListesi.add(i);
        }
        Collections.shuffle(plakaListesi); // Karıştır

        // Sehir listesi
        sehirListesi = new ArrayList<>();
        Collections.addAll(sehirListesi, sehirler);

        // Karışık şehir listesi oluştur
        karisikSehirListesi = new ArrayList<>(sehirListesi);
        Collections.shuffle(karisikSehirListesi);

        // ListView'lere Adapter ekle
        listViewPlaka.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, plakaListesi));
        listViewSehir.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, karisikSehirListesi));

        // Butona tıklanınca
        btnKaristir.setOnClickListener(v -> {
            Collections.shuffle(karisikSehirListesi);
            listViewSehir.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, karisikSehirListesi));

            // İkinci activity'ye verileri gönder
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putIntegerArrayListExtra("plakaListesi", plakaListesi);
            intent.putStringArrayListExtra("karisikSehirListesi", karisikSehirListesi);
            intent.putStringArrayListExtra("orijinalSehirListesi", sehirListesi);
            startActivity(intent);
        });
    }
}
