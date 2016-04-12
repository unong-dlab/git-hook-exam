package lab.desire.domain;

import lab.desire.domain.listener.Creatable;
import lab.desire.domain.listener.CreatedAtListener;
import lab.desire.domain.listener.Updatable;
import lab.desire.domain.listener.UpdatedAtListener;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by unong on 4/11/16.
 */
@ToString
@Getter
@Entity
@EntityListeners({
    CreatedAtListener.class, UpdatedAtListener.class
})
@IdClass(StylingId.class)
@Table(name = "style_products")
public class Styling implements Creatable, Updatable {
    @Id
    @ManyToOne
    @JoinColumn(name="sid")
    private Style style;
    @Id
    @ManyToOne
    @JoinColumn(name="pid")
    private Product product;

    @Enumerated(EnumType.STRING)
    private CoordiType category;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regdttm;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updttm;

    public Styling() {
    }

    public Styling(Style style, Product product, CoordiType category) {
        this.style = style;
        this.product = product;
        this.category = category;
    }

    @Override
    public void setCreatedAt(Date date) {
        regdttm = date;
    }

    @Override
    public void setUpdatedAt(Date date) {
        updttm = date;
    }
}
