package com.test.demo.test.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static CrashHandler crashHandler;

    private Context context;

    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/crash/log/";

    private static final String FILE_NAME = "crash";

    private static final String FILE_NAME_SUFFIX = ".trace";

    public static CrashHandler getInstance(){

        if(crashHandler == null){
            crashHandler = new CrashHandler();
        }
        return crashHandler;
    }

    public void init(Context context){
        context = context.getApplicationContext();
        //设置系统默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            //将异常信息导出到SD卡中
            dumpExceptionToSDCard(e);
//            //上传异常信息到服务器，以便开发人员分析
//            uploadExceptionToServer();
        }catch (Exception e1){
            e1.printStackTrace();
        }
        e.printStackTrace();

        if(mDefaultCrashHandler != null){
            mDefaultCrashHandler.uncaughtException(t,e);
        }else{
            Process.killProcess(Process.myPid());
        }

    }

    private void dumpExceptionToSDCard(Throwable ex) throws Exception{
        //判断SD卡是否存在或能否使用，不存在或无法使用就返回
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return;
        }

        File dir = new File(PATH);

        if(!dir.exists()){
            dir.mkdirs();
        }
        long current = System.currentTimeMillis();

        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(current));

        File file = new File(PATH + FILE_NAME + time + FILE_NAME_SUFFIX);

        if(!file.exists()){
            file.createNewFile();
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        pw.println(time);

        dumpPhoneInfo(pw);

        pw.println();

        ex.printStackTrace(pw);

    }

    private void dumpPhoneInfo(PrintWriter pw) throws PackageManager.NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(context.getPackageName(),PackageManager.GET_ACTIVITIES);
        pw.println("APP Version");
        pw.println(pi.versionName);
        pw.println("_");
        pw.println(pi.versionCode);

        //Android版本号
        pw.println("OS Version: ");
        pw.println(Build.VERSION.RELEASE);
        pw.println("_");
        pw.println(Build.VERSION.SDK_INT);

        //手机制造商
        pw.println("Vendor:");
        pw.println(Build.MANUFACTURER);

        //手机号
        pw.println("Model:");
        pw.println(Build.MODEL);

        //CPU架构
        pw.println("CPU ABI:");
        pw.println(Build.CPU_ABI);
    }
}
