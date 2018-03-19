package me.apon.mmleaks.staticvariables;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import me.apon.mmleaks.R;

/**
 * 静态变量activity直接持有SVActivityOne实例导致内存泄漏
 * Created by yaopeng(aponone@gmail.com) on 2018/3/18.
 */

public class SVActivityOne extends AppCompatActivity {

    static Activity activity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("静态变量activity直接持有SVActivityOne实例导致内存泄漏");
        /////////////////////////////////////////////////////////////////////
        if (activity==null){
            activity = this;
        }
    }
}
