package com.test.demo.test.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by DEV002 on 2018/5/16.
 */

public class SharedPreferenceUtils {

    private String sp2fileName;

    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor editor;

    private Context context;

    /**
     *
     * @param context 上下文
     * @param sp2fileName 文件名
     */
    public SharedPreferenceUtils(Context context, String sp2fileName) {
        this.context = context;
        this.sp2fileName = sp2fileName;
    }

    public void getSharedPreferences(){
        sharedPreferences = context.getSharedPreferences(sp2fileName,Context.MODE_PRIVATE);
    }

    public void getEditor(){

        if (sharedPreferences != null){
            editor = sharedPreferences.edit();
        }
    }

    public boolean  saveStr2File(String key,String value){
        if(editor != null){
            editor.putString(key,value);
            editor.commit();
            return true;
        }
        return false;
    }
    public boolean  saveInt2File(String key,int value){
        if(editor != null){
            editor.putInt(key,value);
            editor.commit();
            return true;
        }
        return false;
    }
    public boolean  saveBoolean2File(String key,boolean value){
        if(editor != null){
            editor.putBoolean(key,value);
            editor.commit();
            return true;
        }
        return false;
    }
    public boolean  saveFloat2File(String key,Float value){
        if(editor != null){
            editor.putFloat(key,value);
            editor.commit();
            return true;
        }
        return false;
    }
    public boolean  saveLong2File(String key,Long value){
        if(editor != null){
            editor.putLong(key,value);
            editor.commit();
            return true;
        }
        return false;
    }
    public boolean  saveSet2File(String key,Set<String> value){
        if(editor != null){
            editor.putStringSet(key,value);
            editor.commit();
            return true;
        }
        return false;
    }

    public String  getStr2File(String key,String value){
        if(sharedPreferences != null){
            return sharedPreferences.getString(key,null);
        }
        return null;
    }
    public int  getInt2File(String key,int value){
        if(sharedPreferences != null){
            return sharedPreferences.getInt(key,0);
        }
        return 0;
    }
    public boolean  getBoolean2File(String key,boolean value){
        if(sharedPreferences != null){
            return sharedPreferences.getBoolean(key,false);
        }
        return false;
    }
    public Float  getFloat2File(String key){
        if(sharedPreferences != null){
            return sharedPreferences.getFloat(key,0f);
        }
        return 0f;
    }
    public Long  getLong2File(String key){
        if(sharedPreferences != null){
            return sharedPreferences.getLong(key,0);
        }
        return 0L;
    }
    public Set<String>  getSet2File(String key){
        if(sharedPreferences != null){
            return sharedPreferences.getStringSet(key,null);
        }
        return null;
    }

}
