package ec.edu.espe.experiment.springlab.dao;

import java.util.List;
import ec.edu.espe.experiment.springlab.dto.Book;
import ec.edu.espe.experiment.springlab.model.DBBook;

public interface IBookDAO {
    public List<Book> getAll();

    public Book get(Integer id);

    public Book post(Book book);

    public Book toBook(DBBook dbBook);
}