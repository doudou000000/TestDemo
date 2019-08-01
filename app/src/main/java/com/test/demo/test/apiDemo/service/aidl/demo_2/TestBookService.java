package com.test.demo.test.apiDemo.service.aidl.demo_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEV002 on 2018/6/6.
 */

public class TestBookService extends Service{

    private IBookManager.Stub binder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            Log.i("AIDL-getBookList()",Thread.currentThread().getName());
            return getBook();
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            Log.i("AIDL-addBook",Thread.currentThread().getName());
            Log.i("AIDL",book.getBookName() + "作者：" + book.getBookAuthor());
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public List<Book> getBook(){
        Book book = new Book("C程序设计（第三版）","谭浩强");
        Book book1 = new Book("数据结构","吕红艳");
        Book book2 = new Book("Java设计模式","浩瀚");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);
        return bookList;
    }

}
