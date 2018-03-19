package me.apon.mmleaks.staticvariables;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * 静态变量textView间接持有SVActivityTwo实例导致内存泄漏
 * Created by yaopeng(aponone@gmail.com) on 2018/3/18.
 */

public class SVActivityTwo extends AppCompatActivity {
    static TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);

        textView.setText("静态变量textView间接持有SVActivityTwo实例导致内存泄漏");
        setContentView(textView);
    }
}
