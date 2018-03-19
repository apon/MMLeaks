package me.apon.mmleaks.staticvariables;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import me.apon.mmleaks.R;

/**
 * Singleton类的静态变量instantiation间接持有SVActivityFour实例导致内存泄漏
 * Created by yaopeng(aponone@gmail.com) on 2018/3/18.
 */

public class SVActivityFour extends AppCompatActivity {
    Singleton singleton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("Singleton类的静态变量instantiation间接持有SVActivityFour实例导致内存泄漏");
        /////////////////////////////////////////////////////////////////////
        singleton = Singleton.getInstance(this);
    }
}
