package com.test.demo.test.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by DEV002 on 2018/5/24.
 */

public class NetWorkUtils {

    private Context context;

    public NetWorkUtils(Context context) {
        this.context = context;
    }

    public boolean checkNetWorkActive() {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public String checkNetWorkType(){
        String netWorkType = "";
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifiConn = networkInfo.isConnected();
        if(isWifiConn){
            netWorkType = "wifi";
        }
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileConn = networkInfo.isConnected();
        if(isMobileConn){
            netWorkType = "mobile";
        }
        return netWorkType;
    }

    public void checkMobileType(){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        TelephonyManager tm =
                (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        switch (activeNetwork.getType()) {
            case (ConnectivityManager.TYPE_WIFI):
                break;
            case (ConnectivityManager.TYPE_MOBILE): {
                switch (tm.getNetworkType()) {
                    case (TelephonyManager.NETWORK_TYPE_LTE |
                            TelephonyManager.NETWORK_TYPE_HSPAP):
                        break;
                    case (TelephonyManager.NETWORK_TYPE_EDGE |
                            TelephonyManager.NETWORK_TYPE_GPRS):
                        break;
                    default:
                        break;
                }
                break;
            }
            default: break;
        }
    }
}
