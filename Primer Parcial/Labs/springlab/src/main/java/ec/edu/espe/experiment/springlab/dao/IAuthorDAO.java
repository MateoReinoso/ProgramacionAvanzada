package ec.edu.espe.experiment.springlab.dao;

import java.util.List;
import ec.edu.espe.experiment.springlab.dto.Author;
import ec.edu.espe.experiment.springlab.model.DBAuthor;

public interface IAuthorDAO {
    public List<Author> getAll();

    public Author get(Integer id);

    public Author post(Author author);

    public Author toAuthor(DBAuthor dbAuthor);
}
