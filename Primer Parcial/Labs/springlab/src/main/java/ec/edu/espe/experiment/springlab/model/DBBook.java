package ec.edu.espe.experiment.springlab.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Importaciones
@Entity
public class DBBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 50)
    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "publicationDate")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @JoinColumn(name = "idAuthor")
    @ManyToOne
    private DBAuthor author;

    public DBBook() {

    }

    public DBBook(Integer id) {
        this.id = id;
    }

    public DBBook(String name, Date publicationDate, DBAuthor author) {
        this.name = name;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public DBAuthor getAuthor() {
        return author;
    }

    public void setAuthor(DBAuthor author) {
        this.author = author;
    }

}
