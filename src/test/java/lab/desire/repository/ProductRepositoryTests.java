package lab.desire.repository;

import lab.desire.DemoApplication;
import lab.desire.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by unong on 4/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@Slf4j
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void add() throws Exception {
        Product p = productRepository.save(new Product("상품ID1", "상품모델이 어쩌고", "http://cdn.어쩌고.kr"));
        Assert.notNull(p);
    }

    @Test
    public void logging() throws Exception {
        Product p = productRepository.findOne("상품ID1");
        Assert.notNull(p);
        log.info("{}", p);
    }

    @Test
    public void nativeQuery() throws Exception {
        Product p = productRepository.findByName("상품모델이 어쩌고");
        Assert.notNull(p);
        log.info("{}", p);
    }

    @Test
    public void queryByUrl() throws Exception {
        Product p = productRepository.findByUrl("http://cdn.어쩌고.kr");
        Assert.notNull(p);
        log.info("{}", p);
    }

    @Test
    public void queryByJoin() throws Exception {
        List<Product> p = productRepository.findByJoin("상품모델이 어쩌고");
        Assert.notNull(p);
        log.info("{}", p);
    }
}
