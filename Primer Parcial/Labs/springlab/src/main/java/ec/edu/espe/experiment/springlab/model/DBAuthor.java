package ec.edu.espe.experiment.springlab.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DBAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 50)
    @NotNull
    @Column(name = "name")
    private String name;
    @Size(max = 10)
    @NotNull
    @Column(name = "dni")
    private String dni;
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(mappedBy = "author")
    private List<DBBook> books;


    public DBAuthor() {
    }

    public DBAuthor(Integer id) {
        this.id = id;
    }

    public DBAuthor(String name, String dni, Date birthDate) {
        this.name = name;
        this.dni = dni;
        this.birthDate = birthDate;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<DBBook> getBooks() {
        return books;
    }

    public void setBooks(List<DBBook> books) {
        this.books = books;
    }
}

