package lab.desire.repository;

import lab.desire.domain.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by unong on 4/6/16.
 */
@Repository
public interface StyleRepository extends JpaRepository<Style, String>{
}
