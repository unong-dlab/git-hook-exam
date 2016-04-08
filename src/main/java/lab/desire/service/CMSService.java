package lab.desire.service;

import lab.desire.domain.Product;
import lab.desire.domain.Style;
import lab.desire.repository.ProductRepository;
import lab.desire.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * product, style 모두 관리하는 service 라 해두자
 *
 * Created by unong on 4/6/16.
 */
@Service
public class CMSService {
    @Autowired
    StyleRepository styleRepository;

    public void upload(String sid, String description, String url) {
        styleRepository.save(new Style(sid, description, url));
    }

    public void update(String sid, String description, String url) {
        styleRepository.save(new Style(sid, description, url));
    }

    public Style findStyle(String sid) {
        return styleRepository.findOne(sid);
    }

    @Autowired
    ProductRepository productRepository;
    public void addProduct(String pid, String name, String url) {
        productRepository.save(new Product(pid, name, url));
    }
    public Product findProduct(String pid) {
        return productRepository.findOne(pid);
    }
    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

    /**
     * 이건 style, product relation table 이 만들어지면...
     * @param sid
     * @return
     */
    public Style findAll(String sid) {
        return styleRepository.findOne(sid);
    }
}
