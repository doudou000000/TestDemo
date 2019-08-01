package com.test.demo.test.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by DEV002 on 2018/5/16.
 */

public class FileUtils {

    private Context context;

    public FileUtils(Context context) {
        this.context = context;
    }

    /**
     * 检查外部存储是否有用（读、写）
     * @return
     */
    public boolean isExternalStorageWritable(){

        String state = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }
    /**
     * 检查外部存储至少可读有用
     * @return
     */
    public boolean isExternalStorageReadable(){

        String state = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            return true;
        }
        return false;
    }


    /**
     * Public files 这个目录保存的文件可以被用户或其他APP修改，并且APP卸载时不会消失
     * DIRECTORY_PICTURES 这些目录名称确保系统正确地处理这些文件 例如，在 DIRECTORY_RINGTONES中保存的文件被系统媒体扫描归类为铃声而不是音乐。
     * @param type
     * @return
     */
    public File getExternalStoragePublicFile(String type,String fileName){
        if (isExternalStorageWritable()) {
            File file = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES), fileName);

            if(!file.mkdirs()){
                return null;
            }
            return file;
        }
        return null;
    }
    /**
     * Private files 这个目录保存的文件在技术上是由用户和其他应用程序访问的，因为它们是在外部存储的，但它们是实际不为应用程序之外的用户提供价值的文件
     * 当用户卸载你的应用时，应该删除改目录的文件
     * @param type
     * @return
     */
    public File getExternalFilesDir(String type,String fileName){
        if (isExternalStorageWritable()) {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), fileName);
            if(!file.mkdirs()){
                return null;
            }
            return file;
        }
        return null;
    }

    /**
     * 获取手机根目录
     * @return
     */
    public String getRootDir() {
        if (isExternalStorageWritable()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return null;
    }

    /**
     * 在手机根目录创建文件
     * @param fileName 文件名
     * @return
     */
    public File getExternalStorageDirectoryFile(String fileName) {
        if (isExternalStorageWritable()) {
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            if(!file.mkdirs()){
                return null;
            }
            return file;
        }
        return null;
    }

}
