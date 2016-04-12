package lab.desire.repository;

import lab.desire.domain.Styling;
import lab.desire.domain.StylingId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by unong on 4/11/16.
 */
public interface StylingRepository extends JpaRepository<Styling, StylingId> {

}
