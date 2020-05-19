# WDSyncer

基于WebDav的安卓封装库

[![](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![](https://img.shields.io/badge/version-0.0.1-yellow.svg)](https://bintray.com/beta/#/paul623/maven/wdsyncer?tab=overview)

原博客：[WebDav for Android](https://www.cnblogs.com/robotpaul/p/12005045.html)

## 碎碎念

为啥要写这个库呢？

* 尝试自己写一个库调用，学习一下这个流程，为以后做准备
* WebDav同步过程很繁琐
* 自己做的项目都会涉及到同步功能，不想重复写代码

## 安全性

* 对于账户和密码做了加密处理

## 食用方法

在项目中引用即可

```groovy
implementation 'com.paul623.wdsyncer:wdsyncer:0.0.1'
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

#### 2.调用并实现回调

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
