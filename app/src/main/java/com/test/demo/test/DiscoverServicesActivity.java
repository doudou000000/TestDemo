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
import android.widget.TextView;
import android.widget.Toast;

import java.net.InetAddress;

/**
 * Created by DEV002 on 2018/5/24.
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class DiscoverServicesActivity extends AppCompatActivity {

    TextView textView;
    NsdManager mNsdManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_service);
        textView = (TextView) findViewById(R.id.discover_service_tv);
        mNsdManager = (NsdManager) getApplicationContext().getSystemService(Context.NSD_SERVICE);
        mNsdManager.discoverServices("_http._tcp", NsdManager.PROTOCOL_DNS_SD, mDiscoveryListener);
    }

    NsdManager.DiscoveryListener mDiscoveryListener  = new NsdManager.DiscoveryListener() {
        @Override
        public void onStartDiscoveryFailed(String serviceType, int errorCode) {
            Log.i("DiscoveryListener","onStartDiscoveryFailed====");
        }

        @Override
        public void onStopDiscoveryFailed(String serviceType, int errorCode) {
            Log.i("DiscoveryListener","onStopDiscoveryFailed====");
        }

        @Override
        public void onDiscoveryStarted(String serviceType) {
            Toast.makeText(DiscoverServicesActivity.this,"onDiscoveryStarted====",Toast.LENGTH_SHORT).show();
            Log.i("DiscoveryListener","onDiscoveryStarted====");
        }

        @Override
        public void onDiscoveryStopped(String serviceType) {
            Log.i("DiscoveryListener","onDiscoveryStopped====");
        }

        @Override
        public void onServiceFound(NsdServiceInfo serviceInfo) {
            Toast.makeText(DiscoverServicesActivity.this,"onServiceFound====" + serviceInfo.getServiceName(),Toast.LENGTH_SHORT).show();
            Log.i("DiscoveryListener","onServiceFound====" + serviceInfo.getServiceName());
            mNsdManager.resolveService(serviceInfo, new NsdManager.ResolveListener() {
                @Override
                public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {

                }

                @Override
                public void onServiceResolved(NsdServiceInfo serviceInfo) {
                    int port = serviceInfo.getPort();
                    InetAddress host = serviceInfo.getHost();
                }
            });
        }

        @Override
        public void onServiceLost(NsdServiceInfo serviceInfo) {
            Log.i("DiscoveryListener","onServiceLost====" + serviceInfo.getServiceName());
        }
    };

}
