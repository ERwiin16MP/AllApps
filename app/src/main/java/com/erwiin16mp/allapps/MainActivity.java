package com.erwiin16mp.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager manager = getPackageManager();
        List<ApplicationInfo> list = manager.getInstalledApplications(PackageManager.GET_META_DATA);
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ApplicationInfo packageInfo : list) {
            Log.e("PACK Installed package", packageInfo.packageName);
            Log.e("PACK Source dir", packageInfo.sourceDir);
            Log.e("PACK Launch Activity", String.valueOf(manager.getLaunchIntentForPackage(packageInfo.packageName)));
            Log.e("PACK ", "-------------------------------------------------------------------");
        }
    }
}