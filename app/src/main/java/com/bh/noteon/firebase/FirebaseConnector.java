package com.bh.noteon.firebase;

import com.bh.noteon.firebase.dao.LoginInfo;
import com.bh.noteon.firebase.listener.LoginCheckListener;
import com.bh.noteon.logger.Logger;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class FirebaseConnector {
    private static final String TAG = "FirebaseConnector";

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private static class Holder {
        private static final FirebaseConnector instance = new FirebaseConnector();
    }

    private FirebaseConnector() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("user");
    }

    public static FirebaseConnector getInstance() {
        return Holder.instance;
    }

    public void isSigned(long id) {
        mDatabaseReference.orderByChild("id").equalTo(id).addListenerForSingleValueEvent(new LoginCheckListener(id));
    }

    public void addNewMemeber(long id) {
        Logger.d(TAG, "addNewMember");
        String key = mDatabaseReference.push().getKey();
        LoginInfo info = new LoginInfo(id);
        Map<String, Object> map = info.toMap();
        Map<String, Object> child = new HashMap();
        child.put(key+"/", map);
        mDatabaseReference.updateChildren(child);
    }
}
