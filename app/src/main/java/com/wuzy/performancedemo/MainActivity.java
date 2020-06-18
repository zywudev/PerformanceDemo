package com.wuzy.performancedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wuzy.performancedemo.launchstarter.IdleTaskDispatcher;
import com.wuzy.performancedemo.task.InitBaiduMapTask;
import com.wuzy.performancedemo.task.InitBuglyTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new IdleTaskDispatcher()
                .addTask(new InitBaiduMapTask())
                .addTask(new InitBuglyTask())
                .start();
    }
}