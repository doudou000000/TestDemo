package com.test.demo.java_test.testJson;

import java.util.ArrayList;
import java.util.List;

public class TestJson {


    public static void main(String[] args){

        TestJsonShotX testJsonShotX = new TestJsonShotX();

        testJsonShotX.setShotX("10");
        testJsonShotX.setShotXLength("20");

        TestJsonShotX testJsonShotX1 = new TestJsonShotX();

        testJsonShotX1.setShotX("20");
        testJsonShotX1.setShotXLength("30");



        TestJsonX testJsonX = new TestJsonX();

        testJsonX.setWidth("1080..1920");
        testJsonX.setShotX(testJsonShotX);

        TestJsonX testJsonX1 = new TestJsonX();

        testJsonX1.setWidth("1920..2120");
        testJsonX1.setShotX(testJsonShotX1);




        TestJsonShotY testJsonShotY = new TestJsonShotY();

        testJsonShotY.setShotXLength("50");

        TestJsonShotY testJsonShotY1 = new TestJsonShotY();

        testJsonShotY1.setShotXLength("60");

        TestJsonY testJsonY = new TestJsonY();

        testJsonY.setHeight("1080..1920");
        testJsonY.setShotY(testJsonShotY);

        TestJsonY testJsonY1 = new TestJsonY();

        testJsonY1.setHeight("1920..2120");
        testJsonY1.setShotY(testJsonShotY1);


        List<TestJsonX> testJsonXList = new ArrayList<>();
        testJsonXList.add(testJsonX);
        testJsonXList.add(testJsonX1);

        List<TestJsonY> testJsonYList = new ArrayList<>();
        testJsonYList.add(testJsonY);
        testJsonYList.add(testJsonY1);


        TestJsonXY testJsonXY = new TestJsonXY();

        testJsonXY.setX(testJsonXList);
        testJsonXY.setY(testJsonYList);



        TestJsonBean testJsonBean = new TestJsonBean();

        testJsonBean.setName("王者荣耀");

        testJsonBean.setXy(testJsonXY);

        TestJsonBean testJsonBean1 = new TestJsonBean();

        testJsonBean1.setName("QQ飞车");

        testJsonBean1.setXy(testJsonXY);

        List<TestJsonBean> testJsonBeanList = new ArrayList<>();

        testJsonBeanList.add(testJsonBean);
        testJsonBeanList.add(testJsonBean1);




    }



}
