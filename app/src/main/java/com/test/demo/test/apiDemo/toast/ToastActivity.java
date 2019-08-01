package com.test.demo.test.apiDemo.toast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/13.
 */

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void sendToast(View view) {
        Toast.makeText(ToastActivity.this, "我是一个普通的Toast", Toast.LENGTH_SHORT).show();
    }

    public void sendDifferentPositionToast(View view) {
        Toast toast = Toast.makeText(ToastActivity.this, "我是一个不同位置的Toast", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP| Gravity.LEFT,0,0);
        toast.show();
    }

    public void sendCustomLayoutToast(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View toastView = inflater.inflate(R.layout.activity_toast_custom, (ViewGroup) findViewById(R.id.toast_custom_root_layout));
        TextView text = (TextView) toastView.findViewById(R.id.toast_custom_text);
        text.setText("我是一个自定义布局的Toast");
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        toast.show();
    }
}
