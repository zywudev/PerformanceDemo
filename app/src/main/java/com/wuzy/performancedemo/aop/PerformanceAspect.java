package com.wuzy.performancedemo.aop;


import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceAspect {
    private static final String TAG = "PerformanceAspect";

//    @Around("call(* com.wuzy.performancedemo.MyApplication.**(..))")
//    public void getTime(ProceedingJoinPoint joinPoint) {
//        long startTime = System.currentTimeMillis();
//        String methodName = joinPoint.getSignature().getName();
//        try {
//            joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        Log.e(TAG, methodName + "方法耗时：" + (System.currentTimeMillis() - startTime));
//    }

}
