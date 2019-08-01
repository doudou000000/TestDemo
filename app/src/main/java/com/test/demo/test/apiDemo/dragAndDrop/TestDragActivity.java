package com.test.demo.test.apiDemo.dragAndDrop;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.demo.test.R;

/**
 * Created by DEV002 on 2018/6/15.
 */

public class TestDragActivity extends AppCompatActivity {
    // 创建一个字符串，用于ImageView label
    private static final String IMAGEVIEW_TAG = "icon bitmap";
    ImageView imageView;

    LinearLayout container;
    RelativeLayout topContainer;
    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drag);
        imageView = (ImageView) findViewById(R.id.test_drag_iv);
        container = (LinearLayout) findViewById(R.id.test_drag_container);
        title = (TextView) findViewById(R.id.test_drag_tv);
        topContainer=(RelativeLayout)findViewById(R.id.test_drag_topContainer);
        imageView.setTag(IMAGEVIEW_TAG);
        container.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()){
                    case DragEvent.ACTION_DRAG_STARTED:
                        //拖拽开始事件
                        if (event.getClipDescription().hasMimeType(
                                ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                            return true;
                        }
                        return false;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        //被拖放View进入目标View
                        container.setBackgroundColor(Color.YELLOW);
                        return true;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        //被拖放View离开目标View
                        container.setBackgroundColor(Color.BLUE);
                        title.setText("");
                        return true;
                    case DragEvent.ACTION_DROP:
                        //释放拖放阴影，并获取移动数据
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        String dragData = item.getText().toString();
                        title.setText(dragData+event.getY()+":"+event.getX());
                        return true;
                    case DragEvent.ACTION_DRAG_ENDED:
                        //拖放事件完成
                        return true;
                    default:
                        break;
                }
                return true;
            }
        });

        topContainer.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        return true;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:
                        return true;
                    case DragEvent.ACTION_DROP:
                        imageView.setX(event.getX()-imageView.getWidth()/2);
                        imageView.setY(event.getY()-imageView.getHeight()/2);
                        return true;
                    case DragEvent.ACTION_DRAG_ENDED:
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                ClipData.Item item = new ClipData.Item((String) v.getTag());
                ClipData clipData = new ClipData((String)v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},item);
                View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(imageView);
                v.startDrag(clipData, dragShadowBuilder, null, 0);
                return true;
            }
        });
    }
}
