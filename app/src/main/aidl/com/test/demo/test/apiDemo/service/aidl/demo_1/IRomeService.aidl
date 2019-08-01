// IRomeService.aidl
package com.test.demo.test.apiDemo.service.aidl.demo_1;

// Declare any non-default types here with import statements

interface IRomeService {

    int getId();
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
