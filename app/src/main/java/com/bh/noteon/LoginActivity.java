package com.bh.noteon;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;

import com.bh.noteon.kakao.KakaoSDKAdapter;
import com.bh.noteon.logger.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    // 멤버변수는 mContext 처럼 m으로 시작한다.
    private Context mContext;
    private String mKeyHash;

    // for Kakako
    private KakaoSDKAdapter mKakaoSDKAdapter;
    private String mAppKey;
    private String mRestKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 로그 찍을땐 아래와 같이 Logger 함수를 이용한다.
        Logger.d(TAG, "onCreate()");

        mContext = getApplicationContext();
        mKakaoSDKAdapter = new KakaoSDKAdapter();
        mKeyHash = mKakaoSDKAdapter.getKeyHash(mContext);

        // Kakao key가 필요할 때는 getString 함수를 이용하면 된다.
        mAppKey = getString(R.string.kakao_native_app_key);
        mRestKey = getString(R.string.kakao_rest_api_key);
    }


}
