package ec.edu.espe.experiment.springlab.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.espe.experiment.springlab.model.DBBook;
public interface IBookRepo extends JpaRepository<DBBook, Integer>{

}
