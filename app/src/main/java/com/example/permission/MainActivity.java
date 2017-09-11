package com.example.permission;

import android.Manifest;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private int CALLCODE=0;
    @Override
    protected void initview() {
        setContentView(R.layout.activity_main);

        ifHavaPermission(Manifest.permission.ACCESS_FINE_LOCATION,CALLCODE);
    }

    @Override
    protected void initdata() {

    }

    @Override
    public void dosomthing() {
        callPhone();
    }

    public void callPhone(){
        Toast.makeText(this, "电话拨打成功", Toast.LENGTH_SHORT).show();
    }
}
