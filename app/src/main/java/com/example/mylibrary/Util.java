package com.example.mylibrary;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    private static int id = 0;

    public Util() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }
        if (alreadyReadBooks == null) {
            alreadyReadBooks = new ArrayList<>();
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBook(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean addAlreadyReadBook(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean removeCurrentlyReadingBook(Book book) {
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeAlreadyReadBook(Book book) {
        return alreadyReadBooks.remove(book);
    }

    private static void initAllBooks() {
        String name = "";
        String author = "";
        int pages = 0;
        String imageUrl = "";
        String description = "";

        id++;
        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71-s4xaRwdL.jpg";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Pride and Prejudice1";
        author = "Jane Austen1";
        pages = 279;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71-s4xaRwdL.jpg";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Pride and Prejudice2";
        author = "Jane Austen2";
        pages = 279;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71-s4xaRwdL.jpg";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Pride and Prejudice3";
        author = "Jane Austen3";
        pages = 279;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71-s4xaRwdL.jpg";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Pride and Prejudice4";
        author = "Jane Austen4";
        pages = 279;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71-s4xaRwdL.jpg";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Pride and Prejudice5";
        author = "Jane Austen5";
        pages = 279;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71-s4xaRwdL.jpg";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Pride and Prejudice6";
        author = "Jane Austen6";
        pages = 279;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71-s4xaRwdL.jpg";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

    }

}
