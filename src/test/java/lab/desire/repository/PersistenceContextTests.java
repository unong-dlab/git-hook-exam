package lab.desire.repository;

import lab.desire.DemoApplication;
import lab.desire.domain.Style;
import lab.desire.domain.Styling;
import lab.desire.domain.dto.StyleProductDto;
import lab.desire.utils.DemoRandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

/**
 * Created by unong on 4/12/16.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class PersistenceContextTests {
    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Autowired
    private ManualEntityManagerRepository emRepostory;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void 셋팅되나() throws Exception {
        Assert.assertNotNull(em);
    }

    @Test
    public void 수동em() throws Exception {
        Style s = DemoRandomGenerator.genStyle();
        emRepostory.newStyle(s);
        Style s2 = emRepostory.findOne(s.getSid());
        Assert.assertEquals(s2.getDescription(), s.getDescription());
    }

    @Test
    public void testNamedQueryJPQL() throws Exception {
        Style s = emRepostory.findStyleNamedQuery("babo2");
        Assert.assertEquals("아이고아이고", s.getDescription());
    }

    @Test
    public void testMapTableNamedQueryJPQL() throws Exception {
        List<Styling> list = emRepostory.findStylingNamedQuery("style1");
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testMapTableNamedNativeQueryJPQL() throws Exception {
        List<StyleProductDto> list = emRepostory.findStylingNamedNativeQuery("style1");
        for(StyleProductDto o: list) {
            log.info("UNONG:: {}, {}", o, o.getClass().getCanonicalName());
        }
//        log.info("UNONG {}", list);
    }

    /**
     * hashmap 으로만 결과를 뱉게할수만 있어도 bean 으로 자동매핑은 가능할텐데... 잘안됨
     * 차라리 array 로 받은걸 자동으로 생성자매핑해주는게 쉬울지도 모름, 일단은 포기
     * @throws Exception
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMapTableHashMapNamedNativeQueryJPQL() throws Exception {
        List<HashMap> list = emRepostory.findStylingMapNamedNativeQuery("style1");
        for(HashMap o: list) {
            log.info("UNONG:: {}, {}", o, o.getClass().getCanonicalName());
        }
    }
}
