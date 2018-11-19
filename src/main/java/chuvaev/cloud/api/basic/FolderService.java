package chuvaev.cloud.api.basic;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface FolderService {

    void printListFolderNameRoot();

    @NotNull
    List<String> getListFolderNameRoot();

    void createFolder(String folderName);

    void removeFolder(String folderName);

    void clearRoot();

}
