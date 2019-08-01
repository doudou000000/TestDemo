package com.test.demo.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.test.demo.test.apiDemo.Loader.CursorLoaderActivity;
import com.test.demo.test.apiDemo.RecycleView.TestRecycleViewShopActivity;
import com.test.demo.test.apiDemo.activity.TestLifeActivityA;
import com.test.demo.test.apiDemo.animation.TestAnimationActivity;
import com.test.demo.test.apiDemo.architecture.TestArchitectureActivity;
import com.test.demo.test.apiDemo.asyncTask.TestAsyncTaskActivity;
import com.test.demo.test.apiDemo.backStack.TaskActivityA;
import com.test.demo.test.apiDemo.broadcast.TestBroadcastActivity;
import com.test.demo.test.apiDemo.canvas.TestCanvasActivity;
import com.test.demo.test.apiDemo.commonIntents.CommonIntentActivity;
import com.test.demo.test.apiDemo.customComponent.demo.CustomCompoundControls;
import com.test.demo.test.apiDemo.customComponent.demo.CustomImageViewActivity;
import com.test.demo.test.apiDemo.customComponent.demo.TestTextViewActivity;
import com.test.demo.test.apiDemo.customComponent.drawTextOnPath.DrawTextOnPathActivity;
import com.test.demo.test.apiDemo.dragAndDrop.TestDragActivity;
import com.test.demo.test.apiDemo.fragments.MyFragmentActivity;
import com.test.demo.test.apiDemo.frame.TestFrameActivity;
import com.test.demo.test.apiDemo.handler.TestHandlerActivity;
import com.test.demo.test.apiDemo.handlerThread.TestHandleThreadActivity;
import com.test.demo.test.apiDemo.listview.TestListViewActivity;
import com.test.demo.test.apiDemo.matrix.TestMatrixActivity;
import com.test.demo.test.apiDemo.media.TestMediaPlayerActivity;
import com.test.demo.test.apiDemo.notification.TestNotificationActivity;
import com.test.demo.test.apiDemo.notification.regularActivity.TestNotification2Activity;
import com.test.demo.test.apiDemo.path.TestPathActivity;
import com.test.demo.test.apiDemo.remoteViews.TestRemoteViewsActivity;
import com.test.demo.test.apiDemo.search.searchDialog.SearchableActivity;
import com.test.demo.test.apiDemo.search.searchWidget.SearchViewActivity;
import com.test.demo.test.apiDemo.search.searchWidget.SearchViewMenuActivity;
import com.test.demo.test.apiDemo.service.aidl.demo_1.TestAIDLActivity;
import com.test.demo.test.apiDemo.service.aidl.demo_2.TestBookActivity;
import com.test.demo.test.apiDemo.service.foregroundService.ForegroundServiceActivity;
import com.test.demo.test.apiDemo.service.handlerService.IntentServiceActivity;
import com.test.demo.test.apiDemo.service.messager.BindServiceMessageActivity;
import com.test.demo.test.retrofit.TestRetrofitActivity;
import com.test.demo.test.apiDemo.thread.TestThreadActivity;
import com.test.demo.test.apiDemo.toast.ToastActivity;
import com.test.demo.test.apiDemo.viewTouch.TestViewGroupTouchActivity;
import com.test.demo.test.apiDemo.viewpager.TestViewPagerActivity;
import com.test.demo.test.comment.TestCommentActivity;
import com.test.demo.test.design_pattern.TestDesignPatternActivity;
import com.test.demo.test.eventBus.TestEventBusActivity;
import com.test.demo.test.glide.TestCustomGlideActivity;
import com.test.demo.test.glide.TestGlideActivity;
import com.test.demo.test.scrollerConflict.TestScrollerConflictActivity;
import com.test.demo.test.threadLocal.TestThreadLocalActivity;
import com.test.demo.test.utils.IntentUtils;
import com.test.demo.test.volley.VolleyActivity;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    public final static String ACTIVITY_LIFE = "com.test.demo.test=====";

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_LIFE,"MainActivity======onCreate=======");
        imageView = (ImageView) findViewById(R.id.imageView);

        //------------------隐示意图--------------
//        //打电话
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if(MainActivity.this.checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
//            }
//        }
//        Uri call = Uri.parse("tel:15101619117");
//        Intent callIntent = new Intent(Intent.ACTION_CALL,call);
//        MainActivity.this.startActivity(callIntent);
//        //打开一个网页
//        Uri webpage = Uri.parse("http://www.baidu.com");
//        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
//        MainActivity.this.startActivity(webIntent);
        //View a map
        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        // Or map point based on latitude/longitude
        // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
//        MainActivity.this.startActivity(mapIntent);
//        //创建日历事件
//        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
//        Calendar beginTime = Calendar.getInstance();
//        beginTime.set(2012, 0, 19, 7, 30);
//        Calendar endTime = Calendar.getInstance();
//        beginTime.set(2012, 0, 19, 10, 30);
//        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
//        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
//        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
//        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
//
//
//
//        MainActivity.this.startActivity(calendarIntent);
//        Intent intent = new Intent(Intent.ACTION_VIEW);

//        String title = getResources().getString(R.string.chooser_title);
        Intent chooser = Intent.createChooser(mapIntent, "share this video");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
//              startActivity(chooser);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.i(ACTIVITY_LIFE,"MainActivity======onRestoreInstanceState=======");
        if(savedInstanceState != null){
            String outState = savedInstanceState.getString("outState");
            Log.i(ACTIVITY_LIFE,"MainActivity======onRestoreInstanceState=======" + outState);
        }
    }

    /**
     * Called when the user clicks the Send button
     * @param view
     */
    public void sendMessage(View view) {

        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_LIFE,"MainActivity======onStart=======");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_LIFE,"MainActivity======onResume=======");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_LIFE,"MainActivity======onPause=======");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_LIFE,"MainActivity======onStop=======");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(ACTIVITY_LIFE,"MainActivity======onRestart=======");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_LIFE,"MainActivity======onDestroy=======");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(ACTIVITY_LIFE,"MainActivity======onSaveInstanceState=======");
        outState.putString("outState","123");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void shareFile(View view) {

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/jpg");
        startActivityForResult(intent,0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){

            Uri fileUri = data.getData();
            try {

                ParcelFileDescriptor pfd = getContentResolver().openFileDescriptor(fileUri,"r");
                FileDescriptor fileDescriptor = pfd.getFileDescriptor();
                Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void recordVideo(View view) {

        Intent intent = new Intent(this,RecordVideoActivity.class);
        startActivity(intent);

    }

    public void doPhotoPrint(View view) {
        PrintHelper photoPrinter = new PrintHelper(MainActivity.this);
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher_background);
        photoPrinter.printBitmap("droids.jpg - test print", bitmap);
    }

    public void loadingLargeBitmap(View view) {

        Intent intent = new Intent(this,LoadLargeBitmapActivity.class);
        startActivity(intent);

    }

    public void openglDisplay(View view) {

        Intent intent = new Intent(this,OpenGLActivity.class);
        startActivity(intent);

    }

    public void transitionFramework(View view) {
        Intent intent = new Intent(this,TransitionFrameworkActivity.class);
        startActivity(intent);
    }

    public void crossfade(View view) {
        Intent intent = new Intent(this,CrossfadeActivity.class);
        startActivity(intent);
    }
    public void screenSlidePager(View view) {
        Intent intent = new Intent(this,ScreenSlidePagerActivity.class);
        startActivity(intent);
    }
    public void customTransition(View view) {
        Intent intent = new Intent(this,CustomTransitionActivity.class);
        startActivity(intent);
    }

    public void cardFlip(View view) {
        Intent intent = new Intent(this,CardFlipActivity.class);
        startActivity(intent);
    }
    public void zoomView(View view) {
        Intent intent = new Intent(this,ZoomViewActivity.class);
        startActivity(intent);
    }

    public void discoverServices(View view) {
        Intent intent = new Intent(this,DiscoverServicesActivity.class);
        startActivity(intent);
    }
    public void registerNsdService(View view) {
        Intent intent = new Intent(this,RegisterNsdServiceActivity.class);
        startActivity(intent);
    }
    public void creatingWifiP2PConnection(View view) {
        Intent intent = new Intent(this,CreatingWifiP2PConnectionActivity.class);
        startActivity(intent);
    }
    public void volley(View view) {
        Intent intent = new Intent(this,VolleyActivity.class);
        startActivity(intent);
    }
    public void contacts(View view) {
        Intent intent = new Intent(this,ContactsActivity.class);
        startActivity(intent);
    }
    public void notification(View view) {
        Intent intent = new Intent(this,NotificationActivity.class);
        startActivity(intent);
    }

    public void dimStatusBar(View view) {
        Intent intent = new Intent(this,DimStatusBarActivity.class);
        startActivity(intent);
    }
    public void customAnimation(View view) {
        Intent intent = new Intent(this,CustomAnimationActivity.class);
        startActivity(intent);
    }
    public void commonIntent(View view) {
        Intent intent = new Intent(this,CommonIntentActivity.class);
        startActivity(intent);
    }
    public void myFragment(View view) {
        Intent intent = new Intent(this,MyFragmentActivity.class);
        startActivity(intent);
    }
    public void cursorLoader(View view) {
        Intent intent = new Intent(this,CursorLoaderActivity.class);
        startActivity(intent);
    }
    public void taskModel(View view) {
        Toast.makeText(this,"MainActivity====getTaskId===" + getTaskId(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,TaskActivityA.class);
        startActivity(intent);
    }

    public void taskModel1(View view) {

        Intent intent = new Intent("com.test.demo.test.apiDemo.backStack");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent intent1 = Intent.createChooser(intent,"测试选择");

        startActivity(intent1);

    }
    public void bindService(View view) {

        Intent intent = new Intent(this,BindServiceMessageActivity.class);
        startActivity(intent);

    }
    public void testAIDL(View view) {

        Intent intent = new Intent(this,TestAIDLActivity.class);
        startActivity(intent);

    }
    public void testBook(View view) {

        Intent intent = new Intent(this,TestBookActivity.class);
        startActivity(intent);

    }
    public void handlerService(View view) {

        Intent intent = new Intent(this,IntentServiceActivity.class);
        startActivity(intent);

    }
    public void foregroundService(View view) {

        Intent intent = new Intent(this,ForegroundServiceActivity.class);
        startActivity(intent);

    }
    public void testThread(View view) {

        Intent intent = new Intent(this,TestThreadActivity.class);
        startActivity(intent);

    }
    public void testNotification(View view) {

        Intent intent = new Intent(this,TestNotificationActivity.class);
        startActivity(intent);

    }
    public void testNotification2(View view) {

        Intent intent = new Intent(this,TestNotification2Activity.class);
        startActivity(intent);

    }
    public void testToast(View view) {

        Intent intent = new Intent(this,ToastActivity.class);
        startActivity(intent);

    }
    public void testSearchable(View view) {

        Intent intent = new Intent(this,SearchableActivity.class);
        startActivity(intent);

    }
    public void testSearchViewMenu(View view) {

        Intent intent = new Intent(this,SearchViewMenuActivity.class);
        startActivity(intent);

    }
    public void testSearchView(View view) {

        Intent intent = new Intent(this,SearchViewActivity.class);
        startActivity(intent);

    }
    public void testDrag(View view) {

        Intent intent = new Intent(this,TestDragActivity.class);
        startActivity(intent);

    }

    public void testRetrofit(View view) {

        IntentUtils.startActivity(this,TestRetrofitActivity.class);

    }

    public void drawTextOnPath(View view) {

        IntentUtils.startActivity(this,DrawTextOnPathActivity.class);

    }
    public void customImageView(View view) {

        IntentUtils.startActivity(this,CustomImageViewActivity.class);

    }
    public void customCompoundControls(View view) {

        IntentUtils.startActivity(this,CustomCompoundControls.class);

    }
    public void testTextView(View view) {

        IntentUtils.startActivity(this,TestTextViewActivity.class);

    }


    public void testDesignPattern(View view) {
        IntentUtils.startActivity(this,TestDesignPatternActivity.class);
    }

    public void testAnimation(View view) {
        IntentUtils.startActivity(this,TestAnimationActivity.class);
    }
    public void testComment(View view) {
        IntentUtils.startActivity(this,TestCommentActivity.class);
    }

    public void testCanvas(View view) {
        IntentUtils.startActivity(this,TestCanvasActivity.class);
    }
    public void testPath(View view) {
        IntentUtils.startActivity(this,TestPathActivity.class);
    }

    public void testMediaPlayer(View view) {
        IntentUtils.startActivity(this,TestMediaPlayerActivity.class);
    }

    public void testActivityLife(View view) {
        IntentUtils.startActivity(this,TestLifeActivityA.class);
    }

    public void testViewPager(View view) {
        IntentUtils.startActivity(this,TestViewPagerActivity.class);
    }
    public void testHandleThread(View view) {
        IntentUtils.startActivity(this,TestHandleThreadActivity.class);
    }
    public void testBroadcast(View view) {
        IntentUtils.startActivity(this,TestBroadcastActivity.class);
    }
    public void testHandler(View view) {
        IntentUtils.startActivity(this,TestHandlerActivity.class);
    }
    public void testAsyncTask(View view) {
        IntentUtils.startActivity(this,TestAsyncTaskActivity.class);
    }
    public void testViewGroupTouch(View view) {
        IntentUtils.startActivity(this,TestViewGroupTouchActivity.class);
    }
    public void testMatrix(View view) {
        IntentUtils.startActivity(this,TestMatrixActivity.class);
    }
    public void testListView(View view) {
        IntentUtils.startActivity(this,TestListViewActivity.class);
    }
    public void testRecycleViewShop(View view) {
        IntentUtils.startActivity(this,TestRecycleViewShopActivity.class);
    }
    public void testArchitecture(View view) {
        IntentUtils.startActivity(this,TestArchitectureActivity.class);
    }

    public void testFrame(View view) {
        IntentUtils.startActivity(this,TestFrameActivity.class);
    }

    public void testRemoteViews(View view) {
        IntentUtils.startActivity(this,TestRemoteViewsActivity.class);
    }

    public void TestKotlinCustomViews(View view) {
        IntentUtils.startActivity(this,TestKotlinCustomViewActivity.class);
    }

    public void TestPluginViews(View view) {

        Intent intent = new Intent(MainActivity.this,TestPluginViewActivity.class);
        MainActivity.this.startActivity(intent);



    }

    public void testEventBusMessage(View view) {

        Intent intent = new Intent(MainActivity.this,TestEventBusActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void testThreadLocal(View view) {

        Intent intent = new Intent(MainActivity.this,TestThreadLocalActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void testCustomGlide(View view) {

        Intent intent = new Intent(MainActivity.this,TestCustomGlideActivity.class);
        MainActivity.this.startActivity(intent);

    }
    public void testGlide(View view) {

        Intent intent = new Intent(MainActivity.this,TestGlideActivity.class);
        MainActivity.this.startActivity(intent);

    }

    public void testUpdate(View view) {

        Intent intent = new Intent(MainActivity.this,TestUpdateActivity.class);
        MainActivity.this.startActivity(intent);

    }

    public void testScrollerConflict(View view) {

        Intent intent = new Intent(MainActivity.this,TestScrollerConflictActivity.class);
        MainActivity.this.startActivity(intent);

    }

}

