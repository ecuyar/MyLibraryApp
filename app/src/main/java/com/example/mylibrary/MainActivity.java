package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnAllBooks, btnCurrentlyReading, btnWantToRead, btnAlreadyRead, btnAbout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.in, R.anim.out);

        initWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.in, R.anim.out);
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in, R.anim.out);
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in, R.anim.out);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in, R.anim.out);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast toast = Toast.makeText(MainActivity.this, "This section is coming soon...", Toast.LENGTH_SHORT);
                //toast.show();
                aboutTapped();
            }
        });
    }

    private void aboutTapped() {
        Log.d(TAG, "aboutTapped: started");

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("My Library App")
                .setMessage("This app is developed for educational purposes. " +
                        "\n\n" +
                        "You can open a web page by pressing OK button.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, AboutWebActivity.class);
                        intent.putExtra("URL", "https://google.com.tr");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }

    private void initWidgets() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrentBook);
        btnWantToRead = findViewById(R.id.btnWantToReadBook);
        btnAlreadyRead = findViewById(R.id.btnAlreadyReadBook);
        btnAbout = findViewById(R.id.btnAbout);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}