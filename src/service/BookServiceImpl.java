package service;

import enums.Genre;
import model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{
    List<Book>databasebook=new ArrayList<>();
    @Override
    public List<Book> createBooks(List<Book> books) {
        databasebook.addAll(books);
        return databasebook;
    }

    @Override
    public List<Book> getAllBooks() {
        return databasebook;
    }

    @Override
    public List<Book> getBooksByGenre() {
        List<Book> genrelist=databasebook.stream().filter(x->x.getGenre().equals(Genre.DETECTIVE)).toList();
        return genrelist;
    }

    @Override
    public Book removeBookById(Long id) {
        return null;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {
        return null;
    }

    @Override
    public List<Book> filterBooksByPublishedYear() {
        return null;
    }

    @Override
    public List<Book> getBookByInitialLetter() {
        return null;
    }

    @Override
    public Book maxPriceBook() {
        Optional<Book> maxbook=databasebook.stream().max(Comparator.comparing(Book::getPrice));
        System.out.println(maxbook);
        return null;
    }

}
