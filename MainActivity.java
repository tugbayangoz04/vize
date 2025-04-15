package com.example.plakaapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView randomPlakaListView, randomSehirListView;
    Button rastgeleButton;

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

        String[] sehirler = {
                "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin", "Aydın", "Balıkesir",
                "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli",
                "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari",
                "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir",
                "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir",
                "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat",
                "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman",
                "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye",
                "Düzce"
        };

        String[] plakalar = new String[81];

        for (int i = 0; i < 81; i++) {
            plakalar[i] = String.valueOf(i + 1);
        }

        randomPlakaListView = findViewById(R.id.listViewPlaka);
        randomSehirListView = findViewById(R.id.listViewSehir);
        rastgeleButton = findViewById(R.id.button);

        List<String> sehirListesi = new ArrayList<>(Arrays.asList(sehirler));
        List<String> plakaListesi = new ArrayList<>(Arrays.asList(plakalar));

        Collections.shuffle(sehirListesi);  // listeleri kar
        Collections.shuffle(plakaListesi);


        ArrayAdapter<String> adapterSehir = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sehirListesi);
        ArrayAdapter<String> adapterPlaka = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, plakaListesi);

        randomSehirListView.setAdapter(adapterSehir);
        randomPlakaListView.setAdapter(adapterPlaka);

        randomSehirListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String secilenSehir = (String) randomSehirListView.getItemAtPosition(position);
                String secilenPlaka = (String) randomPlakaListView.getItemAtPosition(position);
                int dogruPlaka = 0;

                for (int i = 0; i < sehirler.length; i++)
                {
                    if (secilenSehir.equals(sehirler[i]))
                    {
                        dogruPlaka = i + 1;
                        break;
                    }
                }
                Intent intent = new Intent(MainActivity.this, sonucEkrani.class);
                intent.putExtra("plaka", dogruPlaka);
                intent.putExtra("sehir", secilenSehir);

                if (Integer.parseInt(secilenPlaka) == dogruPlaka) {
                    intent.putExtra("sonuc", 1);
                }
                else {
                    intent.putExtra("sonuc", 0);
                }

                startActivity(intent);
            }
        });

        rastgeleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(sehirListesi);  // listeleri kar
                Collections.shuffle(plakaListesi);

                randomSehirListView.setAdapter(adapterSehir);
                randomPlakaListView.setAdapter(adapterPlaka);
            }
        });
    }
}