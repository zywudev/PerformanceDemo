package com.wuzy.performancedemo.launchstarter;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;

import com.wuzy.performancedemo.launchstarter.task.DispatchRunnable;
import com.wuzy.performancedemo.launchstarter.task.Task;

import java.util.LinkedList;
import java.util.Queue;

public class IdleTaskDispatcher {

    private static final String TAG = "IdleTaskDispatcher";

    private Queue<Task> mIdleQueue = new LinkedList<>();

    private MessageQueue.IdleHandler idleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {

            Log.e(TAG, "mIdleQueue size: " + mIdleQueue.size() );
            if (mIdleQueue.size() > 0) {
                Task idleTask = mIdleQueue.poll();
                new DispatchRunnable(idleTask).run();
            }

            // 如果返回false，则移除该 IdleHandler
            return !mIdleQueue.isEmpty();
        }
    };

    public IdleTaskDispatcher addTask(Task task) {
        mIdleQueue.add(task);
        return this;
    }


    /**
     * 执行空闲方法，因为用了DispatchRunnable，所以会优先处理需要依赖的task，再处理本次需要处理的task，顺序执行
     * */
    public void start() {
        Looper.myQueue().addIdleHandler(idleHandler);
    }

}
