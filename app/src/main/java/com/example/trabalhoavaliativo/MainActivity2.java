package com.example.trabalhoavaliativo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnRandom = findViewById(R.id.btnAleatorio);
        Button btnReverse = findViewById(R.id.btnReverse);
        Button btnEvents = findViewById(R.id.btnEventos);

        btnRandom.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity2.this, MainActivity3.class));
        });

        btnReverse.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity2.this, MainActivity4.class));
        });

        btnEvents.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity2.this, MainActivity5.class));
        });
    }
}