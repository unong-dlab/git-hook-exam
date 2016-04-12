package lab.desire.domain.listener;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by unong on 4/12/16.
 */
@Slf4j
public class UpdatedAtListener {
    @PrePersist
    @PreUpdate
    public void setUpdatedAt(final Updatable entity) {
        log.info("UNONG prePersist, preUpdate");
        entity.setUpdatedAt(new Date());
    }
}
