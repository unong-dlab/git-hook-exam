package lab.desire.repository;

import lab.desire.DemoApplication;
import lab.desire.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

/**
 * Created by unong on 4/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void add() throws Exception {
        Product p = productRepository.save(new Product("상품ID1", "상품모델이 어쩌고", "http://cdn.어쩌고.kr"));
        Assert.notNull(p);
    }
}
