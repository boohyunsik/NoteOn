package com.bh.noteon.firebase;

import com.bh.noteon.firebase.listener.LoginCompleteListener;
import com.bh.noteon.logger.Logger;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConnector {
    private static final String TAG = "FirebaseConnector";

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private static class Holder {
        private static final FirebaseConnector instance = new FirebaseConnector();
    }

    private FirebaseConnector() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();
    }

    public static FirebaseConnector getInstance() {
        return Holder.instance;
    }

    public boolean isSigned(String id) {
        mDatabaseReference.addValueEventListener(new LoginCompleteListener());

        return false;
    }
}
