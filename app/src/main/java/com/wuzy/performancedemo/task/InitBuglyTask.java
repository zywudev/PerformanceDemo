package com.wuzy.performancedemo.task;

import android.util.Log;

import com.wuzy.performancedemo.launchstarter.task.Task;


public class InitBuglyTask extends Task {

    private static final String TAG = "InitBuglyTask";

    @Override
    public boolean runOnMainThread() {
        return true;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            Log.e(TAG, "InitBuglyTask运行完毕，它所在的线程是："+Thread.currentThread().getName() );
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
