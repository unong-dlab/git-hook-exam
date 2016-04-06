package lab.desire.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by unong on 4/6/16.
 */
@Table(name="style")
@Entity
public class Style implements Serializable {
    @Id
    private String sid;
    @Column(nullable = false)
    private String desc;
    @Column(nullable = false)
    private String representImageUrl;
    public Style(String sid, String desc, String representImageUrl) {
        this.sid = sid;
        this.desc = desc;
        this.representImageUrl = representImageUrl;
    }

    public Style() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRepresentImageUrl() {
        return representImageUrl;
    }

    public void setRepresentImageUrl(String representImageUrl) {
        this.representImageUrl = representImageUrl;
    }
}
