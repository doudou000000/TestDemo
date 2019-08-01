package com.test.demo.java_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    public static void main(String[] args){


//        HashMap<String,String> map = new HashMap<>();
//
//        map.put("30","这么多废话");
//        map.put("60","as官方");
//        map.put("90","as官方萨尔法规");
//        map.put("10","as官方广告法人");
//        map.put("5","让他很突然");
//        map.put("15","粉黛花海");
//
//
//        System.out.print("==================" + map.get("15"));


//        String str = "123";
//
//        if(str == null & "".equals(str)){
//            System.out.print("成立");
//        }else{
//            System.out.print("不成立");
//        }
//
//        int a=2;
//        System.out.println("a 非的结果是："+(~a));
//

//        int i = 0;
//
//        if(3>4 & (++i)>0){
//            System.out.println("成立时i的值" + i);
//        }else{
//            System.out.println("不成立时i的值" + i);
//        }
//
//
//        int j = 0;
//
//        if(3>2 | (++j)>1){
//            System.out.println("成立时j的值" + j);
//        }else{
//            System.out.println("不成立时j的值" + j);
//        }
//
//        int n = 2;
//
//        n = n << 2;
//
//        System.out.println("n左移2位后的值" + n);




        List<String>  testLists = new ArrayList<>();
        testLists.add("1");
        testLists.add("2");
        testLists.add("3");
        testLists.add("4");
        testLists.add("5");

        testLists.forEach(System.out::print);

    }

    class User{

        private String name;

        private String age;

        public User(){

        }

        public User(String name,String age){

            this.name = name;
            this.age = age;

        }



    }

}
