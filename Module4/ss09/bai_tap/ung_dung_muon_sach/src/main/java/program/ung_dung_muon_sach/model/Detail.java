package program.ung_dung_muon_sach.model;


import javax.persistence.*;

@Entity
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="book_id",nullable = false,referencedColumnName = "book_id")
    private Book book;

    public Detail() {
    }

    public Detail(Integer id, Boolean status, Book book) {
        this.id = id;
        this.status = status;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
