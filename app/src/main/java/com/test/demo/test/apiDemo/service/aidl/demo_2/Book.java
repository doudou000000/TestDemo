package com.test.demo.test.apiDemo.service.aidl.demo_2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DEV002 on 2018/6/6.
 */

public class Book implements Parcelable {

    private String bookName;

    private String bookAuthor;

    public Book() {
    }

    public Book(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    protected Book(Parcel in) {

        bookName = in.readString();
        bookAuthor = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(bookName);
        dest.writeString(bookAuthor);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
