package com.test.demo.test.apiDemo.architecture.mvc;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.architecture.bean.Weather;
import com.test.demo.test.apiDemo.architecture.listener.TestOnWeatherListener;
import com.test.demo.test.apiDemo.architecture.model.TestWeatherModel;
import com.test.demo.test.apiDemo.architecture.model.TestWeatherModelImp;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestMVCArchitectureActivity extends BaseActivity implements View.OnClickListener,TestOnWeatherListener {

    EditText editText;

    Button button;

    TextView textView;

    TestWeatherModel testMVCWeatherModel;

    @Override
    public int setLayout() {
        return R.layout.activity_test_mvc_architecture;
    }

    @Override
    public void initView() {
        editText = (EditText) findViewById(R.id.test_mvc_architecture_editText);
        button = (Button) findViewById(R.id.test_mvc_architecture_button);
        textView = (TextView) findViewById(R.id.test_mvc_architecture_textView);
        testMVCWeatherModel = new TestWeatherModelImp(this);
    }

    @Override
    public void initListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_mvc_architecture_button:
                testMVCWeatherModel.getWeatherInfo(editText.getText().toString().trim(),this);
                break;
            default:
                break;
        }
    }

    @Override
    public void getWeatherSucess(Weather weather) {
        textView.setText(weather.toString());
    }

    @Override
    public void getWeatherError() {
        textView.setText("获取失败");
    }
}
