package com.paul.webdavsyncerdemo;

import android.app.Application;

import com.paul623.wdsyncer.SyncConfig;

public class MyApplication extends Application {
    private static MyApplication instance;
    @Override
    public void onCreate() {
        instance=this;

        configDavSync();
        super.onCreate();
    }
    public static MyApplication getInstance(){
        return instance;
    }
    /**
     * 配置sync
     * */
    public void configDavSync(){
        SyncConfig config=new SyncConfig(this);
        //TODO
        //config.setPassWord("");
        //config.setUserAccount("");
        //config.setServerUrl("");
    }
}
