package com.hui;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;

/**
 * @Author dmh
 * @Date 2023/11/8 15:43
 * @Version 1.0
 * @introduce
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3,    //线程数
                5,      //最大线程数
                1L,        //保持存活时间
                TimeUnit.SECONDS,       //时间单位秒
                new ArrayBlockingQueue<>(3),   //等待队列长度
                Executors.defaultThreadFactory(),      //默认的线程工厂
                new ThreadPoolExecutor.AbortPolicy()); //异常策略

        int n = 5;    //办理业务人数，任务数
        for (int i = 0; i < n; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + "==>办理业务");
            });
        }
        executorService.shutdown();
    }
}
