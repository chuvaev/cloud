package chuvaev.cloud.service.local;

import chuvaev.cloud.api.annotation.Loggable;
import chuvaev.cloud.api.local.FolderLocalService;
import chuvaev.cloud.api.system.SettingService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class FolderLocalServiceBean implements FolderLocalService {

    @Inject
    private SettingService settingService;

    @Loggable
    @Override
    public void init(){
        final String folder = settingService.getSyncFolder();
        final File file = new File(folder);
        file.mkdirs();
    }

    @NotNull
    @Override
    public List<String> getListFolderNameRoot(){
        final File root = getRoot();
        final String[] directories = root.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) { return new File(current, name).isDirectory(); }
        });
        return Arrays.asList(directories);
    }

    @Override
    public void printListFolderNameRoot(){
        for (String name: getListFolderNameRoot()) System.out.println(name);
    }

    @Override
    public void createFolder(@Nullable final String folderName){
        if (folderName == null || folderName.isEmpty()) return;
        final String folder = settingService.getSyncFolder();
        final File file = new File(folder + folderName);
        file.mkdirs();
    }

    @Override
    public void removeFolder(@Nullable final String folderName){
        if (folderName == null || folderName.isEmpty()) return;
        final File file = new File(getRoot(), folderName);
        file.delete();
    }

    @Override
    public void clearRoot(){
        final File root = new File(settingService.getSyncFolder());
        final List<String> directories = getListFolderNameRoot();
        for (final String name: directories){
            final File file = new File(root, name);
            file.delete();
        }
    }

    @NotNull
    private File getRoot(){ return new File(settingService.getSyncFolder()); }

}
