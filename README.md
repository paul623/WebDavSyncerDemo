# WDSyncer

基于WebDav的安卓封装库

[![](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![](https://jitpack.io/v/paul623/WebDavSyncerDemo.svg)](https://bintray.com/beta/#/paul623/maven/wdsyncer?tab=overview)  [![](https://img.shields.io/badge/dynamic/json?labelColor=11ab60&color=282c34&label=%E9%85%B7%E5%AE%89%20Coolapk&suffix=%20fans&query=%24.data.totalSubs&url=https%3A%2F%2Fapi.spencerwoo.com%2Fsubstats%2F%3Fsource%3Dcoolapk%26queryKey%3D1258736&logo=data:image/svg+xml;base64,PHN2ZyBjbGFzcz0iaWNvbiIgdmlld0JveD0iMCAwIDEwMjQgMTAyNCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiPjxkZWZzPjxzdHlsZS8+PC9kZWZzPjxwYXRoIGQ9Ik0xMjcuODkzIDQyNi42NjdjMjkuOTItNjYuOTg3IDk0LjUwNy0xMTYuNjk0IDE2Ni40LTEzMC4zNDcgNTUuNzg3LTkuNiAxMTIuOTYgNS4wNjcgMTYxLjkyIDMxLjk0N0M0OTcuNzYgMzQ5LjQ0IDUzNC40IDM3OC44OCA1NjcuOTQ3IDQxMS4wNGMtMTYuMTYgMTguNC0zOS4wOTQgMjguODUzLTU3LjQ5NCA0NC43NDctNDYuMTMzLTM4Ljg4LTk2LjY0LTc3LjcwNy0xNTcuOTczLTg3LjA5NC03OC45MzMtMTMuMTczLTE1OC41NiA0OS4yMjctMTcwLjUwNyAxMjcuMTQ3LTguNjkzIDQ1LjkyIDEwLjEzNCA5NC42NjcgNDUuMTc0IDEyNC45MDcgMzkuNjggMzQuOTg2IDk3LjIyNiA0NC41ODYgMTQ3LjYyNiAzMS4yNTMgNTcuNi0xMy45MiAxMDEuOTc0LTU3LjA2NyAxMzYuODU0LTEwMi43NzMgNTQuMDgtNzIuMTA3IDk5LjItMTUwLjQgMTQ3Ljg0LTIyNi4xMzQgMTMuOTItMTkuMTQ2IDQ3LjQxMy0xNy4yMjYgNTguNzIgMy44NCA2My42MjYgMTA5LjAxNCAxMjYuMDggMjE4LjcyIDE4OS42IDMyNy43ODcgNy41NzMgMTUuMDkzIDQuNDI2IDM1Ljc4Ny05LjYgNDYuMTMzLTEzLjA2NyAxMC42MTQtMzMuMzM0IDEwLjI0LTQ2LjEzNC0uNjkzYTk3MDY2LjU1OCA5NzA2Ni41NTggMCAwMS0yMjYuMTg2LTE2Mi43MmMxOC44OC0xNS4wNCAzOC40LTI5LjMzMyA1Ny45NzMtNDMuNDY3IDIzLjczMyAxMi45MDcgNDMuNzg3IDMzLjE3NCA2OS42IDQxLjY1NC0yMC4zNzMtMzkuNTc0LTQzLjYyNy03Ny43MDctNjYuMzQ3LTExNS45NDctNDIuNjY2IDU5LjE0Ny03Ny4wNjYgMTI0LjIxMy0xMjMuMTQ2IDE4MS4wNjdDNTE2IDY2My40NjcgNDQ4LjggNzE2Ljk2IDM2OC42NCA3MjguNDhjLTM4Ljg4IDMuNDEzLTc5LjMwNyA0LjIxMy0xMTYuMzczLTkuOTczLTUzLjQ5NC0xOS4xNDctMTAwLjMyLTU4LjcyLTEyNC41ODctMTEwLjU2LTI4LjIxMy01Ni4xMDctMjYuNzczLTEyNS4wMTQuMjEzLTE4MS4yOHoiIGZpbGw9IiNmZmYiLz48L3N2Zz4=&longCache=true)](http://www.coolapk.com/u/1258736) [![](https://img.shields.io/badge/dynamic/json?color=282c34&labelColor=0084ff&label=%E7%9F%A5%E4%B9%8E%E5%85%B3%E6%B3%A8&query=%24.data.totalSubs&url=https%3A%2F%2Fapi.spencerwoo.com%2Fsubstats%2F%3Fsource%3Dzhihu%26queryKey%3Dzhu-bao-luo-29&longCache=true)](https://www.zhihu.com/people/zhu-bao-luo-29)



原博客：[WebDav for Android](https://www.cnblogs.com/robotpaul/p/12005045.html)

## 碎碎念

为啥要写这个库呢？

* 尝试自己写一个库调用，学习一下这个流程，为以后做准备
* WebDav同步过程很繁琐
* 自己做的项目都会涉及到同步功能，不想重复写代码

## 更新日志

```java
2022.01.14 0.0.5
本版本没有新增内容
迁移库至JitPack
2021.02.01 0.0.4
新增支持自定义加密解密方式
2020.08.24 0.0.3
修复了查看路径文件服务器地址不生效的问题
调整了Demo中的部分逻辑
2020.08.22 0.0.2
修复上传文件失败的问题
新增clean，可以清除本地账户了

下次更新：增加大文件上传支持、上传进度回调
```

## 安全性

* 对于账户和密码做了加密处理
* 支持自定义加密方式

## 食用方法
在项目中引用即可
最新版本：[![](https://jitpack.io/v/paul623/WebDavSyncerDemo.svg)](https://bintray.com/beta/#/paul623/maven/wdsyncer?tab=overview) 
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
```groovy
dependencies {
	        implementation 'com.github.paul623:WebDavSyncerDemo:0.0.5'
	}
```

## 使用教程

### Api接口

```java
  /**
     * 上传文件
     * @param fileName 文件名 包含后缀名
     * @param fileLoc 文件目录 如：homeLoc/
     * @param listener 返回信息为 文件路径，上传成功
     * */
    public void uploadFile(String fileName, String fileLoc, File f, OnSyncResultListener listener);
    /**
     * 上传String类型数据
     * 你可以直接把文件格式设置为txt即可
     * @param fileName 文件名 包含后缀名
     * @param fileLoc 文件目录 如：homeLoc/
     * @param listener 返回信息为 文件路径，上传成功
     * */
    public void uploadString(String fileName, String fileLoc, String content, OnSyncResultListener listener);

   /**
    * 下载文件
    * @param listener 返回的是文件保存路径
    * 默认保存路径在：应用的私有路径下
    * */
    public void downloadFile(String fileName, String fileLoc, OnSyncResultListener listener);
    /**
     * 下载文件
     * @param listener 返回的是内容
     * */
    public void downloadString(String fileName, String fileLoc, OnSyncResultListener listener);

    /**
     * 列出所有文件信息
     * @param listFileListener 具体参看DavData
     * */
    public void listAllFile(String dir, OnListFileListener listFileListener);

    /**
     * 删除文件
     * @param fileDir 文件目录
     * */
    public void deleteFile(String fileDir, OnSyncResultListener listener);
```

### 使用示例

#### 1.配置账户信息

使用SyncConfig来配置你的账户、密码以及服务器地址。

默认服务器地址为坚果云，即您可以不设置。

```java
SyncConfig config=new SyncConfig(context);
config.setPassWord("你的密码");
config.setUserAccount("你的账户");
```

#### 2.配置加密解密方式

💡0.0.4新增

如需要自己实现加密解密方式，请实现Encryption接口

```java
public interface Encryption {
    //加密
    public String encode(String key);
    //解密
    public String decode(String password);
}
```

如

```java
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
```

在配置的时候使用

```java
 SyncConfig config=new SyncConfig(this,new DefaultEncryption());
```

同时，对应的SyncManager

```java
 SyncManager syncManager=new SyncManager(this,new DefaultEncryption());
```

<u>**特别注意：SyncConfig传入Encryption后对应的SyncManager必须传入相同的Encryption，否则会抛出异常或者登录失败。**</u>

#### 3.调用并实现回调

由于所有操作都必须在线程中执行，故你需要自行处理线程操作，这里以上传为例。

```java
 SyncManager syncManager=new SyncManager(MainActivity.this);
        syncManager.uploadString("test.txt", "WDSyncer", "如你所见，WebDavSyncer已经配置成功！", new OnSyncResultListener() {
            @Override
            public void onSuccess(String result) {
                //成功
                Looper.prepare();
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

            @Override
            public void onError(String errorMsg) {
                //失败
                Looper.prepare();
                Toast.makeText(MainActivity.this,errorMsg,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        });
```

或者你可以使用Handler来控制。

更多例子请查看项目代码。

文件上传下载我没有测试，如果有问题请在issue中提交告诉我

## 常见的出错类型

1.请求失败:出错了，javax.net.ssl.SSLHandshakeException: Chain validation failed

*这个一般是手机的时间不对，导致握手失败。请检查模拟器或者手机的时间设置是否和当地地区时间相同*

2.请求失败:出错了，com.thegrizzlylabs.sardineandroid.impl.SardineException: Error contacting https://dav.jianguoyun.com/dav/WDSyncer (401 )

*这个是账户用户名或者密码不正确*

3.Unable to start activity ComponentInfo{com.paul.webdavsyncerdemo/com.paul.webdavsyncerdemo.MainActivity}: java.lang.RuntimeException: 请配置Encryotion

*这是由于你在SyncConfig中设置了Encryption而在SyncManager中没有设置*

4.java.lang.RuntimeException: Unable to start activity ComponentInfo{com.paul.webdavsyncerdemo/com.paul.webdavsyncerdemo.MainActivity}: java.lang.RuntimeException: Config中未配置Encryotion

*这是由于你在SyncConfig没有配置Encryption而在SyncManager中设置了*

## 兼容性

在安卓P及以上版本中，请在清单中配置：

```xml
 android:usesCleartextTraffic="true"
```

## 第三方依赖

本项目基于[sardine](https://github.com/thegrizzlylabs/sardine-android)

## 关于

@Paul623

Powered By 巴塞罗那的余晖

博客：https://www.cnblogs.com/robotpaul/

## License

```
Copyright 2020 Paul623. https://github.com/paul623

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
 limitations under the License.
```

