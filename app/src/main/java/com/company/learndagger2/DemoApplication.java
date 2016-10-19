package com.company.learndagger2;

import android.app.Application;

import com.company.learndagger2.http.HttpUtils;

import javax.inject.Inject;

/**
 * Created by liusiming on 2016/10/8.
 */

public class DemoApplication extends Application {

    private AppComponent component;
    //private ApplicationComponent component;

    @Inject
    HttpUtils httpUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        // 使用dagger2自动生成的类，构造出来，将AndroidModule设置进去，完成初始化，然后使用inject注入进来。这个操作完成后，locationManager赋值成功
        //component = DaggerApplicationComponent.builder().androidModule(new AndroidModule(this)).build();
        //component.inject(this);
        component = DaggerAppComponent.builder().mainModule(new MainModule(this)).build();
        component.inject(this);
    }

    public AppComponent component() {return component;}
}
