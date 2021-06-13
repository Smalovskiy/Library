package library.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    private BookView bookView;
    private UserView userView;
    private LibrarianView librarianView;
    private IssuedBookView issuedBookView;

    private static MainView mainView;

    private MainView() {
        bookView = new BookView();
        userView = new UserView();
        librarianView = new LibrarianView();
        issuedBookView = new IssuedBookView();
    }

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

    private static void actions() {
        System.out.println("\nChoose action:\n"
                + "1-Books.\n"
                + "2-Users.\n"
                + "3-Librarians.\n"
                + "4-IssuedBooks.\n"
                + "\t0-Exit.");
    }

    public void runMainView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);

        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        runBook();
                        break;
                    case 2:
                        runUser();
                        break;
                    case 3:
                        runLibrarian();
                        break;
                    case 4:
                        runIssuedBook();
                        break;
                    case 0:
                        numOfPoint = 0;
                        break;
                    default:
                        System.out.println("There is no such command.");
                        System.out.println("Choose action:");
                        numOfPoint = mainScan.nextInt();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        mainScan.close();
    }

    public void runBook() throws SQLException {
        bookView.runBookView();
    }

    public void runUser() throws SQLException {
        userView.runUserView();
    }

    public void runLibrarian() throws SQLException {
        librarianView.runLibrarianView();
    }

    public void runIssuedBook() throws SQLException {
        issuedBookView.runIssuedBookView();
    }
}
