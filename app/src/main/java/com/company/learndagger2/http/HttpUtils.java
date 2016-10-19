package com.company.learndagger2.http;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by liusiming on 2016/10/9.
 */

public interface HttpUtils {

    @POST("/app/login")
    Observable<BaseResp<String>> login(@Body LoginModel model);
}
