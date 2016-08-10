package com.red.wolf.rxjavademo.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/8/10 0010.
 */
public class DebugUtils {
    private static boolean type = true;

    public static void LogI(Object obj) {
        if (type) {
            Log.i("RedWolf", obj + "");
        }
    }
}
