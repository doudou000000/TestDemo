package com.test.demo.java_test.compara;

import java.util.Comparator;

public class TestComparator implements Comparator<TestComparatorBean> {


    @Override
    public int compare(TestComparatorBean o1, TestComparatorBean o2) {
        return o1.getAge() == o2.getAge() ? 0 : (o1.getAge() > o2.getAge()) ? 1 : -1;
    }
}
