package com.test.demo.test.apiDemo.service.handlerService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/6.
 */

public class IntentServiceActivity extends AppCompatActivity {

    ImageView img_1,img_2,img_3,img_4;

    private String urls[] = new String[]{
            "http://img0.imgtn.bdimg.com/it/u=889120611,3801177793&fm=27&gp=0.jpg",
            "http://img3.redocn.com/tupian/20160108/lvsehuahuizhizhangfanyexiaoguobeijingsucai_5728265.jpg",
            "http://img07.tooopen.com/images/20170316/tooopen_sy_201956178977.jpg",
            "http://img.zcool.cn/community/01b34f58eee017a8012049efcfaf50.jpg@1280w_1l_2o_100sh.jpg"
    };

    private MyBroadcast myBroadcast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_service);
        try {
            initView();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initView() {

        img_1 = (ImageView) findViewById(R.id.handler_service_img_1);
        img_2 = (ImageView) findViewById(R.id.handler_service_img_2);
        img_3 = (ImageView) findViewById(R.id.handler_service_img_3);
        img_4 = (ImageView) findViewById(R.id.handler_service_img_4);

        IntentFilter filter = new IntentFilter("com.test.demo.test.apiDemo.service.handlerService");
        myBroadcast = new MyBroadcast();
        registerReceiver(myBroadcast,filter);
    }




    @Override
    protected void onStart() {
        super.onStart();
        Intent mService = new Intent(this,TestIntentService.class);
        for(int i = 0; i < urls.length; i++){

            mService.putExtra("url",urls[i]);
            mService.putExtra("id",(i+1));
            startService(mService);
        }

    }

    class MyBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle bundle = intent.getBundleExtra("bundle");
            Bitmap bitmap = bundle.getParcelable("bitmap");
            int imageId = bundle.getInt("id");
            switch (imageId){
                case 1:
                    img_1.setImageBitmap(bitmap);
                   break;
                case 2:
                    img_2.setImageBitmap(bitmap);
                    break;
                case 3:
                    img_3.setImageBitmap(bitmap);
                    break;
                case 4:
                    img_4.setImageBitmap(bitmap);
                    break;
                default:
                    break;

            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myBroadcast != null){
            unregisterReceiver(myBroadcast);
        }
    }
}
