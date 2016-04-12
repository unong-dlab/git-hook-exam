package lab.desire.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by unong on 4/12/16.
 */
@Setter
@Getter
public class StylingId implements Serializable {
    private String style;
    private String product;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
