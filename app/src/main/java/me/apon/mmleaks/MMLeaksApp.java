package me.apon.mmleaks;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by yaopeng(aponone@gmail.com) on 2018/3/18.
 */

public class MMLeaksApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
