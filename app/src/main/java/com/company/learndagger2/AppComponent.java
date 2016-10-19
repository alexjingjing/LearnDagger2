package com.company.learndagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by liusiming on 2016/10/9.
 */
@Singleton
@Component(modules = {MainModule.class, ApiModule.class})
public interface AppComponent {
    void inject(DemoApplication application);
    void inject(MainActivity activity);
}
