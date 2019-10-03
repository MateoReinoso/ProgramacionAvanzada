package ec.edu.espe.experiment.springlab.dto;

import java.util.Date;

public class Book {

    private Integer id;
    private String name;
    private Date publicationDate;
    private Integer idAuthor;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String name, Date publicationDate, Integer idAuthor) {
        this.id = id;
        this.name = name;
        this.publicationDate = publicationDate;
        this.idAuthor = idAuthor;
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

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }
}