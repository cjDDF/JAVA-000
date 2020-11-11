package com.ddf.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HomeWork03ByCondition {
    private static int result;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        //异步运行
        new Thread(() -> {
            lock.lock();
            try {
                result = sum();
                condition.signal();
            } finally {
                lock.unlock();
            }

        }).start();
        //获取返回值
        lock.lock();
        try {
            condition.await();
            System.out.println("异步计算结果为：" + result);
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        }finally {
            lock.unlock();
        }

    }

    private void setResult() {

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
