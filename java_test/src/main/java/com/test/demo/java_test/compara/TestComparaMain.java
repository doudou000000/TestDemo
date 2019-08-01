package com.test.demo.java_test.compara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparaMain {

    public static void main(String[] arges){
        TestComparable testComparable = new TestComparable();
        testComparable.setName("王三");
        testComparable.setAge(27);
        TestComparable testComparable1 = new TestComparable();
        testComparable1.setName("李四");
        testComparable1.setAge(28);



        List<TestComparable> testComparables = new ArrayList<>();
        testComparables.add(testComparable);
        testComparables.add(testComparable1);

        System.out.print(testComparables.toString());

        Collections.sort(testComparables);


        System.out.print(testComparables.toString());


        TestComparatorBean testComparatorBean = new TestComparatorBean();
        testComparatorBean.setName("找五");
        testComparatorBean.setAge(13);

        TestComparatorBean testComparatorBean1 = new TestComparatorBean();
        testComparatorBean1.setName("随六");
        testComparatorBean1.setAge(12);

        List<TestComparatorBean> testComparatorEnties = new ArrayList<>();
        testComparatorEnties.add(testComparatorBean);
        testComparatorEnties.add(testComparatorBean1);

        System.out.println(testComparatorEnties.toString());

        Collections.sort(testComparatorEnties,new TestComparator());

        System.out.println(testComparatorEnties.toString());

    }

}
