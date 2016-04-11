package lab.desire.utils;

import lab.desire.domain.Style;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * Created by unong on 4/11/16.
 */
public class DemoTests {
    @Test
    public void 랜덤생성() throws Exception {
        Style s = DemoRandomGenerator.genStyle();
        System.out.println(s.toString());
        Assert.notNull(s);
    }
}
