package com.test.testdex;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends BasePluginActivity {

    ImageView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAGggggggggggggg","====00000000000============");
        textView = (ImageView) findViewById(R.id.img);
        Log.i("TAGggggggggggggg","================");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAGggggggggggggg","=========111111111111=======");
                Toast.makeText(that,"点击",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
