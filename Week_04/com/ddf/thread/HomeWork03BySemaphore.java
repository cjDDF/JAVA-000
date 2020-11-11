package com.ddf.thread;

import java.util.concurrent.Semaphore;

public class HomeWork03BySemaphore {
    private static int result = 0;

    public static void main(String[] args){
        long start = System.currentTimeMillis();

        //异步运行
        Semaphore semaphore = new Semaphore(1);
        new Thread(() -> {
            try {
                semaphore.acquire();
                result=sum();
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //获取返回值

        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("异步计算结果为：" + result);
                System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
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
