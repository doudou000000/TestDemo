package com.test.demo.test.apiDemo.matrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.test.demo.test.R;
import com.test.demo.test.apiDemo.base.BaseActivity;

public class TestMatrixDemo1Activity extends BaseActivity{

    ImageView origIv;

    @Override
    public int setLayout() {
        return R.layout.activity_test_matrix_demo_1;
    }

    @Override
    public void initView() {
        origIv = (ImageView) findViewById(R.id.test_matrix_demo_1_iv_orig);
//        //设置旋转后的图片
//        Matrix rotateMatrix = new Matrix();
//        rotateMatrix.setRotate(90);
//        transCanvas.drawBitmap(changeBitmap,rotateMatrix,paint);
//        changeIv.setImageBitmap(changeBitmap);
//        //设置缩放后的图片
//        Matrix scaleMatrix = new Matrix();
//        scaleMatrix.setScale(0.5f,0.5f);
//        transCanvas.drawBitmap(changeBitmap,scaleMatrix,paint);
//        changeIv.setImageBitmap(changeBitmap);
//        //设置错切后的图片
//        Matrix skewMatrix = new Matrix();
//        skewMatrix.setSkew(1f,2f);
//        transCanvas.drawBitmap(changeBitmap,skewMatrix,paint);
//        changeIv.setImageBitmap(changeBitmap);

    }

    @Override
    public void initListener() {

    }

    public void testMatrixDemo1Trans(View view){
        //设置平移后的图片
        Matrix transMatrix = new Matrix();
        transMatrix.setTranslate(200,200);
        origIv.setImageMatrix(transMatrix);
    }

    public void testMatrixDemo1Rotate(View view){
        //设置旋转后的图片
        Matrix transMatrix = new Matrix();
        transMatrix.setRotate(45);
        origIv.setImageMatrix(transMatrix);
    }

    public void testMatrixDemo1Scale(View view){
        //设置缩放后的图片
        Matrix transMatrix = new Matrix();
        transMatrix.setScale(0.5f,0.5f);
        origIv.setImageMatrix(transMatrix);
    }

    public void testMatrixDemo1Skew(View view){
        //设置错切后的图片
        Matrix transMatrix = new Matrix();
        transMatrix.setSkew(1.0f,0.0f,0,0);
        origIv.setImageMatrix(transMatrix);
    }

    public void testMatrixDemo1Value(View view){
        //设置矩阵值后的图片
        float values[] = new float[]{
                1.0f,0.0f,0.0f,
                0.0f,0.5f,0.0f,
                0.0f,0.0f,1.0f
        };
        Matrix transMatrix = new Matrix();
        transMatrix.setValues(values);
        origIv.setImageMatrix(transMatrix);
    }

    public void testMatrixDemo1Reset(View view){
        //设置平移后的图片
        Matrix transMatrix = new Matrix();
        transMatrix.reset();
        transMatrix.isIdentity();
        origIv.setImageMatrix(transMatrix);

    }
}
