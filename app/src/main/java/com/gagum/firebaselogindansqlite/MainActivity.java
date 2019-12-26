package com.gagum.firebaselogindansqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gagum.firebaselogindansqlite.DB.DBHelper;
import com.gagum.firebaselogindansqlite.adapter.KontakAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvKategori;
    Button insert, logout;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            startActivity(new Intent(MainActivity.this, Login.class));
            finish();
        }
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });

        insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = "gacer";
                String nomor = "081227285827";
                String alamat = "mantab";
                DBHelper.getInstance(MainActivity.this).insert(nama,nomor,alamat);
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
        rvKategori = findViewById(R.id.rvKontak);
        rvKategori.setHasFixedSize(true);
        rvKategori.setLayoutManager(new LinearLayoutManager(this));

        KontakAdapter adapter = new KontakAdapter(MainActivity.this, DBHelper.getInstance(this).getAllKontak());
        rvKategori.setAdapter(adapter);
    }


}
