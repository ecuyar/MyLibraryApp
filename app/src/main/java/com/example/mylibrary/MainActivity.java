package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks, btnCurrentlyReading, btnWantToRead, btnAlreadyRead, btnAbout;
    private TextView baslik;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooks.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "This section is coming soon...", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void initWidgets() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrentBook);
        btnWantToRead = findViewById(R.id.btnWantToReadBook);
        btnAlreadyRead = findViewById(R.id.btnAlreadyReadBook);
        btnAbout = findViewById(R.id.btnAbout);

        baslik = findViewById(R.id.txtName);
    }


}