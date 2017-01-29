package com.nickrout.filemanager;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by nicholasrout on 2017/01/29.
 */

public class MainActivity extends Activity {

    private static final String ACTION_FILE_MANAGER = "android.provider.action.BROWSE";
    private static final String PACKAGE_FILE_MANAGER = "com.android.documentsui";
    private static final String ACTIVITY_FILE_MANAGER = "com.android.documentsui.FilesActivity";
    private static final String DATA_FILE_MANAGER = "content://com.android.externalstorage.documents/root/primary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent fileManagerIntent = new Intent(ACTION_FILE_MANAGER);
        fileManagerIntent.setComponent(new ComponentName(PACKAGE_FILE_MANAGER, ACTIVITY_FILE_MANAGER));
        fileManagerIntent.setData(Uri.parse(DATA_FILE_MANAGER));
        try {
            startActivity(fileManagerIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.error_not_found, Toast.LENGTH_SHORT).show();
        }
        finish();
        super.onCreate(savedInstanceState);
    }
}
