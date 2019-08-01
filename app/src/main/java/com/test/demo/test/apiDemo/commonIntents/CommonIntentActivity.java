package com.test.demo.test.apiDemo.commonIntents;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.test.demo.test.MainActivity;
import com.test.demo.test.R;

import java.util.Calendar;

/**
 * Created by DEV002 on 2018/5/31.
 */

public class CommonIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_intent);
        Log.i(MainActivity.ACTIVITY_LIFE,"CommonIntentActivity======onCreate=======");
        //----------------------Alarm Clock----------------------
//        createAlarm("设置闹钟",1,60);
        //---------------------Create a timer----------------------
//        startTimer("创建一个计时器",100);
        //---------------------Add a calendar event--------------
//        addEvent("日历事件","家",Calendar.getInstance(),Calendar.getInstance());
        //--------------------capturePhoto----------------------
//        capturePhoto("");
        //-------------------selectContact----------------------
        selectContact();

    }

    public void createAlarm(String message, int hour, int minutes) {
        int days[] = new int[]{Calendar.MONDAY};
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, 6)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30)
                .putExtra(AlarmClock.EXTRA_DAYS,days);
        Intent chooseIntent = Intent.createChooser(intent,"启动闹钟");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooseIntent);
        }
    }

    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void addEvent(String title, String location, Calendar begin, Calendar end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void capturePhoto(String targetFilename) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT,
//                Uri.withAppendedPath(mLocationForPhotos, targetFilename);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void selectContact() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
//            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MainActivity.ACTIVITY_LIFE,"CommonIntentActivity======onStart=======");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MainActivity.ACTIVITY_LIFE,"CommonIntentActivity======onResume=======");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MainActivity.ACTIVITY_LIFE,"CommonIntentActivity======onPause=======");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MainActivity.ACTIVITY_LIFE,"CommonIntentActivity======onStop=======");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(MainActivity.ACTIVITY_LIFE,"CommonIntentActivity======onRestart=======");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MainActivity.ACTIVITY_LIFE,"CommonIntentActivity======onDestroy=======");
    }

}
