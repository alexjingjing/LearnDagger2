package com.company.learndagger2;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

/**
 * RxJava的重试方法调用
 * 构造方法中可以设置最大重试次数和重试间隔时间
 * Created by liusiming on 2016/10/19.
 */

public class RetryWithDelay implements Func1<Observable<? extends Throwable>, Observable<?>> {

    private final int maxRetries;
    private final long retryDelayMillis;
    private int retryCount;

    public RetryWithDelay(int maxRetries, long retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
    }

    /**
     * 处理异常
     * Rx订阅者一旦发现异常，会调用RetryWhen方法
     * 在这个方法，我们将异常转换成新的被观测者，重新进行观测（重新网络请求）
     * 在最后超过此最大尝试次数后，返回异常
     *
     * @param observable
     * @return
     */
    @Override
    public Observable<?> call(Observable<? extends Throwable> observable) {
        return observable.flatMap(new Func1<Throwable, Observable<?>>() {
            @Override
            public Observable<?> call(Throwable throwable) {
                if (++retryCount < maxRetries) {
                    Log.d("lsm1993", "error" + retryCount);
                    return Observable.timer(retryDelayMillis, TimeUnit.MILLISECONDS);
                }
                return Observable.error(throwable);
            }
        });
    }
}
