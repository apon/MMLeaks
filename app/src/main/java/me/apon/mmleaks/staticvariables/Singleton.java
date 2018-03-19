package me.apon.mmleaks.staticvariables;

import android.content.Context;

/**
 * Created by yaopeng(aponone@gmail.com) on 2018/3/18.
 */

public class Singleton {

    private static Singleton instantiation;
    private Context context;

    private Singleton(Context context) {
        this.context = context;
    }

    public static synchronized Singleton getInstance(Context context) {
        if (instantiation == null) {
            instantiation = new Singleton(context);
        }
        return instantiation;
    }

    public void release(Context context) {
        if (this.context == context) {
            this.context = null;
        }
    }
}
