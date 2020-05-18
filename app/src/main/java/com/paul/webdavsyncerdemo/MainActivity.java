package com.paul.webdavsyncerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.paul623.wdsyncer.SyncConfig;
import com.paul623.wdsyncer.SyncManager;
import com.paul623.wdsyncer.api.OnListFileListener;
import com.paul623.wdsyncer.api.OnSyncResultListener;
import com.paul623.wdsyncer.model.DavData;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String text;
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    textView.setText(text);
                    break;
            }
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
    }

    public void upLoad(View view) {
        SyncConfig config=new SyncConfig(MainActivity.this);
        //TODO
        //config.setPassWord("你的密码");
        //config.setUserAccount("你的账户");
        SyncManager syncManager=new SyncManager(MainActivity.this);
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
        SyncConfig config=new SyncConfig(MainActivity.this);
        //TODO
        //config.setPassWord("你的密码");
        //config.setUserAccount("你的账户");
        SyncManager syncManager=new SyncManager(MainActivity.this);
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
        SyncConfig config=new SyncConfig(MainActivity.this);
        //TODO
        //config.setPassWord("你的密码");
        //config.setUserAccount("你的账户");
        SyncManager syncManager=new SyncManager(MainActivity.this);
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

            }
        });
    }
}
