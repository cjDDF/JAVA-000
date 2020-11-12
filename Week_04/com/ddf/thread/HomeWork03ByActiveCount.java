package com.ddf.thread;

public class HomeWork03ByActiveCount {
    private static int result;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        //异步运行
        new Thread(() -> result=sum()).start();
        //获取返回值
        while (Thread.activeCount() > 2) {

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
