package library.view;

import library.model.Book;
import library.service.BookService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookView {

    private BookService bookService = new BookService();
    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose book action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "6-Search by title.\n"
                + "\t0-Exit.");
    }

    public void runBookView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addBook();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllBooks();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteBook();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateBook();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 5:
                        getByIdBook();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 6:
                        getBookByTitle();

                        actions();
                        numOfPoint = mainScan.nextInt();
                    case 0:
                        numOfPoint = 0;
                        break;
                    default:
                        System.out.println("There is no such command.");
                        actions();
                        numOfPoint = mainScan.nextInt();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook() throws SQLException {
        try {
            Book book = new Book();

            System.out.println("Enter book title:");
            String carTitle = firstScan.nextLine();
            book.setTitle(carTitle);

            System.out.println("Enter author:");
            String bookAuthor = firstScan.nextLine();
            book.setAuthor(bookAuthor);

            System.out.println("Enter publication year:");
            String bookPublicationYear = firstScan.nextLine();
            book.setPublicationYear(bookPublicationYear);

            System.out.println("Enter genre:");
            String bookGenre = firstScan.nextLine();
            book.setGenre(bookGenre);

            System.out.println("Enter price:");
            String bookPrice = firstScan.nextLine();
            book.setPrice(bookPrice);

            bookService.saveBook(book);
            System.out.println("Book has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateBook() throws SQLException {
        try {
            System.out.println("Enter id in order to find element:");
            Long id = Long.parseLong(secondScan.next());

            Book newBook = bookService.getBookById(id);

            System.out.println("Enter book title: ");
            String carTitle = firstScan.nextLine();
            newBook.setTitle(carTitle);

            System.out.println("Enter author:");
            String bookAuthor = firstScan.nextLine();
            newBook.setAuthor(bookAuthor);

            System.out.println("Enter publication year:");
            String bookPublicationYear = firstScan.nextLine();
            newBook.setPublicationYear(bookPublicationYear);

            System.out.println("Enter genre:");
            String bookGenre = firstScan.nextLine();
            newBook.setGenre(bookGenre);

            System.out.println("Enter price:");
            String bookPrice = firstScan.nextLine();
            newBook.setPrice(bookPrice);


            bookService.updateBook(newBook);
            System.out.println("Book with id " + id + " has been updated successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteBook() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            bookService.deleteBook(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Book with id " + id + " has been deleted successfully");
    }

    public void printAllBooks() throws SQLException {
        List<Book> books = bookService.printAllBooks();
        System.out.println("List of all books:");
        books.forEach(book1 -> System.out.println(book1.toString()));
    }

    public void getByIdBook() throws SQLException {
        System.out.println("Enter id in order to get book:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (bookService.getBookById(id) != null) {
                System.out.println(bookService.getBookById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdBook();
        }
    }

    public void getBookByTitle() throws SQLException {
        System.out.println("Enter title in order to get book:");
        String title = secondScan.next();
        try {
            if (bookService.getBookByTitle(title) != null) {
                System.out.println(bookService.getBookByTitle(title).toString());
            } else {
                System.out.println("This title is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getBookByTitle();
        }
    }
}
