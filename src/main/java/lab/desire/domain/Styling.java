package lab.desire.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by unong on 4/11/16.
 */
@ToString
@Getter
@Entity
@IdClass(StylingId.class)
@Table(name = "style_products")
public class Styling {
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

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date regdttm;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updttm;


    public Styling() {
    }

    public Styling(Style style, Product product, CoordiType category) {
        this.style = style;
        this.product = product;
        this.category = category;
//        this.regdttm = new Date();
//        this.updttm = new Date();
    }

}
