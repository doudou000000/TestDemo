package com.test.demo.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by DEV002 on 2018/5/25.
 */

public class ContactsActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        getSupportFragmentManager().beginTransaction().add(R.id.contacts_container,new ContactsFragment()).commit();
    }
}
