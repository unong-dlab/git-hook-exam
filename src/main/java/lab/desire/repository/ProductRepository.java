package lab.desire.repository;

import lab.desire.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by unong on 4/6/16.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select u from product u where u.name = ?1")
    Product findByName(String name);

    @Query(value = "select u from product u where u.representImageUrl = :representImageUrl")
    Product findByUrl(@Param("representImageUrl") String representImageUrl);

    //    @Query(value = "select u.* from product u where u.name = ?1", nativeQuery = true)
    @Query(value = "select u.* from product u, style_products m where u.pid=m.pid and u.name = ?1", nativeQuery = true)
    List<Product> findByJoin(String name);
}
