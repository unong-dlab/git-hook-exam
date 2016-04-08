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
@Getter
@Setter
@ToString
@Table(name="product")
@Entity(name="product")
public class Product implements Serializable {
    @Id
    private String pid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String representImageUrl;

    public Product(String pid) {
        this.pid = pid;
    }

    public Product(String pid, String name, String representImageUrl) {
        this.pid = pid;
        this.name = name;
        this.representImageUrl = representImageUrl;
    }

    public Product() {
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "style_products",
            joinColumns = @JoinColumn(name = "pid", referencedColumnName = "pid"),
            inverseJoinColumns = @JoinColumn(name = "sid", referencedColumnName = "sid"))
    private List<Style> styles;
}
