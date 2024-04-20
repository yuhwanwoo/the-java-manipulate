package com.thejava.demospringdi;

public class BookServiceProxy implements BookService {

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("aaaaa");
        bookService.rent(book);
        System.out.println("bbbb");
    }

    @Override
    public void returnBook(Book book) {
        bookService.returnBook(book);
    }
}
