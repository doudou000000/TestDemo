package com.test.updatelibrary;

public class TestUpdate {
    static {

        System.loadLibrary("update-lib");

    }

    public static native void testPatch(String oldApk,String outApk,String patch);

    public static native void testDiff(String oldApk,String outApk,String patch);

}
