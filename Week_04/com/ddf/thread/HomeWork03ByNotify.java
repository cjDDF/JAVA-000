package com.ddf.thread;

public class HomeWork03ByNotify {


    public static void main(String[] args) {
        MethodClass methodClass = new MethodClass();
        long start = System.currentTimeMillis();

        //异步运行
        new Thread(() -> {
            try {
                methodClass.getResult();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //获取返回值
        new Thread(() -> {
            try {
                methodClass.print(start);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}

class MethodClass {
    private int result;

    synchronized void print(long start) throws InterruptedException {
        if (result == 0) {
            wait();
        }
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    synchronized void getResult() throws InterruptedException {
        result = sum();
        notifyAll();
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
