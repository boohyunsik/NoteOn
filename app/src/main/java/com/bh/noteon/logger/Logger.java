package com.bh.noteon.logger;

import android.util.Log;

public class Logger {
    private static String TAG = "NoteON";

    public static void d(String className, String msg) {
        Log.d(TAG + "@" + className, msg);
    }

    public static void i(String className, String msg) {
        Log.i(TAG + "@" + className, msg);
    }

    public static void e(String className, String msg) {
        Log.e(TAG + "@" + className, msg);
    }

    public static void wtf(String className, String msg) {
        Log.wtf(TAG + "@" + className, msg);
    }
}
