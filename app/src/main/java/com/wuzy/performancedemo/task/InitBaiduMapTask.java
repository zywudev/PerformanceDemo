package com.wuzy.performancedemo.task;

import android.util.Log;

import com.wuzy.performancedemo.launchstarter.task.Task;

public class InitBaiduMapTask extends Task {

    private static final String TAG = "InitBaiduMapTask";


    @Override
    public boolean needWait() {
        return true;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            Log.e(TAG, "InitBaiduMapTask运行完毕，它所在的线程是：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
