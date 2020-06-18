package com.wuzy.performancedemo;

import android.app.Application;
import android.os.Debug;
import android.util.Log;

import com.wuzy.performancedemo.launchstarter.TaskDispatcher;
import com.wuzy.performancedemo.task.InitBaiduMapTask;
import com.wuzy.performancedemo.task.InitBuglyTask;
import com.wuzy.performancedemo.task.InitJPushTask;
import com.wuzy.performancedemo.task.InitShareTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    // 获得当前CPU的核心数
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    // 设置线程池的核心线程数2-4之间,但是取决于CPU核数
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));

    @Override
    public void onCreate() {
        super.onCreate();
//        Debug.startMethodTracing();

//        // 常规方式
//        final CountDownLatch latch = new CountDownLatch(1);
//        ExecutorService executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
//
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                initBugly();
//                latch.countDown();
//            }
//        });
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                initBaiduMap();
//            }
//        });
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                initJPushInterface();
//            }
//        });
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                initShareSDK();
//            }
//        });
//
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Debug.stopMethodTracing();

        Log.e(TAG, "onCreate: MyApplication开始执行" );
        TaskDispatcher.init(this);
        TaskDispatcher instance = TaskDispatcher.createInstance();
        instance.addTask(new InitBuglyTask()) // 默认添加，并发处理
                .addTask(new InitBaiduMapTask())  // 在这里需要先处理了另外一个耗时任务initShareSDK，才能再处理它
                .addTask(new InitJPushTask())  // 等待主线程处理完毕，再进行执行
                .addTask(new InitShareTask())
                .start();
        instance.await();

        Log.e(TAG, "onCreate: MyApplication执行完毕");

    }

    private void initBugly() {
        try {
            Thread.sleep(1000); // 模拟耗费的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initBaiduMap() {
        try {
            Thread.sleep(2000); // 模拟耗费的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initJPushInterface() {
        try {
            Thread.sleep(3000); // 模拟耗费的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initShareSDK() {
        try {
            Thread.sleep(500); // 模拟耗费的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
