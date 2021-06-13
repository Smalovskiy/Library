package library.view;

import library.model.Librarian;
import library.service.LibrarianService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibrarianView {

    private LibrarianService librarianService = new LibrarianService();
    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose librarian action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "\t0-Exit.");
    }

    public void runLibrarianView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addLibrarian();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllLibrarians();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteLibrarian();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateLibrarian();

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

    public void addLibrarian() throws SQLException {
        try {
            Librarian librarian = new Librarian();

            System.out.println("Enter librarian name: ");
            String clientName = firstScan.nextLine();
            librarian.setName(clientName);

            System.out.println("Enter phonenumber:");
            String librarianPhonenumber = secondScan.nextLine();
            librarian.setPhoneNumber(librarianPhonenumber);

            librarianService.saveLibrarian(librarian);
            System.out.println("Librarian has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateLibrarian() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(secondScan.next());

            Librarian newLibrarian = librarianService.getLibrarianById(id);

            System.out.println("Enter librarian name: ");
            String clientName = firstScan.nextLine();
            newLibrarian.setName(clientName);

            System.out.println("Enter phonenumber:");
            String librarianPhonenumber = secondScan.nextLine();
            newLibrarian.setPhoneNumber(librarianPhonenumber);

            librarianService.updateLibrarian(newLibrarian);
            System.out.println("Librarian has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteLibrarian() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            librarianService.deleteLibrarian(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Librarian with id " + id + " has been deleted successfully");
    }

    public void printAllLibrarians() throws SQLException {
        List<Librarian> librarians = librarianService.printAllLibrarians();
        System.out.println("List of all librarians:");
        librarians.forEach(librarian1 -> System.out.println(librarian1.toString()));
    }

    public void getByIdLibrarian() throws SQLException {
        System.out.println("Enter id in order to get librarian:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (librarianService.getLibrarianById(id) != null) {
                System.out.println(librarianService.getLibrarianById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdLibrarian();
        }
    }
}
