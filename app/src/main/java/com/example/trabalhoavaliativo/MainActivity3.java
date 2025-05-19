package com.example.trabalhoavaliativo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText Min = findViewById(R.id.Min);
        EditText Max = findViewById(R.id.Max);
        Button btnGenerate = findViewById(R.id.btnGerado);
        TextView Result = findViewById(R.id.Result);

        btnGenerate.setOnClickListener(v -> {
            try {
                int min = Integer.parseInt(Min.getText().toString());
                int max = Integer.parseInt(Max.getText().toString());

                if (min >= max) {
                    Toast.makeText(this, "O mínimo deve ser menor que o máximo!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int random = new Random().nextInt((max - min) + 1) + min;
                Result.setText(String.valueOf(random));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Digite números válidos!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}