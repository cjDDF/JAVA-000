package com.ddf.thread;

public class HomeWork03BySynchronized {
    private static int result;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        //异步运行
        new Thread(HomeWork03BySynchronized::setResult).start();
        //获取返回值
        Thread.sleep(1);

        System.out.println("异步计算结果为：" + getResult());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");


    }

    public synchronized static int getResult() {
        return result;
    }

    public synchronized static void setResult() {
        result = sum();
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
