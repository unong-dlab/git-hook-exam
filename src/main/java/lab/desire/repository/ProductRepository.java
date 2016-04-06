package lab.desire.repository;

import lab.desire.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by unong on 4/6/16.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
