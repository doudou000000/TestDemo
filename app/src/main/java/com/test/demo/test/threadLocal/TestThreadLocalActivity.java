package com.test.demo.test.threadLocal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.demo.test.R;

public class TestThreadLocalActivity extends AppCompatActivity {
    TestThreadLocalBean testThreadLocalBean;
//    ThreadLocal<TestThreadLocalBean> testThreadLocalBeanThreadLocal = new ThreadLocal<TestThreadLocalBean>(){
//
//        @Override
//        protected TestThreadLocalBean initialValue() {
//            return new TestThreadLocalBean();
//        }
//    };

    ThreadLocal<Boolean> threadLocal = new ThreadLocal();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_thread_local);
//        testThreadLocalBean = new TestThreadLocalBean();

        threadLocal.set(true);

        System.out.println("====000=====" + threadLocal.get());

       new Thread(new Runnable() {
           @Override
           public void run() {

//               testThreadLocalBean.setName("123");
//               testThreadLocalBeanThreadLocal.set(testThreadLocalBean);
//               TestThreadLocalBean testThreadLocalBean = testThreadLocalBeanThreadLocal.get();
//               System.out.println("========" + testThreadLocalBean.getName());
               threadLocal.set(false);
               System.out.println("===111======" + threadLocal.get());

           }
       }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
//                TestThreadLocalBean testThreadLocalBean = testThreadLocalBeanThreadLocal.get();
//                System.out.println("========" + testThreadLocalBean.getName());
                System.out.println("===222======" + threadLocal.get());
            }
        }).start();

    }
}
