package lab.desire.domain.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * @ColumnResult(name="representImageUrl",type = String.class),
 *
 * Created by unong on 4/12/16.
 */
@Getter
@ToString
public class StyleProductDto {
    private String sid;
    private String description;
//    private String representImageUrl;
//    private Date regdttm;
//    private Date updttm;
    private String pid;
    private String name;

    public StyleProductDto(String sid, String description, String pid, String name) {
        this.sid = sid;
        this.description = description;
        this.pid = pid;
        this.name = name;
    }
}
