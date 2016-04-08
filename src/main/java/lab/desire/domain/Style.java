package lab.desire.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by unong on 4/6/16.
 */
@Setter
@Getter
@ToString
@Table(name="style")
@Entity
public class Style implements Serializable {
    @Id
    private String sid;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String representImageUrl;

    public Style(String sid, String description, String representImageUrl) {
        this.sid = sid;
        this.description = description;
        this.representImageUrl = representImageUrl;
    }

    public Style() {
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "style_products",
            joinColumns = @JoinColumn(name = "sid", referencedColumnName = "sid"),
            inverseJoinColumns = @JoinColumn(name = "pid", referencedColumnName = "pid"))
    private List<Product> products;
}
