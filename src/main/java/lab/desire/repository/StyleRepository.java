package lab.desire.repository;

import lab.desire.domain.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by unong on 4/6/16.
 */
@Transactional(readOnly = true)
@Repository
public interface StyleRepository extends JpaRepository<Style, String>{
}
