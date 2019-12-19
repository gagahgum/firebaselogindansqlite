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
    Button logout;
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
        rvKategori = findViewById(R.id.rvKontak);
        rvKategori.setHasFixedSize(true);
        rvKategori.setLayoutManager(new LinearLayoutManager(this));

        KontakAdapter adapter = new KontakAdapter(MainActivity.this, DBHelper.getInstance(this).getAllKontak());
        rvKategori.setAdapter(adapter);
    }


}
