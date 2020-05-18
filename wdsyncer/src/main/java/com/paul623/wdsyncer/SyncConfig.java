package com.paul623.wdsyncer;

import android.content.Context;
import android.content.SharedPreferences;

import com.paul623.wdsyncer.utils.Base64Util;

/**
 * 配置类
 * 2020.5.18
 * TODO
 * 目前get和set不符合规范
 * */
public class SyncConfig {
    private String userAccount;
    private final String USERACCOUNT="account";

    private String passWord;
    private final String PASSWORD="password";

    private String serverUrl;
    private final String SERVERURL="server_url";

    private Context context;
    private SharedPreferences sp;


    private static final String dataBaseName="wdsyncer_config_dataBase";
    public SyncConfig(Context context){
        this.context=context;
        sp=context.getSharedPreferences(dataBaseName,Context.MODE_PRIVATE);
    }

    public String getUserAccount() {
        userAccount=sp.getString(USERACCOUNT,"");
        userAccount= Base64Util.decodeToString(this.userAccount);
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(USERACCOUNT,Base64Util.encodeToString(userAccount));
        editor.apply();
    }

    public String getPassWord() {
        passWord=sp.getString(PASSWORD,"");
        passWord=Base64Util.decodeToString(passWord);
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(PASSWORD,Base64Util.encodeToString(passWord));
        editor.apply();
    }

    public String getServerUrl() {
        serverUrl=sp.getString(SERVERURL,"https://dav.jianguoyun.com/dav/");
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(SERVERURL,serverUrl);
        editor.apply();
    }

    public boolean canLogin(){
        return !getUserAccount().equals("") && !getPassWord().equals("") && !getServerUrl().equals("");
    }
}
