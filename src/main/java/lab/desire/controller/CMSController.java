package lab.desire.controller;

import lab.desire.domain.Style;
import lab.desire.service.CMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by unong on 4/6/16.
 */
@RestController("/cms")
public class CMSController {
    @Autowired
    CMSService cmsService;

    @RequestMapping("style/find")
    @ResponseBody
    public Style find(@RequestParam String sid) {
        return cmsService.find(sid);
    }

    @RequestMapping("style/upload")
    @ResponseBody
    public Style upload(@RequestParam String sid,
                      @RequestParam String desc,
                      @RequestParam String url) {
        cmsService.upload(sid, desc, url);
        return cmsService.find(sid);
    }

    @RequestMapping("style/update")
    @ResponseBody
    public Style update(@RequestParam String sid,
                        @RequestParam String desc,
                        @RequestParam String url) {
        cmsService.update(sid, desc, url);
        return cmsService.find(sid);
    }
}
