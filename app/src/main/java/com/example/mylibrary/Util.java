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

    public ArrayList<Book> getAllBooks() {
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
        return wantToReadBooks.add(book);
    }

    public boolean addAlreadyReadBook(Book book) {
        return alreadyReadBooks.add(book);
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
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Demon: Fact versus Fiction";
        author = "Gene Hanna";
        pages = 279;
        imageUrl = "https://loremflickr.com/390/420?random=1";
        description = "Cras magna sem, consectetur sit amet diam eu, vehicula congue risus.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Can Monkeys Dance : An exploration of Memes";
        author = "Hanifa Rush";
        pages = 279;
        imageUrl = "https://loremflickr.com/390/420?random=100";
        description = "Fusce ut quam id dui aliquet aliquet.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Monkeys Are the New Black";
        author = "Arissa Callaghan";
        pages = 279;
        imageUrl = "https://loremflickr.com/390/420?random=250";
        description = "Cras consectetur, nulla sit amet rhoncus euismod, augue lectus rutrum magna, eget luctus elit urna et metus.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Before Blue Cats";
        author = "Amir Boyce";
        pages = 279;
        imageUrl = "https://loremflickr.com/390/420?random=600";
        description = "Integer lorem tortor, rutrum sit amet placerat sed, tristique sed nisl.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Born to Chase Monkeys";
        author = "Lucinda Caldwell";
        pages = 279;
        imageUrl = "https://loremflickr.com/390/420?random=100";
        description = "Quisque eget tortor mi.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Truly, Madly, Intelligent";
        author = "Theia Branch";
        pages = 279;
        imageUrl = "https://loremflickr.com/390/420?ramdom=2000";
        description = "Donec vitae pulvinar ante.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

    }

}
