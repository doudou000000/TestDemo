package com.test.demo.test.apiDemo.architecture.mvp;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.architecture.model.TestWeatherModel;
import com.test.demo.test.apiDemo.architecture.mvp.imp.TestMVPArchitectureImp;
import com.test.demo.test.apiDemo.architecture.mvp.presenter.TestMVPArchitecturePresenter;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestMVPArchitectureActivity extends BaseActivity implements TestMVPArchitectureImp,View.OnClickListener{

    EditText editText;

    Button button;

    TextView textView;

    TestMVPArchitecturePresenter testMVPArchitecturePresenter;

    @Override
    public int setLayout() {
        return  R.layout.activity_test_mvc_architecture;
    }

    @Override
    public void initView() {
        editText = (EditText) findViewById(R.id.test_mvc_architecture_editText);
        button = (Button) findViewById(R.id.test_mvc_architecture_button);
        textView = (TextView) findViewById(R.id.test_mvc_architecture_textView);
        testMVPArchitecturePresenter = new TestMVPArchitecturePresenter(this,this);
    }

    @Override
    public void initListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void setTextContent(String weatherInfo) {
        textView.setText(weatherInfo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_mvc_architecture_button:
                testMVPArchitecturePresenter.getWeatherInfo(editText.getText().toString().trim());
                break;
            default:
                break;
        }
    }
}
