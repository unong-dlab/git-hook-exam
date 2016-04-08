package lab.desire.repository;

import com.google.common.collect.Lists;
import lab.desire.DemoApplication;
import lab.desire.domain.Product;
import lab.desire.domain.Style;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

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

    @Test
    public void mapProds() throws Exception {
        Style s = styleRepository.findOne("style1");
        s.setProducts(Lists.newArrayList(new Product("상품ID1")));
        Style s2 = styleRepository.save(s);
        List<Product> ps = s2.getProducts();
        Assert.assertNotNull(ps);
    }
}
