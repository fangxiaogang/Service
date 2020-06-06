package com.test.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button bind, unbind, getServiceStatus;
    // 保持所启动的Service的IBinder对象
    BindService.MyBinder binder;
    // 定义一个ServiceConnection对象
    private ServiceConnection conn = new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 当该Activity与Service连接成功时回调该方法
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // 当该Activity与Service断开连接时回调该方法
        }

    };
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取程序界面中的start、stop、getServiceStatus按钮
        bind = (Button) findViewById(R.id.bind);
        unbind = (Button) findViewById(R.id.unbind);
        getServiceStatus = (Button) findViewById(R.id.getServiceStatus);
        //创建启动Service的Intent
        final Intent intent = new Intent();
        //为Intent设置Action属性

        bind.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View source){
                //绑定指定Serivce
                Intent start = new Intent(MainActivity.this,BindService.class);
                startService(start);
            }
        });
        unbind.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View source){
                //解除绑定Serivce
                Intent stop = new Intent(MainActivity.this,BindService.class);
                stopService(stop);
            }
        });
        getServiceStatus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View source){
                // 获取、并显示Service的count值
                Toast.makeText(MainActivity.this
                        , "Serivce的count值为：" + "1"
                        , Toast.LENGTH_LONG).show();
            }
        });
    }
}