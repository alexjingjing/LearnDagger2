package com.company.learndagger2;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by liusiming on 2016/10/8.
 */
@Singleton
public class SharedPreferencesUtil {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private static final String TOKEN = "token";
    private static final String USERNAME = "username";
    private static final String KEY_UID           = "uid";
    private static final String KEY_ACCESS_TOKEN  = "access_token";
    private static final String KEY_EXPIRES_IN    = "expires_in";
    private static final String KEY_REFRESH_TOKEN    = "refresh_token";
    private static final String AUTH_WEIBO_TIME = "auth_weibo_time";
    private static final String IS_FIRST_USE = "is_first_use";
    private static final String IS_PUSH_NEW_TASK = "is_push_new_task";
    private static final String IS_PUSH_FINISH_TASK = "is_push_finish_task";
    private static final String CAN_APPLY_NUM = "can_apply_num";
    private static final String APPLIED_NUM = "applied_num";
    private static final String CHECK_VERSION_TIME = "check_version_time";
    private static final String IS_USER_BLOCKED = "is_user_blocked";
    private static final String AD_URL = "ad_url";

    @Inject
    public SharedPreferencesUtil(Context context){
        sp = context.getSharedPreferences("default_name",Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void setToken(String token){
        editor.putString(TOKEN,token);
        editor.commit();
    }

    public String getToken(){
        return sp.getString(TOKEN,"");
    }

    public void setUsername(String username){
        editor.putString(USERNAME,username);
        editor.commit();
    }

    public String getUsername(){
        return sp.getString(USERNAME,"");
    }

    public void setWeiboToken(String WBToken){
        editor.putString(KEY_ACCESS_TOKEN,WBToken);
        editor.commit();
    }

    public String getWeiboToken(){
        return sp.getString(KEY_ACCESS_TOKEN,"");
    }

    public void setWeiboUid(String weiboUid){
        editor.putString(KEY_UID,weiboUid);
        editor.commit();
    }

    public String getWeiboUid(){
        return sp.getString(KEY_UID,"");
    }

    public void setWeiboExpiresIn(Long expiresIn){
        editor.putLong(KEY_EXPIRES_IN,expiresIn);
        editor.commit();
    }

    public Long getWeiboExpiresIn(){
        return sp.getLong(KEY_EXPIRES_IN,0);
    }

    public void setWeiboRefreshToken(String refreshToken){
        editor.putString(KEY_REFRESH_TOKEN,refreshToken);
        editor.commit();
    }

    public String getWeiboRefreshToken(){
        return sp.getString(KEY_REFRESH_TOKEN,"");
    }

    public long getWeiboAuthTime(){
        return sp.getLong(AUTH_WEIBO_TIME, 0);
    }

    public void setWeiboAuthTime(long time){
        editor.putLong(AUTH_WEIBO_TIME,time);
        editor.commit();
    }

    public boolean isFirstUse(){
        return sp.getBoolean(IS_FIRST_USE,true);
    }

    public void setIsFirstUse(boolean isFirstUse){
        editor.putBoolean(IS_FIRST_USE,isFirstUse);
        editor.commit();
    }

    public boolean isPushNewTask(){
        return sp.getBoolean(IS_PUSH_NEW_TASK,true);
    }

    public void setIsPushNewTask(boolean isPushNewTask){
        editor.putBoolean(IS_PUSH_NEW_TASK,isPushNewTask);
        editor.commit();
    }

    public boolean isPushFinishTask(){
        return sp.getBoolean(IS_PUSH_FINISH_TASK,true);
    }

    public void setIsPushFinishTask(boolean isPushFinishTask){
        editor.putBoolean(IS_PUSH_FINISH_TASK,isPushFinishTask);
        editor.commit();
    }

    public int getCanApplyNum(){
        return sp.getInt(CAN_APPLY_NUM,5);
    }

    public void setCanApplyNum(int canApplyNum){
        editor.putInt(CAN_APPLY_NUM,canApplyNum);
        editor.commit();
    }

    public int getAppliedNum(){
        return sp.getInt(APPLIED_NUM,0);
    }

    public void setAppliedNum(int appliedNum){
        editor.putInt(APPLIED_NUM,appliedNum);
        editor.commit();
    }

    public long getCheckVersionTime(){
        return sp.getLong(CHECK_VERSION_TIME,0);
    }

    public void setCheckVersionTime(long checkVersionTime){
        editor.putLong(CHECK_VERSION_TIME,checkVersionTime);
        editor.commit();
    }

    public boolean isUserBlocked(){
        return sp.getBoolean(IS_USER_BLOCKED,false);
    }

    public void setIsUserBlocked(boolean isUserBlocked){
        editor.putBoolean(IS_USER_BLOCKED,isUserBlocked);
        editor.commit();
    }

    public String getAdUrl(){
        return sp.getString(AD_URL,"");
    }

    public void setAdUrl(String adUrl){
        editor.putString(AD_URL,adUrl);
        editor.commit();
    }

    public void deleteAll(){
        editor.clear().commit();
    }
}
