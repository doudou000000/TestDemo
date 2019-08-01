package com.test.demo.test;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * 定义三角形
 * Created by DEV002 on 2018/5/21.
 */

public class OpenGlTriangle {

    //浮点缓存区
    private FloatBuffer floatBuffer;

    //顶点渲染器
    private final String vertexShaderCode =
            "uniform mat4 uMVPMatrix;" +
            "attribute vec4 vPosition;" +
                    "void main() {" +
                    "  gl_Position = uMVPMatrix * vPosition;" +
                    "}";

    //
    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";
    private int mProgram;
    private int mPositionHandle;
    private int mColorHandle;
    private int mMVPMatrixHandle;
    //每个顶点的坐标数
    static final int COORDS_PER_VERTEX = 3;
    float triangleCoords[] = {   // in counterclockwise order:
            0.0f,  0.622008459f, 0.0f, // top
            -0.5f, -0.311004243f, 0.0f, // bottom left
            0.5f, -0.311004243f, 0.0f  // bottom right
    };
//    float color[] = { 0.63671875f, 0.76953125f, 0.22265625f, 1.0f };
    float color[] = {
        1, 1, 0, 1,
        0, 1, 1, 1,
        1, 0, 1, 1
    };

    int vertexStride = COORDS_PER_VERTEX * 4;
    int vertexCount = triangleCoords.length / COORDS_PER_VERTEX;
    public OpenGlTriangle() {

        //一个float占4个字节
        ByteBuffer bb = ByteBuffer.allocateDirect(triangleCoords.length * 4);
        //使用设备硬件的本机字节顺序
        bb.order(ByteOrder.nativeOrder());
        floatBuffer = bb.asFloatBuffer();
        //将坐标添加到浮动缓冲区
        floatBuffer.put(triangleCoords);
        //设置缓冲区以读取第一个坐标
        floatBuffer.position(0);


        int vertexShader = MyRenderer.loadShader(GLES20.GL_VERTEX_SHADER,vertexShaderCode);
        int fragmentShader = MyRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER,fragmentShaderCode);

        //创建空OpenGL ES程序
        mProgram = GLES20.glCreateProgram();

        //将顶点着色器添加到程序中
        GLES20.glAttachShader(mProgram,vertexShader);
        //将片段着色器添加到程序中
        GLES20.glAttachShader(mProgram,fragmentShader);
        //创建OpenGL ES程序可执行程序
        GLES20.glLinkProgram(mProgram);
    }

    public void onDraw(float[] mvpMatrix){
        //向OpenGL ES环境添加程序
        GLES20.glUseProgram(mProgram);
        //获取顶点着色器的vPosition成员
        mPositionHandle = GLES20.glGetAttribLocation(mProgram,"vPosition");
        //对三角形顶点启用一个句柄
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        //准备三角坐标数据
        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                vertexStride, floatBuffer);
        // 获取片段着色器的vColor成员
        mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
        // 设置三角形颜色
        GLES20.glUniform4fv(mColorHandle, 1, color, 1);

        // 获取片段着色器的vColor成员
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");
        // 设置三角形颜色
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle,1,false,mvpMatrix,0);


        // 绘制三角形
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);

        // 取消顶点设置
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }

}
