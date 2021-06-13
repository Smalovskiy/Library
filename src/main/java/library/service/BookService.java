package library.service;

import library.dao.BookDao;
import library.dao.impl.BookDaoImpl;
import library.model.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookDao bookDao = new BookDaoImpl();

    public List<Book> printAllBooks() throws SQLException {
        return bookDao.findAll();
    }

    public void saveBook(Book book) throws SQLException {
        bookDao.add(book);
    }

    public void deleteBook(Long id) throws SQLException {
        bookDao.deleteById(id);
    }

    public void updateBook(Book newBook) throws SQLException {
        bookDao.update(newBook);
    }

    public Book getBookById(Long id) throws SQLException {
        return bookDao.findById(id);
    }

    public Book getBookByTitle(String title) throws SQLException {
        return bookDao.findBookByTitle(title);
    }
}
