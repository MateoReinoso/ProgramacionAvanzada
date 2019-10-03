package ec.edu.espe.experiment.springlab.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.edu.espe.experiment.springlab.dao.IAuthorDAO;
import ec.edu.espe.experiment.springlab.dao.IBookDAO;
import ec.edu.espe.experiment.springlab.dto.Author;
import ec.edu.espe.experiment.springlab.dto.Book;
import ec.edu.espe.experiment.springlab.model.DBAuthor;
import ec.edu.espe.experiment.springlab.model.DBBook;
import ec.edu.espe.experiment.springlab.repo.IAuthorRepo;

//imports
@Repository
public class AuthorDAO implements IAuthorDAO {
    @Autowired
    private IAuthorRepo repo;
    @Autowired
    private IBookDAO daoBook;

    @Override
    public List<Author> getAll() {
        List<Author> list = new ArrayList<>();
        try {
            List<DBAuthor> list_dbAuthor = repo.findAll();
            if (list_dbAuthor != null) {
                for (DBAuthor dbAuthor : list_dbAuthor) {

                    list.add(toAuthor(dbAuthor));
                }
            }
        } catch (Exception e) {
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public Author get(Integer id) {
        Author author = null;
        try {
            Optional<DBAuthor> dbAuthor = repo.findById(id);
            if (dbAuthor != null) {
                author = toAuthor(dbAuthor.get());
            }
        } catch (Exception e) {
            author = null;
        }
        return author;
    }

    @Override
    public Author post(Author author) {
        Author response = null;
        try {
            DBAuthor dbAuthor = new DBAuthor(author.getName(), author.getDni(), author.getBirthDate());
            repo.save(dbAuthor);
            repo.flush();
            response = toAuthor(dbAuthor);
        } catch (Exception e) {
            response = null;
        }
        return response;
    }

    @Override
    public Author toAuthor(DBAuthor dbAuthor) {
        List<Book> books = new ArrayList<>();
        if (dbAuthor.getBooks() != null) {
            for (DBBook dbBook : dbAuthor.getBooks()) {
                books.add(daoBook.toBook(dbBook));
            }
        }
        return new Author(dbAuthor.getId(), dbAuthor.getName(), dbAuthor.getDni(), dbAuthor.getBirthDate(), books);
    }
}