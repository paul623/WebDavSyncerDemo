package com.paul.webdavsyncerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.paul623.wdsyncer.SyncConfig;
import com.paul623.wdsyncer.SyncManager;
import com.paul623.wdsyncer.api.OnListFileListener;
import com.paul623.wdsyncer.api.OnSyncResultListener;
import com.paul623.wdsyncer.model.DavData;
import com.paul623.wdsyncer.utils.DefaultEncryption;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String text;
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                textView.setText(text);
            }
            return false;
        }
    });
    SyncManager syncManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
        checkPermission();
        syncManager=new SyncManager(this,new DefaultEncryption());
    }

    private void checkPermission() {
        int readExternalStoragePermissionResult = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        if(readExternalStoragePermissionResult != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }
    }

    public void upLoad(View view) {
        syncManager.uploadString("test.txt", "WDSyncer", "如你所见，WebDavSyncer已经配置成功！", new OnSyncResultListener() {
            @Override
            public void onSuccess(String result) {
                Looper.prepare();
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

            @Override
            public void onError(String errorMsg) {
                Looper.prepare();
                Toast.makeText(MainActivity.this,errorMsg,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        });
    }

    public void downLoad(View view) {
        syncManager.downloadString("test.txt", "WDSyncer", new OnSyncResultListener() {
            @Override
            public void onSuccess(String result) {
                Looper.prepare();
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

            @Override
            public void onError(String errorMsg) {
                Looper.prepare();
                Toast.makeText(MainActivity.this,errorMsg,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        });
    }

    public void checkDir(View view) {
        Toast.makeText(MainActivity.this,"读取中,请稍后",Toast.LENGTH_SHORT).show();
        syncManager.listAllFile("WDSyncer", new OnListFileListener() {
            @Override
            public void listAll(List<DavData> davResourceList) {
                text="";
                for(DavData i:davResourceList){
                    text=text+i.getDisplayName()+"\n";
                }
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }

            @Override
            public void onError(String errorMsg) {
                Log.d("MainActivity","请求失败:"+errorMsg);
            }
        });
    }
    /**
     * 测试上传文件
     * 先在本地私有路径下生成test.txt，然后读取并上传
     * 目前还没有做文件上传进度的功能
     * */
    public void upLoadFile(View view)  {
        syncManager.uploadFile("testFile.txt", "WDSyncer", FileTools.readFile(MainActivity.this), new OnSyncResultListener() {
            @Override
            public void onSuccess(String result) {
                Looper.prepare();
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
            @Override
            public void onError(String errorMsg) {
                Looper.prepare();
                Toast.makeText(MainActivity.this,errorMsg,Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        });

    }
}
