package com.paul.webdavsyncerdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTools {

    /**
     * 初始化文件
     * */
    public static void initFile(Context context){
        try {
            //新建文件
            File saveFile = new File(getSDPath(context), "test.txt");

            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }
            final FileOutputStream outStream = new FileOutputStream(saveFile);
            Date date=new Date();
            SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = "如你所见，文件上传测试成功！时间："+s.format(date);
            try {
                outStream.write(str.getBytes());
                outStream.flush();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取私有目录，需要存储权限
     * @param context 上下文
     * @return 私有目录路径
     * */
    public static String getSDPath(Context context){
        final File[] dirs = context.getExternalFilesDirs("Documents");
        File primaryDir = null;
        if (dirs != null && dirs.length > 0) {
            primaryDir = dirs[0];
        }
        return primaryDir.getAbsolutePath();
    }
    public static File readFile(Context context){
        initFile(context);
        return new File(getSDPath(context)+"/test.txt");
    }
}
