package com.bh.noteon.kakao;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import com.bh.noteon.logger.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KakaoSDKAdapter {
    private static final String TAG = "KakaoSDKAdapter";
    public String getKeyHash(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (packageInfo == null) {
                return null;
            }

            for (Signature signature : packageInfo.signatures) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
                } catch (NoSuchAlgorithmException e) {
                    Logger.e(TAG, "Unable to get MeesageDigest.");
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e(TAG, e.getMessage());
        }
        return null;
    }
}
