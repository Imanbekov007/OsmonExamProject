import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.BookServiceImpl;
import service.UserServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book(100L, "AK KEME", Genre.ROMANCE, new BigDecimal(250), "Chyngyz Aytmatov", Language.KYRGYZ, LocalDate.ofYearDay(1976, 5)),
                new Book(101L, "Ono", Genre.FANTASY, new BigDecimal(700), "Stiven King", Language.ENGLISH, LocalDate.ofYearDay(2020, 5)),
                new Book(102L, "Rich dad,poor dad", Genre.HISTORICAL, new BigDecimal(200), "Robert Kiyosoaki", Language.ENGLISH, LocalDate.ofYearDay(2009, 5)),
                new Book(103L, "Miracle of morning", Genre.HISTORICAL, new BigDecimal(300), "Sam", Language.ENGLISH, LocalDate.ofYearDay(2014, 5)),
                new Book(104L, "Sherlok Holmes", Genre.DETECTIVE, new BigDecimal(1000), "Conor", Language.ENGLISH, LocalDate.ofYearDay(1993, 5)),
                new Book(105L, "War and Peace", Genre.HISTORICAL, new BigDecimal(2000), "Lev Tolstoy", Language.RUSSIAN, LocalDate.ofYearDay(1976, 5)),
                new Book(106L, "Romeo and Julietta", Genre.ROMANCE, new BigDecimal(5000), "William Shekspir", Language.ENGLISH, LocalDate.ofYearDay(1900, 5))
        ));
        List<Book> nullbook = new ArrayList<>();
        List<User> users = new ArrayList<>(Arrays.asList(
                new User(11L, "Osmon", "IManbekov", "osmonimanbekov.ksl@gmail.com", "+996500000000", Gender.MALE, new BigDecimal(2000), nullbook),
                new User(12L, "Erbola", "Zholborsova", "osmonimanbekov.ksl@gmail.com", "+996500000000", Gender.FEMALE, new BigDecimal(2000), nullbook),
                new User(13L, "Adil", "IManbekov", "osmonimanbekov.ksl@gmail.com", "+996500000000", Gender.MALE, new BigDecimal(2000), nullbook),
                new User(14L, "Aigul", "Nazirova", "osmonimanbekov.ksl@gmail.com", "+996500000000", Gender.FEMALE, new BigDecimal(2000), nullbook),
                new User(15L, "Azima", "Talantova", "osmonimanbekov.ksl@gmail.com", "+996500000000", Gender.FEMALE, new BigDecimal(2000), nullbook)
        ));
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.createUser(users));
        System.out.println(userService.findAllUsers());
        System.out.println(userService.findUserById(12L));
        System.out.println(userService.removeUserByName("Azima"));
        userService.groupUsersByGender();
        System.out.println(userService.buyBooks("Erbol", books));
        BookServiceImpl bookService = new BookServiceImpl();
        System.out.println(bookService.createBooks(books));
        System.out.println(bookService.getAllBooks());
        System.out.println(bookService.getBooksByGenre());
        System.out.println(bookService.maxPriceBook());
        System.out.println(bookService.sortBooksByPriceInDescendingOrder());


        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.


    }
}