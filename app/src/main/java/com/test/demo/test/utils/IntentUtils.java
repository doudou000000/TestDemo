package com.test.demo.test.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by DEV002 on 2018/6/4.
 */

public class IntentUtils {

    public static void  startActivity(Context context,Class classes){
        Intent intent = new Intent(context,classes);
        context.startActivity(intent);
    }

    public static void  startActivityForBundle(Context context, Class classes, Bundle bundle){
        Intent intent = new Intent(context,classes);
        intent.putExtra("bundle",bundle);
        context.startActivity(intent);
    }

    public static void  startActivityForFlag(Context context, Class classes, int flags){
        Intent intent = new Intent(context,classes);
        intent.addFlags(flags);
        context.startActivity(intent);
    }
}
