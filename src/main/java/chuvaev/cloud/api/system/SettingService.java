package chuvaev.cloud.api.system;

import org.jetbrains.annotations.NotNull;

public interface SettingService {

    void init();

    @NotNull
    Boolean getJcrActive();

    @NotNull
    String getJcrUrl();

    @NotNull
    String getJcrLogin();

    @NotNull
    String getJcrPassword();

    @NotNull
    String getSyncFolder();

    @NotNull
    Boolean getSyncActive();

    @NotNull
    String getSyncEndpoint();

    @NotNull
    String getSyncTimeout();
}
