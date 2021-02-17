package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private static final String TAG = "BookActivity";

    private TextView bookName, authorName, description, page;
    private ImageView bookImage;
    private Button btnCurReading, btnWantToRead, btnAlreadyRead;
    private Book incomingBook;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId", 0);
        util = new Util();
        ArrayList<Book> books = util.getAllBooks();

        for (Book b : books) {
            if (b.getId() == id) {
                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                String sb = "Pages: " + b.getPages();
                page.setText(sb);
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }

        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurReadingTapped();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadTapped();
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });
    }

    private void btnCurReadingTapped() {
        Log.d(TAG, "btnCurReadingTapped: started");

        boolean exist = false;

        ArrayList<Book> currentlyReadingBooksList = util.getCurrentlyReadingBooks();

        for (Book b : currentlyReadingBooksList) {
            if (b.getId() == incomingBook.getId()) {
                //incoming book exist in currently reading books list so don't add again and alert
                exist = true;
                break;
            }
        }

        if (exist) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to Currently Reading Books list!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            //if user does not click a button in alert, dialog box can not be closed
            builder.setCancelable(false);
            builder.create().show();
        } else {
            util.addCurrentlyReadingBook(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName() + " added to Currently Reading Books list.", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnAlreadyReadTapped() {
        Log.d(TAG, "btnAlreadyReadTapped: started");

        boolean exist = false;

        ArrayList<Book> alreadyReadBooksList = util.getAlreadyReadBooks();

        for (Book b : alreadyReadBooksList) {
            if (b.getId() == incomingBook.getId()) {
                //incoming book exist in currently reading books list so don't add again and alert
                exist = true;
                break;
            }
        }

        if (exist) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to Already Read Books list!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            //if user does not click a button in alert, dialog box can not be closed
            builder.setCancelable(false);
            builder.create().show();
        } else {
            util.addAlreadyReadBook(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName() + " added to Already Read Books list.", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnWantToReadTapped() {
        Log.d(TAG, "btnWantToReadTapped: started");

        boolean exist = false;

        ArrayList<Book> wantToReadBooksList = util.getWantToReadBooks();

        for (Book b : wantToReadBooksList) {
            if (b.getId() == incomingBook.getId()) {
                //incoming book exist in currently reading books list so don't add again and alert
                exist = true;
                break;
            }
        }

        if (exist) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to Want To Read Books list!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            //if user does not click a button in alert, dialog box can not be closed
            builder.setCancelable(false);
            builder.create().show();
        } else {
            util.addWantToReadBook(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName() + " added to Want To Read Books list.", Toast.LENGTH_SHORT).show();
        }
    }

    private void initWidgets() {
        bookName = findViewById(R.id.bookName);
        bookImage = findViewById(R.id.bookImage);
        authorName = findViewById(R.id.bookAuthor);
        description = findViewById(R.id.bookDesc);
        page = findViewById(R.id.bookPages);

        btnCurReading = findViewById(R.id.btnAddCurrent);
        btnAlreadyRead = findViewById(R.id.btnAddAlready);
        btnWantToRead = findViewById(R.id.btnAddWant);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}