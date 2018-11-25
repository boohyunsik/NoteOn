package com.bh.noteon;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import com.bh.noteon.kakao.KakaoSDKAdapter;
import com.bh.noteon.logger.Logger;
import com.kakao.auth.KakaoSDK;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GlobalApplication extends Application {
    private static final String TAG = "GlobalApplication";
    private static GlobalApplication instance;

    public static synchronized Application getGlobalApplication() {
        return instance;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
        getKeyHash(this);
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    private String getKeyHash(Context context) {
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : pi.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Logger.e(TAG,
                        Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e(TAG, e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            Logger.e(TAG, e.getMessage());
        }
        return null;
    }
}
