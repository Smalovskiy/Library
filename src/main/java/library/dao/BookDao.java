package library.dao;

import library.model.Book;

import java.sql.SQLException;

public interface BookDao extends Dao<Book>{
    Book findBookByTitle(String title) throws SQLException;
}
