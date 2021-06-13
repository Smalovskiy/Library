package library.dao.impl;

import library.dao.Dao;
import library.hiber.SessionUtil;
import library.model.Librarian;
import org.hibernate.Session;


import java.sql.SQLException;
import java.util.List;

public class LibrarianDaoImpl extends SessionUtil implements Dao<Librarian> {

    @Override
    public Librarian add(Librarian librarian) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(librarian);
        closeTransactionSesstion();
        return librarian;
    }

    @Override
    public List<Librarian> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Librarian> librarians = session.createQuery("FROM Librarian").list();
        closeTransactionSesstion();
        return librarians;
    }

    @Override
    public Librarian findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Librarian librarian = session.get(Librarian.class, id);
        closeTransactionSesstion();
        return librarian;
    }

    @Override
    public Librarian update(Librarian data) throws SQLException {
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
        Librarian librarian = session.get(Librarian.class, id);
        session.remove(librarian);
        closeTransactionSesstion();
    }
}
