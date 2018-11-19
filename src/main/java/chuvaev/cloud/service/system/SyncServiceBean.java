package chuvaev.cloud.service.system;

import chuvaev.cloud.api.system.SyncService;
import chuvaev.cloud.api.system.TimerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SyncServiceBean implements SyncService {

    @Inject
    private TimerService timerService;

    @Inject
    private Event<SyncRemoteToLocalEvent> syncRemoteToLocalEvent;

    @Inject
    private Event<SyncLocalToRemoteEvent> syncLocalToRemoteEvent;

    @Override
    public void sync(){syncRemoteToLocalEvent.fire(new Syn)}

    @Override
    public boolean start(){return timerService.start();}

    @Override
    public boolean stop(){return timerService.stop();}

    @Override
    public boolean status(){return timerService.getActive();}

}
