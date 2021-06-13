package library.dao.impl;

import library.dao.Dao;
import library.hiber.SessionUtil;
import library.model.IssuedBook;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class IssuedBookDaoImpl extends SessionUtil implements Dao<IssuedBook> {

    @Override
    public IssuedBook add(IssuedBook issuedBook) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(issuedBook);
        closeTransactionSesstion();
        return issuedBook;
    }

    @Override
    public List<IssuedBook> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<IssuedBook> issuedBooks = session.createQuery("FROM IssuedBook").list();
        closeTransactionSesstion();
        return issuedBooks;
    }

    @Override
    public IssuedBook findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        IssuedBook issuedBook = session.get(IssuedBook.class, id);
        closeTransactionSesstion();
        return issuedBook;
    }

    @Override
    public IssuedBook update(IssuedBook data) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.saveOrUpdate(data);
        closeTransactionSesstion();
        return data;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        IssuedBook issuedBook = session.get(IssuedBook.class, id);
        session.remove(issuedBook);
        closeTransactionSesstion();
    }
}
