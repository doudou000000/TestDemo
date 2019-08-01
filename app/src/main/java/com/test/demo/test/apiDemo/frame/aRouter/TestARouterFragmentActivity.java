package com.test.demo.test.apiDemo.frame.aRouter;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/aRouter/TestARouterFragmentActivity")
public class TestARouterFragmentActivity extends Fragment {

    public void test(String test){
        System.out.println("test========" + test);
    }

}
