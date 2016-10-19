package com.company.learndagger2;

import com.company.learndagger2.http.HttpUtils;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liusiming on 2016/10/9.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    HttpUtils provideHttpUtils() {
        // Log 信息
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl.Builder requestBuilder = original.url().newBuilder()
                                .addQueryParameter("version", "112A")
                                .addQueryParameter("token", "");

                        Request request = original.newBuilder()
                                .method(original.method(), original.body())
                                .url(requestBuilder.build())
                                .build();

                        return chain.proceed(request);
                    }
                }).addInterceptor(loggingInterceptor).build();
        /**
         * 在Application的onCreate方法中初始化MLog日志框架
         * 并根据apk环境判断是否显示日志信息
         */
        Retrofit retrofit;
        if (BuildConfig.LOG_DEBUG) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.dianjinmiao.com:28080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
        } else {
            // 无log信息
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.dianjinmiao.com:28080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit.create(HttpUtils.class);
    }
}
