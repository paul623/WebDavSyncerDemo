package com.paul.webdavsyncerdemo;

import android.app.Application;

import com.paul623.wdsyncer.SyncConfig;
import com.paul623.wdsyncer.utils.DefaultEncryption;

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
        //自定义加密解密方式
        SyncConfig config=new SyncConfig(this,new DefaultEncryption());
        //SyncConfig config=new SyncConfig(this);//原默认是Base64加密解密


        //TODO
        //config.setPassWord("");
        //config.setUserAccount("");
        //config.setServerUrl("");
    }
}
