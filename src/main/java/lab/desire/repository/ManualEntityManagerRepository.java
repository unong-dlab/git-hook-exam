package lab.desire.repository;

import lab.desire.domain.Style;
import lab.desire.domain.Styling;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by unong on 4/12/16.
 */
@Repository
public class ManualEntityManagerRepository {
    @PersistenceContext(unitName = "primary")
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

    @Transactional
    public Style findStyleNamedQuery(String sid) {
        Style s = (Style) em.createNamedQuery("Style.findJPQL").setParameter("sid", sid).getSingleResult();
        return s;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Styling> findStylingNamedQuery(String sid) {
        return em.createNamedQuery("Styling.findJPQL").setParameter("sid", sid).getResultList();
    }
}
