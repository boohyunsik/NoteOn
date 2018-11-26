package com.bh.noteon.kakao;

import android.content.Context;
import android.content.Intent;

import com.bh.noteon.MainActivity;
import com.bh.noteon.firebase.FirebaseConnector;
import com.bh.noteon.logger.Logger;
import com.kakao.auth.ISessionCallback;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;

import java.util.ArrayList;
import java.util.List;

public class KakaoSessionCallback implements ISessionCallback {
    private static final String TAG = "KakaoSessionCallback";
    private Context mContext;
    private String mUserId;

    public KakaoSessionCallback(Context context) {
        mContext = context;
    }

    @Override
    public void onSessionOpened() {
        List<String> keys = new ArrayList();
        UserManagement.getInstance().me(keys, new MeV2ResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {

            }

            @Override
            public void onSuccess(MeV2Response result) {
                Logger.d(TAG, "userId : " + result.getId());
                FirebaseConnector.getInstance().isSigned(result.getId());
                redirectSignupActivity();
            }
        });
    }

    @Override
    public void onSessionOpenFailed(KakaoException exception) {
        if(exception != null){
            Logger.e(TAG, exception.getMessage());
        }
    }

    private void redirectSignupActivity() {
        final Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }
}
