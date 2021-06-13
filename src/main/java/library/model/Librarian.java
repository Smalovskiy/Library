package library.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "librarian")
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @OneToMany(targetEntity=IssuedBook.class, mappedBy = "librarian", cascade = {CascadeType.ALL})
    private Collection<IssuedBook> issuedBooks;

    @Override
    public String toString() {
        return "Librarian_" + id +
                ", name=" + name +
                ", phoneNumber=" + phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<IssuedBook> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(Collection<IssuedBook> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }
}
