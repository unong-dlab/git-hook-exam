package lab.desire.repository;

import lab.desire.domain.Style;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by unong on 4/12/16.
 */
@Repository
public class ManualEntityManagerRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Style newStyle(Style s) {
        em.persist(s);
        return s;
    }

    @Transactional
    public Style findOne(String sid) {
        return em.find(Style.class, sid);
    }
}
