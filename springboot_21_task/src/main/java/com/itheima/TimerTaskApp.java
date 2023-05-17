package com.itheima;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 原理：就是启一个多线程，去执行任务
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task run ....");
            }
        };
        // delay：什么时间执行这个schedule，period：间隔多久执行一次
        timer.schedule(task, 0, 2000);
    }
}
