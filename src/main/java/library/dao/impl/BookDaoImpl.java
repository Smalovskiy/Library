package library.dao.impl;

import library.dao.BookDao;
import library.hiber.SessionUtil;
import library.model.Book;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl extends SessionUtil implements BookDao{

    @Override
    public Book add(Book book) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(book);
        closeTransactionSesstion();
        return book;
    }

    @Override
    public List<Book> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Book> books = session.createQuery("FROM Book").list();
        closeTransactionSesstion();
        return books;
    }

    @Override
    public Book findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Book book = session.get(Book.class, id);
        closeTransactionSesstion();
        return book;
    }

    @Override
    public Book update(Book data) throws SQLException {
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
        Book book = session.get(Book.class, id);
        session.remove(book);
        closeTransactionSesstion();
    }

    @Override
    public Book findBookByTitle(String title) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Book> books = session.createQuery("FROM Book").list();
        Book searchingBook = new Book();
        for (Book book: books) {
            if (book.getTitle().equals(title)) {
                return searchingBook = book;
            }
        }
        closeTransactionSesstion();
        return searchingBook;
    }
}
