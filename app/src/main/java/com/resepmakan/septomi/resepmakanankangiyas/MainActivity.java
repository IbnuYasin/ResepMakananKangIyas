package com.resepmakan.septomi.resepmakanankangiyas;

//Nama : Ibnu Yasin
//NIM : A11.2014.08111
//Tugas Mata Kuliah : Perograman Mobile

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<resep> resepList = new ArrayList<>();
    private RecyclerView recyclerView;
    private resepAdapter rAdapter;

    public static int tanda = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        rAdapter = new resepAdapter(resepList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(rAdapter);

        MenuClickRecyclerview.addTo(recyclerView).setOnItemClickListener(new MenuClickRecyclerview.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                tanda = position;
                Intent i = new Intent(MainActivity.this,ActDetail.class);
                startActivity(i);
            }
        });

        prepareresepData();
    }
    private void prepareresepData() {
        resep Resep1 = new resep("Telur Dadar Isi Bayam",
                "Buatmu yang kurang suka sayur, mengolah telur dadar isi bayam ini bisa jadi solusi terbaik."
                , R.drawable.tlr
                , "Bahan :\n" +
                "Bayam\n" +
                "Telur\n" +
                "Bawang merah dan bawang putih\n" +
                "Minyak Goreng, cabai, garam\n"
                , "Proses :\n" +
                "Iris semua bumbu dan tambahkan garam\n" +
                "Cuci bayam lalu campur dengan bumbu\n" +
                "Tambahkan telur dan aduk merata\n" +
                "Panaskan minyak lalu goreng hingga berwarna keemasan\n" +
                "Angkat dan sajikan.");
        resepList.add(Resep1);

        resep Resep2 = new resep("Tahu Goreng Tepung Bumbu Ketumbar",
                "Selain tempe, makanan yang juga kaya akan nutrisi serta protein sehat adalah tahu."
                , R.drawable.th
                , "Bahan :\n" +
                "Tahu, tepung terigu, tepung beras, garam\n" +
                "Ketumbar, bawang putih, kaldu ayam bubuk, air\n" +
                "Minyak goreng\n" +
                "Air secukupnya\n"
                , "Proses :\n" +
                "Campur tepung terigu dan tepung beras lalu aduk rata, tambahkan bumbu\n" +
                "Lalu beri sedikit air hingga adonan menjadi encer\n" +
                "Goreng hingga berwarna kecoklatan\n" +
                "Angkat dan Tahu siap disantap");
        resepList.add(Resep2);

        resep Resep3 = new resep("Tempe Goreng", "Bagaimana cara membuat tempe goreng sederhana yang gurih dan lezat? Berikut resepnya."
                , R.drawable.tmp
                , "Bahan :\n" +
                "Tempe\n" +
                "Bawang putih\n" +
                "Ketumbar\n" +
                "Kaldu ayam bubuk\n" +
                "Kunyit\n" +
                "Air\n" +
                "Minyak goreng\n"
                , "Proses :\n" +
                "Potong tempe, haluskan semua bumbu, tambahkan sedikit air kedalam bumbu lalu aduk rata\n" +
                "Masukkan tempe kedalam bumbu, diamkan selama 10 menit\n" +
                "Goreng tempe kedalam minyak panas\n" +
                "Angkat setelah sekiranya sudah matang sampai warnanya kuning kecokelatan.\n" +
                "Nikmati selagi hangat");
        resepList.add(Resep3);

        resep Resep4 = new resep("Mie Rebus", "Mie instan sangatlah diminati banyak kalangan, terutama anak kost."
                , R.drawable.mr
                , "Bahan :\n" +
                "Mie instan\n" +
                "Cabai rawit\n" +
                "Air\n" +
                "Sayur sawi\n"
                , "Proses :\n" +
                "Rebus air, hingga mendidih\n" +
                "Masukkan sayuran dan potong atau iris cabai\n" +
                "Masukkan mie, dan siapkan bumbu mie didalam mangkok\n" +
                "Angkat setelah mienya yang direbus tadi susah siap angkat\n" +
                "Masukkan ke dalam mangkok yang sudah siap bumbu, dan aduk rata\n" +
                "Mie rebus siap di hidangkan.");
        resepList.add(Resep4);

        resep Resep5 = new resep("Mie Goreng", "Selain mie rebus, mie goreng juga sangat cocok untuk anak kost."
                , R.drawable.mg
                , "Bahan :\n" +
                "Mie instan (Jenis goreng)\n" +
                "Air\n"
                , "Proses :\n" +
                "Siapkan air dan rebus hingga mendidih\n" +
                "Masukkan mie ke dalam air mendidih\n" +
                "Siapkan mangkok dan siapkan bumbu\n" +
                "Angkat setelah mie siap diangkat, buang airnya\n" +
                "Masukkan ke mangkok yang sudah siap bumbu dan aduk rata\n" +
                "Mie Goreng siap santap");
        resepList.add(Resep5);


        rAdapter.notifyDataSetChanged();
    }
}
