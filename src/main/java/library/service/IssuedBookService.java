package library.service;

import library.dao.Dao;
import library.dao.impl.IssuedBookDaoImpl;
import library.model.IssuedBook;

import java.sql.SQLException;
import java.util.List;

public class IssuedBookService {

    private Dao<IssuedBook> issuedBookDao = new IssuedBookDaoImpl();

    public List<IssuedBook> printAllIssuedBooks() throws SQLException {
        return issuedBookDao.findAll();
    }

    public void saveIssuedBook(IssuedBook issuedBook) throws SQLException {
        issuedBookDao.add(issuedBook);
    }

    public void deleteIssuedBook(Long id) throws SQLException {
        issuedBookDao.deleteById(id);
    }

    public void updateIssuedBook(IssuedBook newIssuedBook) throws SQLException {
        issuedBookDao.update(newIssuedBook);
    }

    public IssuedBook getIssuedBookById(Long id) throws SQLException {
        return issuedBookDao.findById(id);
    }
}
