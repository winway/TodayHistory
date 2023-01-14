package com.example.todayhistory.common;

import android.app.Application;

import org.xutils.x;

/**
 * @PackageName: com.example.todayhistory.utils
 * @ClassName: MyApplication
 * @Author: winwa
 * @Date: 2023/1/11 8:33
 * @Description:
 **/
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
