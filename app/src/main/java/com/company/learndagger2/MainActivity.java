package com.company.learndagger2;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.company.learndagger2.controller.LoginController;
import com.company.learndagger2.http.HttpUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    // 使用的地方，用Inject标注
    @Inject
    LoginController loginController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((DemoApplication) getApplication()).component().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        loginController.userLogin("13912345601", SHA256Encryprtion("123456"));
    }

    private static String SHA256Encryprtion(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (md != null) {
            byte[] origBytes = password.getBytes();
            md.update(origBytes);
            byte[] digestRes = md.digest();
            String digestStr = getDigestStr(digestRes);
            return digestStr;
        }

        return null;
    }

    private static String getDigestStr(byte[] origBytes) {
        String tempStr = null;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < origBytes.length; i++) {
            tempStr = Integer.toHexString(origBytes[i] & 0xff);
            if (tempStr.length() == 1) {
                stb.append("0");
            }
            stb.append(tempStr);

        }
        return stb.toString();
    }
}
