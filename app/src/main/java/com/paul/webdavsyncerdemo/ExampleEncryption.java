package com.paul.webdavsyncerdemo;

import com.paul623.wdsyncer.api.Encryption;

/**
 * Created by Android Studio.
 * User: paul623
 * Date: 2021/2/2
 * Time: 19:08
 * Email:zhubaoluo@outlook.com
 */
public class ExampleEncryption implements Encryption {
    @Override
    public String encode(String key) {
        return key+"&";
    }

    @Override
    public String decode(String password) {
        return password.split("&")[0];
    }
}
