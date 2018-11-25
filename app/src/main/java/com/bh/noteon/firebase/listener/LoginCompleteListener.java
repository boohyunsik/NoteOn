package com.bh.noteon.firebase.listener;

import com.bh.noteon.firebase.dao.LoginInfo;
import com.bh.noteon.logger.Logger;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginCompleteListener implements ValueEventListener {
    private final static String TAG = "LoginCompleteListener";

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Logger.e(TAG, "onCancelled : " + databaseError.getMessage());

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        LoginInfo loginInfo = dataSnapshot.getValue(LoginInfo.class);
        if (loginInfo != null) {
            // login success
            Logger.d(TAG, "This user is in member");
        } else {
            Logger.d(TAG, "This user is not in member");
        }
    }
}
