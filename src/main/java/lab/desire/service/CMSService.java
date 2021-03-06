package lab.desire.service;

import com.google.common.collect.Lists;
import lab.desire.domain.CoordiType;
import lab.desire.domain.Product;
import lab.desire.domain.Style;
import lab.desire.domain.Styling;
import lab.desire.domain.dto.StyleProductDto;
import lab.desire.repository.ManualEntityManagerRepository;
import lab.desire.repository.ProductRepository;
import lab.desire.repository.StyleRepository;
import lab.desire.repository.StylingRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * product, style 모두 관리하는 service 라 해두자
 *
 * Created by unong on 4/6/16.
 */
@Service
@Transactional
public class CMSService {
    @Getter
    @Autowired
    StyleRepository styleRepository;
    @Getter
    @Autowired
    ProductRepository productRepository;
    @Getter
    @Autowired
    StylingRepository stylingRepository;
    @Getter
    @Autowired
    ManualEntityManagerRepository manualEntityManagerRepository;

    public void upload(String sid, String description, String url) {
        styleRepository.save(new Style(sid, description, url));
    }
    public void update(String sid, String description, String url) {
        styleRepository.save(new Style(sid, description, url));
    }

    public Style findStyle(String sid) {
        return styleRepository.findOne(sid);
    }

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

    /**
     * 여긴 고민이 많이 된다.
     * 매핑을 해주기 위해서 원본객체들을 다시 persistence 영역에 올려줘야 한단 말인가
     *
     * @param sid
     * @param pidList
     * @param coordis
     * @return
     */
    public List<Styling> styling(String sid, List<String> pidList, List<CoordiType> coordis) {
        Style s1 = styleRepository.findOne(sid);
        Product p1 = productRepository.findOne(pidList.get(0));
        Styling sp1 = new Styling(s1, p1, coordis.get(0));
        List<Styling> r = stylingRepository.save(Lists.newArrayList(sp1));
        return r;
    }

    public List<Styling> styling(List<Styling> ss) {
        return stylingRepository.save(ss);
    }

    public List<StyleProductDto> getStyleWithProds(String sid) {
        return manualEntityManagerRepository.findStylingNamedNativeQuery(sid);
    }
}
