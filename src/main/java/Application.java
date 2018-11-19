import chuvaev.cloud.service.system.BootstrapServiceBean;

import javax.enterprise.inject.se.SeContainerInitializer;

public class Application {

    public static void main(String[] args){
        SeContainerInitializer.newInstance().addPackages(Application.class).initialize()
                .select(BootstrapServiceBean.class).get().init();

    }
}
