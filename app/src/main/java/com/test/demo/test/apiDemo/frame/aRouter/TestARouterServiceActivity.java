package com.test.demo.test.apiDemo.frame.aRouter;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.demo.test.apiDemo.frame.aRouter.provider.HelloService;

@Route(path = "/aRouter/TestARouterServiceActivity")
public class TestARouterServiceActivity implements HelloService {

    private Context context;

    @Override
    public void sayHello(String hello) {
        Toast.makeText(context,"service===" + hello,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
