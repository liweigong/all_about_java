package com.armeng.java.advanced.thread.status;

/**
 * @author xiaoming.kang
 * @date 2018/09/17.
 */
public class InterruptReset extends Object{

    /**
     * Thread.interrupted() 这个静态方法，会有自动重置interrupted状态的机制.
     *
     */

    public static void main(String[] args) {
        System.out.println(
                "Point X: Thread.interrupted()=" + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(
                "Point Y: Thread.interrupted()=" + Thread.interrupted());
        System.out.println(
                "Point Z: Thread.interrupted()=" + Thread.interrupted());
    }

}

