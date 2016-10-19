package com.company.learndagger2.controller;

import android.util.Log;

import com.company.learndagger2.RetryWithDelay;
import com.company.learndagger2.http.BaseResp;
import com.company.learndagger2.http.HttpUtils;
import com.company.learndagger2.http.LoginModel;
import com.company.learndagger2.http.LoginResp;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liusiming on 2016/10/14.
 */

public class LoginController {

    @Inject
    HttpUtils httpUtils;

    @Inject
    public LoginController() {

    }

    public void userLogin(String username, String password) {
        httpUtils.login(new LoginModel(username, password))
                .retryWhen(new RetryWithDelay(3, 500))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("lsm1993", e.toString());
                    }

                    @Override
                    public void onNext(BaseResp<String> baseResp) {
                        Log.d("lsm1993", String.valueOf(Thread.currentThread()));
                        Log.d("lsm1993", baseResp.token);
                    }
                });
    }
}
