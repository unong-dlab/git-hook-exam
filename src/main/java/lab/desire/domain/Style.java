package lab.desire.domain;

import lab.desire.domain.listener.Creatable;
import lab.desire.domain.listener.CreatedAtListener;
import lab.desire.domain.listener.Updatable;
import lab.desire.domain.listener.UpdatedAtListener;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by unong on 4/6/16.
 */
@Getter
@ToString
@EntityListeners({
        CreatedAtListener.class, UpdatedAtListener.class
})
@Table(name="style")
@Entity
public class Style implements Serializable, Creatable, Updatable {
    @Id
    private String sid;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String representImageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regdttm;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updttm;


    public Style(String sid) {
        this.sid = sid;
    }

    public Style(String sid, String description, String representImageUrl) {
        this.sid = sid;
        this.description = description;
        this.representImageUrl = representImageUrl;
    }

    public Style() {
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Styling> styleProducts;

    @Override
    public void setCreatedAt(Date date) {
        regdttm = date;
    }

    @Override
    public void setUpdatedAt(Date date) {
        updttm = date;
    }
}
