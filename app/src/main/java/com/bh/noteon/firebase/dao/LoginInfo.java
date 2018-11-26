package com.bh.noteon.firebase.dao;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class LoginInfo {
    private final Long id;

    public LoginInfo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap();
        result.put("id", id);
        return result;
    }
}
