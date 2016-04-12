package lab.desire;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 이거 아직 안쓰긴 하는데.. 가끔 유용할때 있어서 추가해둠
 *
 * Created by unong on 4/12/16.
 */
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext context;
    public static ApplicationContext getContext() {
        return context;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
