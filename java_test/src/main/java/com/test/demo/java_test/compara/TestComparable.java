package com.test.demo.java_test.compara;

public class TestComparable implements Comparable<TestComparable> {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + this.age;
    }

    @Override
    public int compareTo(TestComparable o) {

        if (this.age == o.age){
            return 0;
        }else if(this.age > o.age){
            return 1;
        }else {
            return -1;
        }


    }
}
