package me.apon.mmleaks.longtask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import me.apon.mmleaks.R;

/**
 * 当我们执行了LTActivityTwo的界面时，被延迟的消息会在被处理之前存在于主线程消息队列中10分钟，
 * 而这个消息中又包含了Handler的引用，而我们创建的Handler又是一个匿名内部类的实例，其持有外部LTActivityTwo的引用，
 * 这将导致了LTActivityTwo无法回收，进行导致LTActivityTwo持有的很多资源都无法回收，从而就造成了传说中的内存泄露问题！
 * Created by yaopeng(aponone@gmail.com) on 2018/3/18.
 */

public class LTActivityTwo extends AppCompatActivity {

    private final Handler mLeakyHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.e("LTActivityTwo", "handle message");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("匿名内部类引用导致内存泄漏");
        ////////////////////////
        mLeakyHandler.sendEmptyMessageDelayed(0,1000*60*10);
    }
}
