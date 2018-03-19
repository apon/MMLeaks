package me.apon.mmleaks.longtask;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import me.apon.mmleaks.R;

/**
 * 跟LTActivityTwo的情况类似
 * Created by yaopeng(aponone@gmail.com) on 2018/3/18.
 */

public class LTActivityThree extends AppCompatActivity {
    private final Handler mLeakyHandler = new Handler();
    private final MyRunnable myRunnable = new MyRunnable();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("匿名内部类引用导致内存泄漏");
        ////////////////////////
//        mLeakyHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("LTActivityTwo", "in run()");
//            }
//        }, 1000 * 60 * 10);
        mLeakyHandler.postDelayed(myRunnable, 1000 * 60 * 10);
    }
    //替换成静态内部类
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            Log.e("FRANK", "in run()");
        }
    }
}
