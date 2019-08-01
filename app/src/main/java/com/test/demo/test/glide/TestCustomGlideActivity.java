package com.test.demo.test.glide;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.test.demo.test.R;
import com.test.glidelib.NeGlide;
import com.test.glidelib.RequestListener;

import java.util.ArrayList;
import java.util.List;

public class TestCustomGlideActivity extends AppCompatActivity {

    ImageView imageView;

    List<String> list;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_glide);
        imageView = (ImageView) findViewById(R.id.test_custom_glide_one_img);
        linearLayout = (LinearLayout) findViewById(R.id.test_custom_glide_ll);
        initData();
    }

    private void initData() {

        list = new ArrayList<>();
        list.add("http://hbimg.b0.upaiyun.com/828e72e2855b51a005732f4e007c58c92417a61e1bcb1-61VzNc_fw658");
        list.add("http://img2.imgtn.bdimg.com/it/u=3293723004,1438821102&fm=26&gp=0.jpg");
        list.add("http://hbimg.b0.upaiyun.com/ea52c1c9e5df4039ce5275095a0649921ad083244d20a-Lf82xv_fw658");
        list.add("http://pic.rmb.bdstatic.com/fce5771dd26eb65b08ad1ad099b74129.jpeg");
        list.add("http://i9.hexunimg.cn/2013-07-05/155842064.jpg");
        list.add("http://pic.baike.soso.com/p/20110421/20110421134857-1494834324.jpg");
        list.add("http://img4.cache.netease.com/game/2010/11/15/201011151148508a83f.jpg");
        list.add("http://img.mp.itc.cn/upload/20160713/2498549be77d471b8d29f1f232bffced.jpg");
        list.add("http://k.zol-img.com.cn/dcbbs/23035/a23034716_01000.jpg");
        list.add("http://i9.hexunimg.cn/2013-07-05/155842064.jpg");
        list.add("http://hbimg.b0.upaiyun.com/828e72e2855b51a005732f4e007c58c92417a61e1bcb1-61VzNc_fw658");
        list.add("http://img2.imgtn.bdimg.com/it/u=3293723004,1438821102&fm=26&gp=0.jpg");
        list.add("http://hbimg.b0.upaiyun.com/ea52c1c9e5df4039ce5275095a0649921ad083244d20a-Lf82xv_fw658");
        list.add("http://pic.rmb.bdstatic.com/fce5771dd26eb65b08ad1ad099b74129.jpeg");
        list.add("http://i9.hexunimg.cn/2013-07-05/155842064.jpg");
        list.add("http://pic.baike.soso.com/p/20110421/20110421134857-1494834324.jpg");
        list.add("http://img4.cache.netease.com/game/2010/11/15/201011151148508a83f.jpg");
        list.add("http://img.mp.itc.cn/upload/20160713/2498549be77d471b8d29f1f232bffced.jpg");
        list.add("http://k.zol-img.com.cn/dcbbs/23035/a23034716_01000.jpg");
        list.add("http://i9.hexunimg.cn/2013-07-05/155842064.jpg");
        list.add("http://hbimg.b0.upaiyun.com/828e72e2855b51a005732f4e007c58c92417a61e1bcb1-61VzNc_fw658");
        list.add("http://img2.imgtn.bdimg.com/it/u=3293723004,1438821102&fm=26&gp=0.jpg");
        list.add("http://hbimg.b0.upaiyun.com/ea52c1c9e5df4039ce5275095a0649921ad083244d20a-Lf82xv_fw658");
        list.add("http://pic.rmb.bdstatic.com/fce5771dd26eb65b08ad1ad099b74129.jpeg");
        list.add("http://i9.hexunimg.cn/2013-07-05/155842064.jpg");
        list.add("http://pic.baike.soso.com/p/20110421/20110421134857-1494834324.jpg");
        list.add("http://img4.cache.netease.com/game/2010/11/15/201011151148508a83f.jpg");
        list.add("http://img.mp.itc.cn/upload/20160713/2498549be77d471b8d29f1f232bffced.jpg");
        list.add("http://k.zol-img.com.cn/dcbbs/23035/a23034716_01000.jpg");
        list.add("http://i9.hexunimg.cn/2013-07-05/155842064.jpg");

    }

    public void testCustomGlideLoadImgOne(View view) {

        NeGlide.with(this)
                .load("http://i9.hexunimg.cn/2013-07-05/155842064.jpg")
                .loading(R.drawable.ball)
                .listener(new RequestListener() {
                    @Override
                    public boolean onSuccess(Bitmap bitmap) {
                        return false;
                    }

                    @Override
                    public boolean onFailed() {
                        return false;
                    }
                })
                .into(imageView);

    }

    public void testCustomGlideLoadImgTen(View view) {

        for(int i = 0; i < list.size(); i++){

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(imageView);

            NeGlide.with(this)
                    .load(list.get(i))
                    .loading(R.drawable.ball)
                    .listener(new RequestListener() {
                        @Override
                        public boolean onSuccess(Bitmap bitmap) {
                            return false;
                        }

                        @Override
                        public boolean onFailed() {
                            return false;
                        }
                    })
                    .into(imageView);

        }

    }
}
