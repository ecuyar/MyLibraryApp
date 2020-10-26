package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooks extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        recyclerView = findViewById(R.id.bookRecycleView);

        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

//        books.add(new Book("1Q84", "Writer 1", 1256, "https://i.dr.com.tr/cache/600x600-0/originals/0000000662235-1.jpg","Desc1"));
//        books.add(new Book("ADER RRFWF", "Writer 2", 126, "https://www.birlikte.com.tr/saftirik-gregin-gunlugu-1-kitap-kitaplar-epsilon-yayinlari-jeff-kinney-2052-17-B.jpg","Desc2"));
//        books.add(new Book("5879 KITAP", "Writer 3", 122, "https://yazarokur-kitap-20.s3.eu-central-1.amazonaws.com/yuzuklerin-efendisi-yuzuk-kardesligi.jpg","Desc3"));
//        books.add(new Book("KITABI OLMAYAN ADAM", "Kitabı Olan Adam", 89, "https://images.kitapsepeti.com/Content/global/images/products/3/336098/kotu-cocuk.jpg","Desc4"));

        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getAllBooks();
        adapter.setBooks(books);
    }
}