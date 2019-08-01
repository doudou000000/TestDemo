package com.test.demo.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.test.demo.test.utils.ImageUtils;

/**
 * Created by DEV002 on 2018/5/21.
 */

public class LoadLargeBitmapActivity extends AppCompatActivity {

    ImageView imageView;
//    http://img.go007.com/2016/05/15/ec830a0618708f1e_0.jpg
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_bitmap);
        imageView = (ImageView) findViewById(R.id.image_view_large);
//        imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.large_pictrue));
        imageView.setImageBitmap(ImageUtils.decodeSampledBitmapFromResource(getResources(),R.drawable.large_pictrue,100,100));
    }
}
