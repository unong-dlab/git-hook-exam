package lab.desire.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by unong on 4/6/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
@Entity
public class Product implements Serializable {
    @Id
    private String pid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String representImageUrl;
}
