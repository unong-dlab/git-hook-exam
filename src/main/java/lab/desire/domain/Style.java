package lab.desire.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by unong on 4/6/16.
 */
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private List<Styling> styleProducts;
}
