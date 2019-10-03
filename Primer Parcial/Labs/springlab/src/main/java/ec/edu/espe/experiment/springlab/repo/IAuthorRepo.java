package ec.edu.espe.experiment.springlab.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.espe.experiment.springlab.model.DBAuthor;
public interface IAuthorRepo extends JpaRepository<DBAuthor, Integer>{

}