package lab.desire.repository;

import lab.desire.DemoApplication;
import lab.desire.domain.Style;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by unong on 4/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class StyleRepositoryTests {
    @Autowired
    private StyleRepository styleRepository;

    @Test
    public void save() throws Exception {
        Style s = styleRepository.save(new Style("style1", "이런저런 스타일", "empty url"));
        Assert.assertNotNull(s);
    }

}
