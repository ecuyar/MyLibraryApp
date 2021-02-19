package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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
    private Drawable defaultBtnStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();
        Button defaultButton = new Button(this);
        defaultBtnStyle = defaultButton.getBackground();

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

        checkList(incomingBook);

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

        ArrayList<Book> currentlyReadingBooksList = util.getCurrentlyReadingBooks();

        if (currentlyReadingBooksList.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to remove this book from Currently Reading Books list?");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (util.removeCurrentlyReadingBook(incomingBook)) {
                        Toast.makeText(BookActivity.this, "The book is removed from the list.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BookActivity.this, "An error occured while removing the book from list!", Toast.LENGTH_SHORT).show();
                    }
                    checkList(incomingBook);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } else {
            if (util.addCurrentlyReadingBook(incomingBook)) {
                Toast.makeText(this, "The book " + incomingBook.getName() + " added to Currently Reading Books list.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "An error occured while adding the book to list!", Toast.LENGTH_SHORT).show();
            }
            checkList(incomingBook);
        }
    }

    private void btnAlreadyReadTapped() {
        Log.d(TAG, "btnAlreadyReadTapped: started");

        ArrayList<Book> alreadyReadBooksList = util.getAlreadyReadBooks();

        if (alreadyReadBooksList.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to remove this book from Already Read Books list?");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (util.removeAlreadyReadBook(incomingBook)) {
                        Toast.makeText(BookActivity.this, "The book is removed from the list.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BookActivity.this, "An error occured while removing the book from list!", Toast.LENGTH_SHORT).show();
                    }
                    checkList(incomingBook);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } else {
            if (util.addAlreadyReadBook(incomingBook)) {
                Toast.makeText(this, "The book " + incomingBook.getName() + " added to Already Read Books list.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "An error occured while adding the book to list!", Toast.LENGTH_SHORT).show();
            }
            checkList(incomingBook);
        }
    }

    private void btnWantToReadTapped() {
        Log.d(TAG, "btnWantToReadTapped: started");

        ArrayList<Book> wantToReadBooksList = util.getWantToReadBooks();

        if (wantToReadBooksList.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to remove this book from Want To Read Books list?");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (util.removeWantToReadBook(incomingBook)) {
                        Toast.makeText(BookActivity.this, "The book is removed from the list.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BookActivity.this, "An error occured while removing the book from list!", Toast.LENGTH_SHORT).show();
                    }
                    checkList(incomingBook);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } else {
            if (util.addWantToReadBook(incomingBook)) {
                Toast.makeText(this, "The book " + incomingBook.getName() + " added to Want To Read Books list.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "An error occured while adding the book to list!", Toast.LENGTH_SHORT).show();
            }
            checkList(incomingBook);
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

    private void checkList(Book incomingBook) {
        util = new Util();
        ArrayList<Book> already = util.getAlreadyReadBooks();
        ArrayList<Book> want = util.getWantToReadBooks();
        ArrayList<Book> curr = util.getCurrentlyReadingBooks();

        if (already.contains(incomingBook)) {
            Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_bookmark_check_2, null);
            btnAlreadyRead.setCompoundDrawablesWithIntrinsicBounds(null, null, d, null);
            btnAlreadyRead.setTextColor(Color.parseColor("#1D90A8"));
            btnAlreadyRead.setBackgroundColor(Color.parseColor("#CEE7EC"));
        } else {
            Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_bookmark_check, null);
            btnAlreadyRead.setCompoundDrawablesWithIntrinsicBounds(null, null, d, null);
            btnAlreadyRead.setTextColor(Color.parseColor("#666666"));
            btnAlreadyRead.setBackground(defaultBtnStyle);
        }

        if (want.contains(incomingBook)) {
            Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_bookmark_heart_2, null);
            btnWantToRead.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            btnWantToRead.setTextColor(Color.parseColor("#B03C4C"));
            btnWantToRead.setBackgroundColor(Color.parseColor("#FDDCE1"));
        } else {
            Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_bookmark_heart, null);
            btnWantToRead.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            btnWantToRead.setTextColor(Color.parseColor("#666666"));
            btnWantToRead.setBackground(defaultBtnStyle);
        }

        if (curr.contains(incomingBook)) {
            Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_plus_2, null);
            btnCurReading.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            btnCurReading.setTextColor(Color.parseColor("#51A488"));
            btnCurReading.setBackgroundColor(Color.parseColor("#CBFFED"));
        } else {
            Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_plus, null);
            btnCurReading.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
            btnCurReading.setTextColor(Color.parseColor("#666666"));
            btnCurReading.setBackground(defaultBtnStyle);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}