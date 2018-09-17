package com.armeng.java.advanced.thread.status;

/**
 * @author xiaoming.kang
 * @date 2018/09/17.
 */
public class StatusTransition {

    private static final Object sLockObject = new Object();

    /**
     * wait and notify
     */
    public static void waitAndNotifyAll() {
        System.out.println("主线程运行");
        Thread thread = new WaitThread();
        thread.start();
        long startTime = System.currentTimeMillis();
        try {
            synchronized (sLockObject) {
                System.out.println("主线程等待");
                sLockObject.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timeMs = System.currentTimeMillis() - startTime;
        System.out.println("等待耗时：" + timeMs);
    }

    static class WaitThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("子线程正在运行... " + Thread.currentThread().getName());
            synchronized (sLockObject) {
                try {
                    Thread.sleep(3000);
                    sLockObject.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * join()
     * 阻塞当前调用join函数时所在的线程
     * 直到接收到线程执行完毕之后再继续
     */
    public static void initJoin() {
        WaitThread waitThread1 = new WaitThread();
        WaitThread waitThread2 = new WaitThread();

        waitThread1.start();
        System.out.println("启动线程1");
        try {
            // 调用waitThread1线程的join函数，主线程会阻塞到waitThread1执行完成
            waitThread1.join();
            System.out.println("启动线程2");
            waitThread2.start();
            // 调用waitThread2线程的join函数，主线程会阻塞到waitThread2执行完成
            waitThread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程继续执行");
    }


    public static void main(String[] args) {

        //waitAndNotifyAll();

        initJoin();

    }

}
