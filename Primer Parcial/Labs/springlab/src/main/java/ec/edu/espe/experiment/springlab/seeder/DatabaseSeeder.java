package ec.edu.espe.experiment.springlab.seeder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ec.edu.espe.experiment.springlab.model.DBAuthor;
import ec.edu.espe.experiment.springlab.model.DBBook;
import ec.edu.espe.experiment.springlab.repo.IAuthorRepo;
import ec.edu.espe.experiment.springlab.repo.IBookRepo;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private IAuthorRepo repoAuthor;
    @Autowired
    private IBookRepo repoBook;

    @Autowired
    public DatabaseSeeder(IAuthorRepo authorRepo) {
        this.repoAuthor = authorRepo;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<DBAuthor> authors = new ArrayList<>();
        authors.add(new DBAuthor("Autor 1", "1718152269", new Date()));
        repoAuthor.saveAll(authors);
        List<DBBook> books = new ArrayList<>();
        books.add(new DBBook("Libro 1", new Date(), authors.get(0)));
        repoBook.saveAll(books);
    }
}