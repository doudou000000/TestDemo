package com.test.demo.test.apiDemo.animation.property.demo2;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.demo.test.R;

/**
 * Shape (android.graphics.drawable.shapes)
 ----PathShape (android.graphics.drawable.shapes)
 ----RectShape (android.graphics.drawable.shapes)
 --------ArcShape (android.graphics.drawable.shapes)
 --------OvalShape (android.graphics.drawable.shapes)
 --------RoundRectShape (android.graphics.drawable.shapes)
 */
public class TestShapeDrawableActivity extends Activity {

    TextView duckyImg,blockImg,franticImg,pencilImg,wootImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_shape_drawable);
        duckyImg = (TextView) findViewById(R.id.test_shape_drawable_ducky);
        blockImg = (TextView) findViewById(R.id.test_shape_drawable_block);
        franticImg = (TextView) findViewById(R.id.test_shape_drawable_frantic);
        pencilImg = (TextView) findViewById(R.id.test_shape_drawable_pencil);
        wootImg = (TextView) findViewById(R.id.test_shape_drawable_woot);
        //椭圆
        OvalShape ovalShape = new OvalShape();
        ShapeDrawable drawable = new ShapeDrawable(ovalShape);
        drawable.getPaint().setAntiAlias(true);
        drawable.getPaint().setColor(Color.RED);
        duckyImg.setBackground(drawable);
        //矩形
        RectShape rectShape = new RectShape();
        ShapeDrawable rectDrawable = new ShapeDrawable(rectShape);
        rectDrawable.getPaint().setColor(Color.GREEN);
        rectDrawable.getPaint().setAntiAlias(true);
        blockImg.setBackground(rectDrawable);
        //圆角矩形
        float[] outerRadii = {20, 20, 40, 40, 60, 60, 80, 80};
        float[] innerRadii = {20, 20, 20, 20, 20, 20, 20, 20};//内矩形 圆角半径
        RoundRectShape roundRectShape = new RoundRectShape(outerRadii,null,innerRadii);
        ShapeDrawable roundRectDrawable = new ShapeDrawable(roundRectShape);
        roundRectDrawable.getPaint().setColor(Color.BLUE);
        roundRectDrawable.getPaint().setAntiAlias(true);
        franticImg.setBackground(roundRectDrawable);
        //圆弧
        ArcShape arcShape = new ArcShape(30,300);
        ShapeDrawable arcShapeDrawable = new ShapeDrawable(arcShape);
        arcShapeDrawable.getPaint().setColor(Color.YELLOW);
        arcShapeDrawable.getPaint().setAntiAlias(true);
        pencilImg.setBackground(arcShapeDrawable);

//        //path
//        Path path = new Path();
//        path.moveTo((wootImg.getLeft() + wootImg.getWidth()/2),wootImg.getTop());
//        path.lineTo(wootImg.getRight(),(wootImg.getTop() + wootImg.getHeight()/2));
//        path.lineTo((wootImg.getLeft() + wootImg.getWidth()/2),wootImg.getBottom());
//        path.lineTo(wootImg.getLeft(),(wootImg.getTop() + wootImg.getHeight()/2));
//        PathShape pathShape = new PathShape(path,400,400);
//        ShapeDrawable pathShapeDrawable = new ShapeDrawable(pathShape);
//        pathShapeDrawable.getPaint().setColor(Color.RED);
//        pathShapeDrawable.getPaint().setAntiAlias(true);
//        wootImg.setBackground(pathShapeDrawable);
        Path path = new Path();
        Log.i("wootImg","wootImg.getWidth()======" + wootImg.getWidth());
        Log.i("wootImg","wootImg.getHeight()======" + wootImg.getHeight());
        path.moveTo(50, 0);
        path.lineTo(0, wootImg.getHeight()/2);
        path.lineTo(wootImg.getWidth()/2, wootImg.getHeight());
        path.lineTo(wootImg.getWidth(), wootImg.getHeight()/2);
        path.lineTo(wootImg.getWidth()/2, 0);
        PathShape pathShape = new PathShape(path, 200, 100);
        ShapeDrawable pathDrawable = new ShapeDrawable(pathShape);
        pathDrawable.getPaint().setColor(Color.RED);
        pathDrawable.getPaint().setStyle(Paint.Style.FILL);
        wootImg.setBackground(pathDrawable);
    }
}
