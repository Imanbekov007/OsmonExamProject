package service;

import enums.Genre;
import model.Book;

import java.util.List;

public interface BookService {

    List <Book> createBooks(List<Book>books);

    List<Book> getAllBooks();

    List<Book> getBooksByGenre();

    Book removeBookById(Long id);

    List<Book> sortBooksByPriceInDescendingOrder();

    List<Book> filterBooksByPublishedYear();// Konsolgo akyrky 10 jilda chygarylgan kitepter chyksyn

    List<Book> getBookByInitialLetter();

    Book maxPriceBook();

}
