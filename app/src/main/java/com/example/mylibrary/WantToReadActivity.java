package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class WantToReadActivity extends AppCompatActivity {

    private static final String TAG = "WantToReadList";

    private RecyclerView recView;
    private BooksRecViewAdapter adapter;
    private Util utility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_read_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BooksRecViewAdapter(this);
        utility = new Util();

        recView = findViewById(R.id.recycleView);
        recView.setAdapter(adapter);
        recView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter.setBooks(utility.getWantToReadBooks());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}