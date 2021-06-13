package library.service;

import library.dao.Dao;
import library.dao.impl.LibrarianDaoImpl;
import library.model.Librarian;

import java.sql.SQLException;
import java.util.List;

public class LibrarianService {

    private Dao<Librarian> librarianDao = new LibrarianDaoImpl();

    public List<Librarian> printAllLibrarians() throws SQLException {
        return librarianDao.findAll();
    }

    public void saveLibrarian(Librarian librarian) throws SQLException {
        librarianDao.add(librarian);
    }

    public void deleteLibrarian(Long id) throws SQLException {
        librarianDao.deleteById(id);
    }

    public void updateLibrarian(Librarian newLibrarian) throws SQLException {
        librarianDao.update(newLibrarian);
    }

    public Librarian getLibrarianById(Long id) throws SQLException {
        return librarianDao.findById(id);
    }
}
