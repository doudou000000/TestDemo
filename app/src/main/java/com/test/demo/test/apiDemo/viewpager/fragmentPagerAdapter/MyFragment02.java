package com.test.demo.test.apiDemo.viewpager.fragmentPagerAdapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.demo.test.R;

public class MyFragment02 extends Fragment {

    private static final String TAG = "MyFragment=======";
    private static final String MSG = "MyFragment022222";

    private RelativeLayout container;
    private TextView textView;

    private Button btn;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,MSG + "====onAttach====");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,MSG + "====onCreate====");
    }

    public void getMyFragment1Value(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,MSG + "====onCreateView====");
        View view = inflater.inflate(R.layout.activity_test_fragment_page_adapter_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG,MSG + "====onViewCreated====");
        container = (RelativeLayout) view.findViewById(R.id.activity_test_fragment_page_adapter_fragment_container);
        textView = (TextView) view.findViewById(R.id.activity_test_fragment_page_adapter_fragment_tv);
        btn = (Button) view.findViewById(R.id.activity_test_fragment_page_adapter_fragment_btn);
        btn.setVisibility(View.VISIBLE);
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        int color =0xff000000 | red << 16 | green << 8 | blue;
        container.setBackgroundColor(color);
        textView.setText("我是第二个页面");
        textView.setTextColor(Color.BLACK);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment01 myFragment01 = (MyFragment01) getActivity().getSupportFragmentManager().findFragmentByTag("myFragment01");
                String value = myFragment01.setValue();
                textView.setText(value);
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,MSG + "====onActivityCreated====");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,MSG + "====onStart====");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,MSG + "====onResume====");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,MSG + "====onPause====");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,MSG + "====onStop====");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,MSG + "====onDestroyView====");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,MSG + "====onDestroy====");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,MSG + "====onDetach====");
    }
}
