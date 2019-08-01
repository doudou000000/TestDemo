// IMyBookManager.aidl
package com.test.demo.test.apiDemo.ipc;

// Declare any non-default types here with import statements

import com.test.demo.test.apiDemo.ipc.MyBook;

interface IMyBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<MyBook> getBookList();

    void addBook(in MyBook book);

}
