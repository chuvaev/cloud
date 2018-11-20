package chuvaev.cloud.service.system;

import chuvaev.cloud.api.annotation.Loggable;
import chuvaev.cloud.api.system.SettingService;
import chuvaev.cloud.api.system.SyncTask;
import chuvaev.cloud.api.system.TimerService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import java.util.Timer;

import static java.lang.Integer.parseInt;

@ApplicationScoped
public class TimerServiceBean implements TimerService {

    @Inject
    private SettingService settingService;

    private final Timer timer = new Timer();

    private SyncTask task = null;

    public boolean getActive(){return task != null;}

    public void setActive(boolean active){ if (active) start(); else stop();}

    @Loggable
    @Override
    public synchronized boolean start(){
        if (task != null) return false;
        final Integer timeout = parseInt(settingService.getSyncTimeout());
        task = CDI.current().select(SyncTask.class).get();
        timer.schedule(task.get(), 0, timeout);
        return true;
    }

    @Loggable
    @Override
    public synchronized boolean stop(){
        if (task == null) return false;
        task.cancel();
        task = null;
        return true;
    }

    @Override
    public void restart(){
        stop();
        start();
    }
}
