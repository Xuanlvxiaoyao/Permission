package com.example.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by Administrator on 2017/9/11.
 */

public abstract class BaseActivity extends Activity{

    private int requestCode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initdata();
        initview();
    }

    protected abstract void initview();

    protected abstract void initdata();

    public void ifHavaPermission(String permission,int code){
        requestCode=code;
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, permission);
        //判断是否开启6.0权限
        if(checkSelfPermission== PackageManager.PERMISSION_GRANTED){
            dosomthing();
        }else{
           //没有开启需去申请

            /**
             * 参数
             * 1.上下文
             * 2.权限 声明权限要写成String数组
             * 3.请求码
             */
            ActivityCompat.requestPermissions(this,new String[]{permission},code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==requestCode){
            dosomthing();
        }
    }

    public void dosomthing(){

    }
}
