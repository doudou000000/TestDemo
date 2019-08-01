package com.test.demo.test;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * Created by DEV002 on 2018/5/24.
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class RegisterNsdServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter_service);
        try {
            registerService(80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public void registerService(int port) throws UnknownHostException {
        final NsdServiceInfo serviceInfo  = new NsdServiceInfo();
        serviceInfo.setServiceName("NsdChat");
        serviceInfo.setServiceType("_http._tcp.");
        serviceInfo.setPort(port);

        NsdManager mNsdManager = (NsdManager) getApplicationContext().getSystemService(Context.NSD_SERVICE);


        NsdManager.RegistrationListener mRegistrationListener = new NsdManager.RegistrationListener() {
            @Override
            public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
                // Save the service name.  Android may have changed it in order to
                // resolve a conflict, so update the name you initially requested
                // with the name Android actually used.
                String mServiceName = NsdServiceInfo.getServiceName();
                Toast.makeText(RegisterNsdServiceActivity.this,"onServiceRegistered====" + mServiceName,Toast.LENGTH_SHORT).show();
                Log.i("DiscoveryListener","onServiceRegistered====" + mServiceName);
            }
            @Override
            public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
                // Registration failed!  Put debugging code here to determine why.
                Log.i("DiscoveryListener","onRegistrationFailed====" + errorCode);
            }
            @Override
            public void onServiceUnregistered(NsdServiceInfo arg0) {
                // Service has been unregistered.  This only happens when you call
                // NsdManager.unregisterService() and pass in this listener.
                Log.i("DiscoveryListener","onServiceUnregistered====");
            }
            @Override
            public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
                // Unregistration failed.  Put debugging code here to determine why.
                Log.i("DiscoveryListener","onUnregistrationFailed====");
            }
        };
        mNsdManager.registerService(
                serviceInfo, NsdManager.PROTOCOL_DNS_SD, mRegistrationListener);
    }

}
