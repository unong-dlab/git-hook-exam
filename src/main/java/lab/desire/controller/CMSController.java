package lab.desire.controller;

import lab.desire.domain.Product;
import lab.desire.domain.Style;
import lab.desire.service.CMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by unong on 4/6/16.
 */
@RestController
@RequestMapping("/cms")
public class CMSController {
    @Autowired
    CMSService cmsService;

    @RequestMapping("/style/find")
    @ResponseBody
    public Style find(@RequestParam String sid) {
        return cmsService.findStyle(sid);
    }

    @RequestMapping("/style/upload")
    @ResponseBody
    public Style upload(@RequestParam String sid,
                      @RequestParam String desc,
                      @RequestParam String url) {
        cmsService.upload(sid, desc, url);
        return cmsService.findStyle(sid);
    }

    @RequestMapping("/style/update")
    @ResponseBody
    public Style update(@RequestParam String sid,
                        @RequestParam String desc,
                        @RequestParam String url) {
        cmsService.update(sid, desc, url);
        return cmsService.findStyle(sid);
    }

    @RequestMapping("/prod/upload")
    @ResponseBody
    public Product prodUpload(@RequestParam String pid,
                              @RequestParam String name,
                              @RequestParam String url) {
        cmsService.addProduct(pid, name, url);
        return cmsService.findProduct(pid);
    }

    @RequestMapping("/prod/find")
    @ResponseBody
    public Product prodFind(@RequestParam String pid) {
        return cmsService.findProduct(pid);
    }

    @RequestMapping("/prod/find2")
    @ResponseBody
    public Product prodFind2(@RequestParam String pid) {
        return cmsService.findProduct(pid);
    }

    @RequestMapping("/style/{sid}/상품추가")
    @ResponseBody
    public Style 상품추가(@PathVariable String sid, @RequestParam String pid) {
        Style style = cmsService.findStyle(sid);
        return style;
    }
}
