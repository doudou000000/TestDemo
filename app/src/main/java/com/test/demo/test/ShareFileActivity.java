package com.test.demo.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.List;

/**
 * Created by DEV002 on 2018/5/18.
 */

public class ShareFileActivity extends AppCompatActivity{

    ListView mFileListView;
    // The path to the root of this app's internal storage
    private File mPrivateRootDir;
    // The path to the "images" subdirectory
    private File mImagesDir;
    // Array of files in the images subdirectory
    File[] mImageFiles;
    // Array of filenames corresponding to mImageFiles
    String[] mImageFilenames;
    // Initialize the Activity
    private Intent mResultIntent;

    private Uri fileUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_file);
        mFileListView = (ListView) findViewById(R.id.share_file_list_view);

        mResultIntent =
                new Intent("com.example.myapp.ACTION_RETURN_FILE");
        // Get the files/ subdirectory of internal storage
        mPrivateRootDir = getExternalFilesDir("");
        // Get the files/images subdirectory;
        mImagesDir = new File(mPrivateRootDir, "images");
        // Get the files in the images subdirectory
        mImageFiles = mImagesDir.listFiles();
        // Set the Activity's result to null to begin with
        setResult(Activity.RESULT_CANCELED, null);
        mImageFilenames = new String[mImageFiles.length];
        for (int i = 0; i < mImageFiles.length; i++){
            mImageFilenames[i] = mImageFiles[i].getAbsolutePath();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ShareFileActivity.this,R.layout.activity_share_file_item,R.id.share_file_item_tv,mImageFilenames);
        mFileListView.setAdapter(arrayAdapter);
        mFileListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView,
                                            View view,
                                            int position,
                                            long rowId) {
                        File requestFile = new File(mImageFilenames[position]);
                        try {
                            fileUri = FileProvider.getUriForFile(
                                    ShareFileActivity.this,
                                    "com.test.demo.test.fileprovider",
                                    requestFile);
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }

                        if (fileUri != null) {
                            // Grant temporary read permission to the content URI
                            mResultIntent.addFlags(
                                    Intent.FLAG_GRANT_READ_URI_PERMISSION);
                            mResultIntent.setDataAndType(
                                    fileUri,
                                    getContentResolver().getType(fileUri));
                            // Set the result
                            ShareFileActivity.this.setResult(Activity.RESULT_OK,
                                    mResultIntent);
                        } else {
                            mResultIntent.setDataAndType(null, "");
                            ShareFileActivity.this.setResult(RESULT_CANCELED,
                                    mResultIntent);
                        }
                        finish();
                    }
                });
    }
}
