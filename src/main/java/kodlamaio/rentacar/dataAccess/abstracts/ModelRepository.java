package kodlamaio.rentacar.dataAccess.abstracts;

import kodlamaio.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
