package com.ddf.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Homework03ByFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        //异步运行
        FutureTask<Integer> futureTask = new FutureTask<>(Homework03ByFutureTask::sum);
        new Thread(futureTask).start();
        //获取返回值
        int result = futureTask.get();

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
