package com.test.demo.test.apiDemo.frame.aRouter.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 1)
public class TestInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        if(!postcard.getPath().equals("/aRouter/TestARouterInterceptorActivity")){
            callback.onContinue(postcard);
        }else{
            callback.onInterrupt(null);
        }

    }

    @Override
    public void init(Context context) {

    }
}
