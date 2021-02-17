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

    public ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
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

    public boolean removeWantToReadBook(Book book) {
        return wantToReadBooks.remove(book);
    }

    private static void initAllBooks() {
        String name;
        String author;
        int pages;
        String imageUrl;
        String description;

        id++;
        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71-s4xaRwdL.jpg";
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quis lorem facilisis, aliquet urna ultricies, finibus ipsum. " +
                "Cras imperdiet tortor velit, at fermentum felis varius ac. " +
                "Ut commodo, ipsum eu convallis sagittis, lacus nisi consequat ipsum, non condimentum diam diam facilisis odio.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Demon: Fact versus Fiction";
        author = "Gene Hanna";
        pages = 120;
        imageUrl = "https://loremflickr.com/390/420?random=1";
        description = "Duis posuere a lectus vitae pretium. In maximus pharetra dignissim. " +
                "Quisque ex nulla, maximus in ipsum ut, fringilla facilisis mauris. Quisque ac sagittis lacus. " +
                "Fusce ultricies ligula arcu, sit amet scelerisque nulla tempus sit amet. " +
                "Sed malesuada vulputate mi vel vehicula. Phasellus pulvinar orci felis, a dictum dolor consequat id. " +
                "Sed et molestie nunc, a laoreet neque. " +
                "Duis posuere a lectus vitae pretium. In maximus pharetra dignissim. " +
                "Quisque ex nulla, maximus in ipsum ut, fringilla facilisis mauris. Quisque ac sagittis lacus. " +
                "Fusce ultricies ligula arcu, sit amet scelerisque nulla tempus sit amet. " +
                "Sed malesuada vulputate mi vel vehicula. Phasellus pulvinar orci felis, a dictum dolor consequat id. " +
                "Sed et molestie nunc, a laoreet neque. " +
                "Duis posuere a lectus vitae pretium. In maximus pharetra dignissim. " +
                "Quisque ex nulla, maximus in ipsum ut, fringilla facilisis mauris. Quisque ac sagittis lacus. " +
                "Fusce ultricies ligula arcu, sit amet scelerisque nulla tempus sit amet. " +
                "Sed malesuada vulputate mi vel vehicula. Phasellus pulvinar orci felis, a dictum dolor consequat id. " +
                "Sed et molestie nunc, a laoreet neque.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Can Monkeys Dance: An exploration of Memes";
        author = "Hanifa Rush";
        pages = 136;
        imageUrl = "https://loremflickr.com/390/420?random=100";
        description = "Pellentesque ac consectetur lacus. Fusce sodales ultrices vestibulum. Nullam suscipit sagittis nibh commodo faucibus. " +
                "Nulla sit amet egestas nisl. In non leo sed sem volutpat placerat non sit amet justo. " +
                "Morbi vel ligula tempus, vestibulum turpis a, gravida libero. " +
                "Pellentesque rutrum convallis neque, vitae cursus est laoreet tincidunt. ";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Monkeys Are the New Black";
        author = "Arissa Callaghan";
        pages = 85;
        imageUrl = "https://loremflickr.com/390/420?random=250";
        description = "Cras consectetur, nulla sit amet rhoncus euismod, augue lectus rutrum magna, eget luctus elit urna et metus.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Before Blue Cats";
        author = "Amir Boyce";
        pages = 650;
        imageUrl = "https://loremflickr.com/390/420?random=600";
        description = "Etiam bibendum hendrerit urna ut sodales. Ut congue nulla arcu, eu viverra nunc facilisis eget. " +
                "Maecenas ut nulla porttitor, aliquam erat ac, feugiat turpis. Sed vel congue lacus. " +
                "Duis bibendum varius nibh, ac imperdiet nisl mattis in. " +
                "Duis tincidunt, justo vel molestie porttitor, diam augue ultricies sem, nec efficitur neque tortor ac tortor.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Born to Chase Monkeys";
        author = "Lucinda Caldwell";
        pages = 148;
        imageUrl = "https://loremflickr.com/390/420?random=100";
        description = "Donec maximus eros eu enim vestibulum, at fringilla elit tempus. Donec pulvinar ipsum lacinia felis ullamcorper fringilla. " +
                "Sed sed diam eget nunc malesuada cursus vitae at nisl. Integer eu tellus mauris. Duis at turpis vitae libero ultrices cursus. " +
                "Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        id++;
        name = "Truly, Madly, Intelligent";
        author = "Theia Branch";
        pages = 126;
        imageUrl = "https://loremflickr.com/390/420?ramdom=2000";
        description = "Sed a enim leo. Etiam sed volutpat turpis, id viverra neque. Donec id elementum ante, eu venenatis justo. " +
                "Nulla sed elit vehicula, tincidunt elit vitae, pellentesque felis. Sed ac congue ante, quis sodales leo. " +
                "Sed purus massa, maximus vel eros ac, lacinia consectetur nulla.";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

    }

}
