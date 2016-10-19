package com.company.learndagger2;

import android.content.Context;

import com.company.learndagger2.http.HttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liusiming on 2016/10/9.
 */
@Module
public class MainModule {

    private DemoApplication mApp;

    public MainModule(DemoApplication mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApp;
    }

    @Provides
    @Singleton
    DemoApplication provideApplication() {
        return mApp;
    }
}
