package lab.desire.service;

import lab.desire.domain.Style;
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

    public Style find(String sid) {
        return styleRepository.findOne(sid);
    }
}
