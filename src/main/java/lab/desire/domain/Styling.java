package lab.desire.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by unong on 4/11/16.
 */
@Getter
@Entity
@Table(name = "style_products")
public class Styling {
    @Id @GeneratedValue
    @Column(name = "styling_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="sid")
    private Style style;

    @ManyToOne
    @JoinColumn(name="pid")
    private Product product;

    @Enumerated(EnumType.STRING)
    private CoordiType category;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regdttm;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updttm;

    public Styling(Style style, Product product, CoordiType category) {
        this.style = style;
        this.product = product;
        this.category = category;
    }
}
