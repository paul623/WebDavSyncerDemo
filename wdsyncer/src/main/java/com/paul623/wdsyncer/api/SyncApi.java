package com.paul623.wdsyncer.api;

import java.io.File;

public interface SyncApi {
    //上传文件
    public void uploadFile(String fileName, String fileLoc, File f, OnSyncResultListener listener);
    //上传String类型数据
    public void uploadString(String fileName, String fileLoc, String content, OnSyncResultListener listener);

    //下载文件
    public void downloadFile(String fileName, String fileLoc, OnSyncResultListener listener);
    //下载String类型数据
    public void downloadString(String fileName, String fileLoc, OnSyncResultListener listener);

    //列出路径下所有内容
    public void listAllFile(String dir, OnListFileListener listFileListener);

    //删除文件
    public void deleteFile(String fileDir, OnSyncResultListener listener);
}
