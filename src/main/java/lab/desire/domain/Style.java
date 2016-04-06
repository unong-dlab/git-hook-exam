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
@Table(name="style")
@Entity
public class Style implements Serializable {
    @Id
    private String sid;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String representImageUrl;
}
