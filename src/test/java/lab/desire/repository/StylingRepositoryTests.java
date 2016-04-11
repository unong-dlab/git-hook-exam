package lab.desire.repository;

import com.google.common.collect.Lists;
import lab.desire.DemoApplication;
import lab.desire.domain.CoordiType;
import lab.desire.domain.Styling;
import lab.desire.service.CMSService;
import lab.desire.utils.DemoRandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unong on 4/11/16.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class StylingRepositoryTests {
    @Autowired
    StylingRepository stylingRepository;

    @Autowired
    CMSService cmsService;

    @Test
    public void 맨땅에스타일매핑() throws Exception {
        Styling sp1 = DemoRandomGenerator.mapStyling("style1", "prod1", CoordiType.INNER);
        log.info("{}", sp1);
        Styling sp2 = DemoRandomGenerator.mapStyling("style1", "prod2", CoordiType.OUTER);
        log.info("{}", sp2);
        ArrayList<Styling> ss = Lists.newArrayList(sp1, sp2);
        List<Styling> r = cmsService.styling(ss);
        Assert.assertNotNull(r);
        log.info("{}", r);
    }
}
