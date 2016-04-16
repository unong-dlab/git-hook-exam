package lab.desire.repository;

import lab.desire.domain.Style;
import lab.desire.domain.Styling;
import lab.desire.domain.dto.StyleProductDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
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

    @Transactional
    public List<StyleProductDto> findStylingNamedNativeQuery(String sid) {
        return em.createNamedQuery("style_products.findSQL", StyleProductDto.class)
                .setParameter("sid", sid)
                .getResultList();
    }

    @Transactional
    public List<HashMap> findStylingMapNamedNativeQuery(String sid) {
        return em.createNamedQuery("style_products.complexSQL", HashMap.class)
                .setParameter("sid", sid)
                .getResultList();
    }
}
