package com.test.demo.test.glide;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.test.demo.test.R;

public class TestGlideActivity extends AppCompatActivity {

    private static final String IMG_PATH = "http://i9.hexunimg.cn/2013-07-05/155842064.jpg";
    private static final String IMG_GIF_PATH = "http://img2.imgtn.bdimg.com/it/u=2088728834,3097480120&fm=26&gp=0.jpg";

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_glide);
        imageView = (ImageView) findViewById(R.id.test_glide_img);

    }

    public void testGlideImg(View view) {

//        // 加载本地图片
//        File file = new File(getExternalCacheDir() + "/image.jpg");
//        Glide.with(this).load(file).into(imageView);
//
//// 加载应用资源
//        int resource = R.drawable.image;
//        Glide.with(this).load(resource).into(imageView);
//
//// 加载二进制流
//        byte[] image = getImageBytes();
//        Glide.with(this).load(image).into(imageView);
//
//// 加载Uri对象
//        Uri imageUri = getImageUri();
//        Glide.with(this).load(imageUri).into(imageView);


        RequestOptions options = new RequestOptions()
                //占位图
                .placeholder(R.drawable.occupancy)
                //异常图
                .error(R.drawable.error);
//                //指定图片的大小
//                .override(100, 100)
//                //禁用内存缓存
//                .skipMemoryCache(true)
//                //禁止缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(this)
                .asGif()//指定图片的格式，如果不设置glide会自动判断，除了asGif()还有asBitmap、asFile()、asDrawable() 如果指定了asBitmap，那么加载GIF图片时就会显示成一张静态图。如果指定asGif()，那么加载静态图片时就会加载失败
                .load(IMG_PATH)
                .apply(options)
                .into(imageView);


    }
}
