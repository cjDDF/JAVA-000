package com.ddf.thread;

public class HomeWork03ByYield {
    private static int result;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Object obj = new Object();

        //异步运行
        new Thread(() -> {
            result = sum();
        }).start();
        //获取返回值
        while (result == 0) {
            Thread.yield();
        }
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
