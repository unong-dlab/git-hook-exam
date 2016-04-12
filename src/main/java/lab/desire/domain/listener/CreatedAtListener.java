package lab.desire.domain.listener;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PrePersist;
import java.util.Date;

/**
 * Created by unong on 4/12/16.
 */
@Slf4j
public class CreatedAtListener {
    @PrePersist
    public void setCreatedAt(final Creatable entity) {
        log.info("UNONG prePersist (create)");
        entity.setCreatedAt(new Date());
    }
}
