package com.bh.noteon.firebase.listener;

import com.bh.noteon.firebase.FirebaseConnector;
import com.bh.noteon.firebase.dao.LoginInfo;
import com.bh.noteon.logger.Logger;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginCheckListener implements ValueEventListener {
    private final static String TAG = "LoginCompleteListener";
    private long id;

    public LoginCheckListener(long id) {
        this.id = id;
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Logger.e(TAG, "onCancelled : " + databaseError.getMessage());
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.getChildrenCount() == 0) {
            Logger.d(TAG, "This user is not a member");
            FirebaseConnector.getInstance().addNewMemeber(id);
        } else {
            Logger.d(TAG, "This user is a memeber");
        }
    }
}
