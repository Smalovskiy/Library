package library.model;

import javax.persistence.*;

@Entity
@Table(name = "issued_book")
public class IssuedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false)
    private String title;

    @Basic
    @Column(name = "date_of_issue", nullable = false)
    private String dateOfIssue;

    @Basic
    @Column(name = "return_date", nullable = true)
    private String returnDate;

    @Basic
    @Column(name = "numb_of_copies_issued", nullable = false)
    private String numbOfCopiesIssued;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_librarian", referencedColumnName = "id")
    private Librarian librarian;

    @Override
    public String toString() {
        return "IssuedBook_" + id +
                ", title='" + title +
                ", dateOfIssue='" + dateOfIssue +
                ", returnDate='" + returnDate +
                ", numbOfCopiesIssued='" + numbOfCopiesIssued +
                ", book=" + book +
                ", user=" + user +
                ", librarian=" + librarian;
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

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getNumbOfCopiesIssued() {
        return numbOfCopiesIssued;
    }

    public void setNumbOfCopiesIssued(String numbOfCopiesIssued) {
        this.numbOfCopiesIssued = numbOfCopiesIssued;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
}
