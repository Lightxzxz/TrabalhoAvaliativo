package com.example.trabalhoavaliativo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    private List<String> eventsList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main5), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etEvent = findViewById(R.id.Event);
        DatePicker datePicker = findViewById(R.id.datePicker);
        Button btnAdd = findViewById(R.id.btnAdd);
        ListView listView = findViewById(R.id.listView);

        datePicker.setCalendarViewShown(false);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eventsList);
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventDescription = etEvent.getText().toString().trim();

                if (eventDescription.isEmpty()) {
                    Toast.makeText(MainActivity5.this, "Digite uma descrição para o evento", Toast.LENGTH_SHORT).show();
                    return;
                }

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();

                String formattedDate = String.format("%02d/%02d/%d", day, month, year);
                String eventEntry = (eventsList.size() + 1) + ". " + formattedDate + " - " + eventDescription;

                eventsList.add(eventEntry);
                adapter.notifyDataSetChanged();

                etEvent.setText("");

                Toast.makeText(MainActivity5.this, "Evento adicionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}