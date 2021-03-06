package me.apon.mmleaks.longtask;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import me.apon.mmleaks.R;

/**
 * 长时间运行的MyThread持有LTActivityOne实例的引用导致内存泄漏
 * 非静态匿名类持有对其封闭类的引用
 * Created by yaopeng(aponone@gmail.com) on 2018/3/18.
 */

public class LTActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("长时间运行的MyThread持有LTActivityOne实例的引用导致内存泄漏");
        ////////////////////////
        new MyThread().start();
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(1000);
            }
        }
    }
}
