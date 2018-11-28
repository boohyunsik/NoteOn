package com.bh.noteon;

import android.app.Application;
import com.bh.noteon.kakao.KakaoSDKAdapter;
import com.kakao.auth.KakaoSDK;

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
        KakaoSDK.init(new KakaoSDKAdapter());
    }
}
