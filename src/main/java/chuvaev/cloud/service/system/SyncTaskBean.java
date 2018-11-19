package chuvaev.cloud.service.system;

import chuvaev.cloud.api.system.SyncService;
import chuvaev.cloud.api.system.SyncTask;

import javax.inject.Inject;
import java.util.TimerTask;

public class SyncTaskBean extends TimerTask implements SyncTask {

    @Inject
    private SyncService syncService;

    @Override
    public boolean cancel(){return super.cancel();}

    @Override
    public TimerTask get(){return this;}

    @Override
    public void run(){
        syncService.sync();
    }
}
