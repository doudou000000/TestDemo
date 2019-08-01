// IBookManager.aidl
package com.test.demo.test.apiDemo.service.aidl.demo_2;

import com.test.demo.test.apiDemo.service.aidl.demo_2.Book;
// Declare any non-default types here with import statements

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);

}
