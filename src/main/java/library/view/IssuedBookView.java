package library.view;

import library.model.Book;
import library.model.IssuedBook;
import library.model.Librarian;
import library.model.User;
import library.service.BookService;
import library.service.IssuedBookService;
import library.service.LibrarianService;
import library.service.UserService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IssuedBookView {

    private IssuedBookService issuedBookService = new IssuedBookService();
    private BookService bookService = new BookService();
    private UserService userService = new UserService();
    private LibrarianService librarianService = new LibrarianService();

    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose issuedBook action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "\t0-Exit.");
    }

    public void runIssuedBookView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addIssuedBook();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllIssuedBooks();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteIssuedBook();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateIssuedBook();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 5:
                        getByIdLibrarian();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
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

    public void addIssuedBook() throws SQLException {
        try {
            IssuedBook issuedBook = new IssuedBook();

            System.out.println("Enter issued book title: ");
            String issuedBookTitle = firstScan.nextLine();
            issuedBook.setTitle(issuedBookTitle);

            System.out.println("Enter date of issue:");
            String issuedBookDateOfIssue = firstScan.nextLine();
            issuedBook.setDateOfIssue(issuedBookDateOfIssue);

            System.out.println("Enter return date:");
            String issuedBookReturnDate = firstScan.nextLine();
            issuedBook.setReturnDate(issuedBookReturnDate);

            System.out.println("Enter numb of copies issued:");
            String issuedBookNumbOfCopiesIssued = firstScan.nextLine();
            issuedBook.setNumbOfCopiesIssued(issuedBookNumbOfCopiesIssued);

            Book testBook = bookService.getBookById(1L);
            if (testBook != null) {
                System.out.println("Enter book_id:");
                String issuedBookBookId = secondScan.nextLine();
                Book book = bookService.getBookById((long) Integer.parseInt(issuedBookBookId));
                issuedBook.setBook(book);
            } else issuedBook.setBook(null);

            User testUser = userService.getUserById(1L);
            if (testUser != null) {
                System.out.println("Enter user_id:");
                String issuedBookUserId = secondScan.nextLine();
                User user = userService.getUserById((long) Integer.parseInt(issuedBookUserId));
                issuedBook.setUser(user);
            } else issuedBook.setUser(null);

            Librarian testLibrarian = librarianService.getLibrarianById(1L);
            if (testLibrarian != null) {
                System.out.println("Enter librarian_id:");
                String issuedBookLibrarianId = secondScan.nextLine();
                Librarian librarian = librarianService.getLibrarianById((long) Integer.parseInt(issuedBookLibrarianId));
                issuedBook.setLibrarian(librarian);
            } else issuedBook.setLibrarian(null);

            issuedBookService.saveIssuedBook(issuedBook);
            System.out.println("Issued Book has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateIssuedBook() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(secondScan.next());

            IssuedBook newIssuedBook = issuedBookService.getIssuedBookById(id);

            System.out.println("Enter issued book title: ");
            String issuedBookTitle = firstScan.nextLine();
            newIssuedBook.setTitle(issuedBookTitle);

            System.out.println("Enter date of issue:");
            String issuedBookDateOfIssue = firstScan.nextLine();
            newIssuedBook.setDateOfIssue(issuedBookDateOfIssue);

            System.out.println("Enter return date:");
            String issuedBookReturnDate = firstScan.nextLine();
            newIssuedBook.setReturnDate(issuedBookReturnDate);

            System.out.println("Enter numb of copies issued:");
            String issuedBookNumbOfCopiesIssued = firstScan.nextLine();
            newIssuedBook.setNumbOfCopiesIssued(issuedBookNumbOfCopiesIssued);

            Book testBook = bookService.getBookById(1L);
            if (testBook != null) {
                System.out.println("Enter book_id:");
                String issuedBookBookId = secondScan.nextLine();
                Book book = bookService.getBookById((long) Integer.parseInt(issuedBookBookId));
                newIssuedBook.setBook(book);
            } else newIssuedBook.setBook(null);

            User testUser = userService.getUserById(1L);
            if (testUser != null) {
                System.out.println("Enter user_id:");
                String issuedBookUserId = secondScan.nextLine();
                User user = userService.getUserById((long) Integer.parseInt(issuedBookUserId));
                newIssuedBook.setUser(user);
            } else newIssuedBook.setUser(null);

            Librarian testLibrarian = librarianService.getLibrarianById(1L);
            if (testLibrarian != null) {
                System.out.println("Enter librarian_id:");
                String issuedBookLibrarianId = secondScan.nextLine();
                Librarian librarian = librarianService.getLibrarianById((long) Integer.parseInt(issuedBookLibrarianId));
                newIssuedBook.setLibrarian(librarian);
            } else newIssuedBook.setLibrarian(null);

            issuedBookService.updateIssuedBook(newIssuedBook);
            System.out.println("Issued Book has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteIssuedBook() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            issuedBookService.deleteIssuedBook(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Issued Book with id " + id + " has been deleted successfully");
    }

    public void printAllIssuedBooks() throws SQLException {
        List<IssuedBook> issuedBooks = issuedBookService.printAllIssuedBooks();
        System.out.println("List of all issued issued books:");
        issuedBooks.forEach(librarian1 -> System.out.println(librarian1.toString()));
    }

    public void getByIdLibrarian() throws SQLException {
        System.out.println("Enter id in order to get issued book:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (issuedBookService.getIssuedBookById(id) != null) {
                System.out.println(issuedBookService.getIssuedBookById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdLibrarian();
        }
    }
}
