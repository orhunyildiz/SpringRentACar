package kodlamaio.rentacar.dataAccess.abstracts;

import kodlamaio.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name); // spring jpa keywords
}
