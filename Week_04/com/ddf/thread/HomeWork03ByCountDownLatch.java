package com.ddf.thread;

import java.util.concurrent.*;

public class HomeWork03ByCountDownLatch {
    private static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        //异步运行
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            result=sum();
            countDownLatch.countDown();
        }).start();
        //获取返回值
        countDownLatch.await();

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
