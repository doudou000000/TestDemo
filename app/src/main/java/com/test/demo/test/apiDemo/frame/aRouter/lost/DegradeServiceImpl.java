package com.test.demo.test.apiDemo.frame.aRouter.lost;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

@Route(path = "/aRouter/lost")
public class DegradeServiceImpl implements DegradeService {
    @Override
    public void onLost(Context context, Postcard postcard) {
        Toast.makeText(context,"没有找到",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {

    }
}
