package ar.com.osde.dotcms.framework.resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ar.com.osde.dotcms.external.services.OsdeSecurityExternalService;

/**
 * @author ss94848846
 */
public class OsdeFrameworkServices {

    private static ApplicationContext context;

    private static void init(){
        context = new ClassPathXmlApplicationContext("spring/plugin-osde-dotcms-services-spring.xml");
    }

    /**
     * Aplicamos patrón Singleton para la injección de los Beans al contenedor de Spring
     */
    private static Object getBean(String beanName){
        if (context == null) init();
        return context.getBean(beanName);
    }

    public static OsdeSecurityExternalService OsdeSecurityExternalService(){
        return(OsdeSecurityExternalService) getBean("osde.security.external.service");
    }
}