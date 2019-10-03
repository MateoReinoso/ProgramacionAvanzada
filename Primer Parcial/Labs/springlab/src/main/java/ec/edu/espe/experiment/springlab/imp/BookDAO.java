package ec.edu.espe.experiment.springlab.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ec.edu.espe.experiment.springlab.dao.IBookDAO;
import ec.edu.espe.experiment.springlab.dto.Book;
import ec.edu.espe.experiment.springlab.model.DBAuthor;
import ec.edu.espe.experiment.springlab.model.DBBook;
import ec.edu.espe.experiment.springlab.repo.IAuthorRepo;
import ec.edu.espe.experiment.springlab.repo.IBookRepo;

@Repository
public class BookDAO implements IBookDAO {
    @Autowired
    private IBookRepo repo;
    @Autowired
    private IAuthorRepo repoAuthor;

    @Override
    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        try {
            List<DBBook> list_dbBook = repo.findAll();
            if (list_dbBook != null) {
                for (DBBook dbBook : list_dbBook) {
                    list.add(toBook(dbBook));
                }
            }
        } catch (Exception e) {
            list = new ArrayList<>();
        }
        return list;
    }

    public Book toBook(DBBook dbBook) {
        return new Book(dbBook.getId(), dbBook.getName(), dbBook.getPublicationDate(), dbBook.getAuthor().getId());
    }

    @Override
    public Book get(Integer id) {
        Book book = null;
        try {
            Optional<DBBook> dbBook = repo.findById(id);
            if (dbBook != null) {
                book = toBook(dbBook.get());
            }
        } catch (Exception e) {
            book = null;
        }
        return book;
    }

 @Override
 public Book post(Book book){
 Book response;
 try{
 Optional<DBAuthor> dbAuthor = repoAuthor.findById(book.getIdAuthor());
 DBBook dbBook = new DBBook(book.getName(),
 book.getPublicationDate(),
 dbAuthor.get());
 repo.save(dbBook);
 repo.flush();
 response = toBook(dbBook);
 }
 catch(Exception e){
 response = null;
 }
 return response;
 }

}
