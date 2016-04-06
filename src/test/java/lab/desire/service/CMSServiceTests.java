package lab.desire.service;

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
 * Created by unong on 4/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class CMSServiceTests {
    @Autowired
    CMSService cmsService;

    @Test
    public void contextLoad() throws Exception {
        Assert.assertNotNull(cmsService);
    }

    @Test
    public void saveOne() throws Exception {
        Style e = new Style("babo1", "한글도..", "http://localhost/babo.jpg");
        cmsService.upload(e.getSid(), e.getDesc(), e.getRepresentImageUrl());
        Style s = cmsService.find("babo1");
        Assert.assertEquals(e.getRepresentImageUrl(), s.getRepresentImageUrl());
    }

    @Test
    public void update() throws Exception {
        Style e = new Style("babo1", "한글도..", "http://localhost/babo.jpg");
        cmsService.upload(e.getSid(), e.getDesc(), e.getRepresentImageUrl());
        String expect = "http://remotehost/babo.jpg";
        cmsService.update(e.getSid(), e.getDesc(), expect);
        Style s = cmsService.find("babo1");
        Assert.assertEquals(expect, s.getRepresentImageUrl());
    }
}
