package com.test.demo.test.apiDemo.frame.aRouter;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.test.demo.test.R;
import com.test.demo.test.apiDemo.RecycleView.TestRecycleViewShopActivity;
import com.test.demo.test.apiDemo.architecture.TestArchitectureActivity;
import com.test.demo.test.apiDemo.asyncTask.TestAsyncTaskActivity;
import com.test.demo.test.apiDemo.broadcast.TestBroadcastActivity;
import com.test.demo.test.apiDemo.frame.TestFrameActivity;
import com.test.demo.test.apiDemo.frame.aRouter.bean.TestData;
import com.test.demo.test.apiDemo.frame.aRouter.provider.HelloService;
import com.test.demo.test.apiDemo.handler.TestHandlerActivity;
import com.test.demo.test.apiDemo.handlerThread.TestHandleThreadActivity;
import com.test.demo.test.apiDemo.listview.TestListViewActivity;
import com.test.demo.test.apiDemo.matrix.TestMatrixActivity;
import com.test.demo.test.apiDemo.viewTouch.TestViewGroupTouchActivity;
import com.test.demo.test.utils.IntentUtils;

import java.net.URI;
import java.net.URISyntaxException;


public class TestARouterActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_arouter);
        textView = (TextView) findViewById(R.id.test);
    }

    //普通的Activity跳转
    public void testARouterNormal(View view) {
        ARouter.getInstance().build("/aRouter/TestARouterNormalActivity").navigation();
    }

    //带参数的Activity跳转
    public void testARouterWithData(View view) {
        ARouter.getInstance().build("/aRouter/TestARouterWithDataActivity").withString("key","传递的参数").withParcelable("testData",new TestData("小明","12")).navigation();
    }

    //startActivityForResult
    public void testARouterResult(View view) {
        ARouter.getInstance().build("/aRouter/TestARouterResultActivity").withString("key","点击我就可以返回并携带一个参数‘你好，我是结果’").navigation(this,123);
    }
    //使用URI
    public void testARouterUri(View view) {
        try {
            Uri uri = Uri.parse("/aRouter/TestARouterUriActivity");
            ARouter.getInstance().build(uri).withString("key","我是Uri传递的参数").navigation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //跳转动画
    public void testARouterAnimation(View view) {
//        ARouter.getInstance().build("/aRouter/TestARouterAnimationActivity").withString("key","动画效果").withTransition(R.anim.test_arouter_in,R.anim.test_arouter_out).navigation(this);

        if (Build.VERSION.SDK_INT >= 16) {
//            ActivityOptionsCompat compat = ActivityOptionsCompat.
//                    makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);

            ActivityOptionsCompat compat1 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, textView,"testTv");

            ARouter.getInstance()
                    .build("/aRouter/TestARouterAnimationActivity")
                    .withOptionsCompat(compat1)
                    .navigation(this);
        } else {
            Toast.makeText(this, "API < 16,不支持新版本动画", Toast.LENGTH_SHORT).show();
        }

    }

    //URL跳转
    public void testARouterWebView(View view) {
        ARouter.getInstance()
                .build("/aRouter/TestARouterWebViewActivity")
                .withString("url", "file:///android_asset/schame-test.html")
                .navigation();
    }

    //拦截器
    public void testARouterInterceptor(View view) {
        ARouter.getInstance()
                .build("/aRouter/TestARouterInterceptorActivity")
                .navigation(this, new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {
                        Toast.makeText(TestARouterActivity.this,"跳转成功",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Toast.makeText(TestARouterActivity.this,"被拦截了",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFound(Postcard postcard) {
                        super.onFound(postcard);
                        Toast.makeText(TestARouterActivity.this,"找到路径",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        super.onLost(postcard);
                        Toast.makeText(TestARouterActivity.this,"没有找到",Toast.LENGTH_SHORT).show();

                    }
                });
    }
    //降级
    public void testARouterLost(View view) {
        //单个处理
//        ARouter.getInstance()
//                .build("/aRouter/TestARouterLostActivity1")
//                .withString("key","降级")
//                .navigation(this, new NavCallback() {
//                    @Override
//                    public void onArrival(Postcard postcard) {
//                        Toast.makeText(TestARouterActivity.this,"跳转成功",Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onInterrupt(Postcard postcard) {
//                        Toast.makeText(TestARouterActivity.this,"被拦截了",Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFound(Postcard postcard) {
//                        super.onFound(postcard);
//                        Toast.makeText(TestARouterActivity.this,"找到路径",Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onLost(Postcard postcard) {
//                        super.onLost(postcard);
//                        Toast.makeText(TestARouterActivity.this,"没有找到",Toast.LENGTH_SHORT).show();
//                        //降级主要是指在没有找到跳转的路径时，在该方法中进行回退操作，比如：返回首页等等
//                        ARouter.getInstance()
//                                .build("/aRouter/TestFrameActivity")
//                                .navigation();
//                    }
//                });
        //全局处理
        //如果找不到目标Activity，ARouter默认会提示一个Toast，找不到对象。同样也可以自己进行处理，只需要实现DegradeService接口，并加上一个Path内容任意的注解即可
        ARouter.getInstance()
                .build("/aRouter/TestARouterLostActivity1")
                .withString("key","降级")
                .navigation(this);
        //注意两者不能同时使用，如果同时使用则全局处理不执行
    }
    //服务
    //这里说的服务不是Android四大组件里面的服务，其实是根据path去获取对象。
    //首先写一个接口，实现IProvider接口，定义一个方法sayHello
    public void testARouterService(View view) {
        //第一种形式，使用navByName
//        ((HelloService)ARouter.getInstance()
//                .build("/aRouter/TestARouterServiceActivity")
//                .navigation(this)).sayHello("你好");
        //第二种形式，使用navByType
        ARouter.getInstance().navigation(HelloService.class).sayHello("mike");
    }

    //获取Fragment实例
    public void testARouterFragment(View view) {
        Fragment fragment = (Fragment) ARouter.getInstance().build("/aRouter/TestARouterFragmentActivity").navigation();
        ((TestARouterFragmentActivity)fragment).test("fragment");
    }

    public void testFrame(View view) {
        IntentUtils.startActivity(this,TestFrameActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 123:
                Toast.makeText(TestARouterActivity.this,data.getStringExtra("result"),Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
}
