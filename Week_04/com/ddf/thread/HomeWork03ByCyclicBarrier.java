package com.ddf.thread;

import java.util.concurrent.CyclicBarrier;

public class HomeWork03ByCyclicBarrier {
    private static int result = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        //异步运行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1,()->{
            System.out.println("异步计算结果为：" + result);
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        });
        new Thread(() -> {
            result=sum();
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
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
