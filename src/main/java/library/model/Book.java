package library.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false)
    private String title;

    @Basic
    @Column(name = "author", nullable = false)
    private String author;

    @Basic
    @Column(name = "publication_year", nullable = false)
    private String publicationYear;

    @Basic
    @Column(name = "genre", nullable = false)
    private String genre;

    @Basic
    @Column(name = "price", nullable = false)
    private String price;

    @OneToMany(targetEntity=IssuedBook.class, mappedBy = "book", cascade = {CascadeType.ALL})
    private Collection<IssuedBook> issuedBooks;

    @Override
    public String toString() {
        return "Book_" + id +
                ", title=" + title +
                ", author=" + author +
                ", publicationYear=" + publicationYear +
                ", genre=" + genre +
                ", price=" + price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Collection<IssuedBook> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(Collection<IssuedBook> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }
}
