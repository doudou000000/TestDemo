package com.test.demo.test.apiDemo.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.LruCache;

public class MyBook implements Parcelable {

    private String bookName;

    private int bookId;

    public MyBook(String bookName, int bookId) {
        this.bookName = bookName;
        this.bookId = bookId;
    }

    protected MyBook(Parcel in) {

        bookName = in.readString();

        bookId = in.readInt();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(bookId);

        dest.writeString(bookName);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MyBook> CREATOR = new Creator<MyBook>() {
        @Override
        public MyBook createFromParcel(Parcel in) {
            return new MyBook(in);
        }

        @Override
        public MyBook[] newArray(int size) {
            return new MyBook[size];
        }
    };
}
