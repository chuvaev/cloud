package chuvaev.cloud.service.system;

import chuvaev.cloud.api.annotation.Loggable;
import chuvaev.cloud.api.endpoint.*;
import chuvaev.cloud.api.system.EndpointService;
import chuvaev.cloud.api.system.SettingService;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EndpointServiceBean implements EndpointService {

    @Inject
    private SettingService settingService;

    @Inject
    private EndpointSettingAPI endpointSettingAPI;

    @Inject
    private EndpointSyncAPI endpointSyncAPI;

    @Inject
    private EndpointApplicationAPI endpointApplicationAPI;

    @Inject
    private EndpointCloudAPI endpointCloudAPI;

    @Inject
    private EndpointStorageAPI endpointStorageAPI;

    @Loggable
    @Override
    public void init(){
        registry(endpointStorageAPI, endpointCloudAPI, endpointSettingAPI, endpointSyncAPI, endpointApplicationAPI);
    }

    private void registry(EndpointAPI... services){
        @NotNull final List<String> result = new ArrayList<>();
        @NotNull final String baseURL = settingService.getSyncEndpoint();
        for(EndpointAPI service: services) result.add(registry(baseURL, service));
        info(result);
    }

    @NotNull
    private String registry(@NotNull final String baseURL, @NotNull final EndpointAPI api){
        @NotNull final String serviceURL = baseURL + api.getClass().getSimpleName();
        Endpoint.publish(serviceURL, api);
        return serviceURL;
    }

    private void info(@NotNull final List<String> urls){
        if (urls.isEmpty())return;
        for (String url: urls) System.out.println(url + "?wsdl");
    }

}
