package com.wuzy.performancedemo.task;

import android.util.Log;

import com.wuzy.performancedemo.launchstarter.task.Task;

public class InitShareTask extends Task {
    private static final String TAG = "InitShareTask";
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            Log.e(TAG, "InitShareTask运行完毕，它所在的线程是："+Thread.currentThread().getName() );
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
