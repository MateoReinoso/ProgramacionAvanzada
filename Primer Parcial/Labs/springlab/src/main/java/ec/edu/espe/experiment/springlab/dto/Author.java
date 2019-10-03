package ec.edu.espe.experiment.springlab.dto;

import java.util.Date;
import java.util.List;

public class Author {

    private Integer id;
    private String name;
    private String dni;
    private Date birthDate;
    private List<Book> books;

    public Author() {
    }

    public Author(Integer id) {
        this.id = id;
    }

    public Author(Integer id, String name, String dni, Date birthDate, List<Book> books) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.birthDate = birthDate;
        this.books = books;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
