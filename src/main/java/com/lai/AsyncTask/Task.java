package com.lai.AsyncTask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by lailai on 2017/9/20.
 * 异步实现类
 * @Async所修饰的函数不要定义为static类型 这样异步调用不会生效
 */
@Component
public class Task {
    public static Random random=new Random();

    @Async
    public Future<String> doTaskOne() throws Exception{
        System.out.println("开始做任务一");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("完成任务一，耗时："+(end-start)+"毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwo() throws Exception{
        System.out.println("开始做任务二");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("完成任务二，耗时："+(end-start)+"毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception{
        System.out.println("开始做任务三");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("完成任务三，耗时："+(end-start)+"毫秒");
        return new AsyncResult<>("任务三完成");
    }
}
