package com.test.demo.test.apiDemo.frame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.demo.test.R;
import com.test.demo.test.apiDemo.RecycleView.TestRecycleViewShopActivity;
import com.test.demo.test.apiDemo.architecture.TestArchitectureActivity;
import com.test.demo.test.apiDemo.asyncTask.TestAsyncTaskActivity;
import com.test.demo.test.apiDemo.broadcast.TestBroadcastActivity;
import com.test.demo.test.apiDemo.frame.aRouter.TestARouterActivity;
import com.test.demo.test.apiDemo.frame.okhttp3.TestOkHttp3Activity;
import com.test.demo.test.apiDemo.handler.TestHandlerActivity;
import com.test.demo.test.apiDemo.handlerThread.TestHandleThreadActivity;
import com.test.demo.test.apiDemo.listview.TestListViewActivity;
import com.test.demo.test.apiDemo.matrix.TestMatrixActivity;
import com.test.demo.test.apiDemo.viewTouch.TestViewGroupTouchActivity;
import com.test.demo.test.apiDemo.viewpager.TestViewPagerActivity;
import com.test.demo.test.utils.IntentUtils;


@Route(path = "/aRouter/TestFrameActivity")
public class TestFrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_frame);
    }

    public void testARouter(View view) {
        IntentUtils.startActivity(this,TestARouterActivity.class);
    }
    public void testOKHttp3(View view) {
        IntentUtils.startActivity(this, TestOkHttp3Activity.class);
    }
    public void testBroadcast(View view) {
        IntentUtils.startActivity(this,TestBroadcastActivity.class);
    }
    public void testHandler(View view) {
        IntentUtils.startActivity(this,TestHandlerActivity.class);
    }
    public void testAsyncTask(View view) {
        IntentUtils.startActivity(this,TestAsyncTaskActivity.class);
    }
    public void testViewGroupTouch(View view) {
        IntentUtils.startActivity(this,TestViewGroupTouchActivity.class);
    }
    public void testMatrix(View view) {
        IntentUtils.startActivity(this,TestMatrixActivity.class);
    }
    public void testListView(View view) {
        IntentUtils.startActivity(this,TestListViewActivity.class);
    }
    public void testRecycleViewShop(View view) {
        IntentUtils.startActivity(this,TestRecycleViewShopActivity.class);
    }
    public void testArchitecture(View view) {
        IntentUtils.startActivity(this,TestArchitectureActivity.class);
    }

    public void testFrame(View view) {
        IntentUtils.startActivity(this,TestFrameActivity.class);
    }

}
