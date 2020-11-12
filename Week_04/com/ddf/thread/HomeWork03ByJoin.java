package com.ddf.thread;

public class HomeWork03ByJoin {
    private int result;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        //异步运行,并获取返回值
        final HomeWork03ByJoin homeWork03ByJoin = new HomeWork03ByJoin();
        Thread thread = new Thread(homeWork03ByJoin::setResult);
        thread.start();

        thread.join();

        System.out.println("异步计算结果为：" + homeWork03ByJoin.result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private void setResult() {
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
