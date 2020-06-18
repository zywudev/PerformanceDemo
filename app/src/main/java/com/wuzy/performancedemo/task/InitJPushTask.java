package com.wuzy.performancedemo.task;

import android.util.Log;

import com.wuzy.performancedemo.launchstarter.task.Task;

import java.util.ArrayList;
import java.util.List;

public class InitJPushTask extends Task {

    private static final String TAG = "InitJPushTask";

    @Override
    public List<Class<? extends Task>> dependsOn() {
        List<Class<? extends Task>> tasks = new ArrayList<>();
        tasks.add(InitShareTask.class);
        return tasks;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
            Log.e(TAG, "InitJPushTask运行完毕，它所在的线程是：" + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
