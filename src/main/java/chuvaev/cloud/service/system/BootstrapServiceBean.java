package chuvaev.cloud.service.system;

import chuvaev.cloud.api.annotation.Loggable;
import chuvaev.cloud.api.local.FolderLocalService;
import chuvaev.cloud.api.system.ApplicationService;
import chuvaev.cloud.api.system.BootstrapService;
import chuvaev.cloud.api.system.EndpointService;
import chuvaev.cloud.api.system.SettingService;
import chuvaev.cloud.event.keyboard.KeyboardInitEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class BootstrapServiceBean implements BootstrapService {

    @Inject
    private ApplicationService applicationService;

    @Inject
    private SettingService settingService;

    @Inject
    private EndpointService endpointService;

    @Inject
    private FolderLocalService folderLocalService;

    @Inject
    private Event<KeyboardInitEvent> keyboardInputInitEvent;

    @Loggable
    public void init(){
        settingService.init();
        endpointService.init();
        folderLocalService.init();
        applicationService.init();
        keyboardInputInitEvent.fire(new KeyboardInitEvent());
    }
}
