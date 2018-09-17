package com.armeng.java.advanced.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * @author xiaoming.kang
 * @date 2018/09/17.
 */
public class ThreadStudy {

    //1.继承Thread类
    static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println("继承Thread的创建方式，当前线程："+currentThread().getName());
        }
    }

    //2.实现Runnable接口
    static class MyThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("实现Runnable接口的创建方式，当前线程：" + Thread.currentThread().getName());
        }
    }

    //3.实现Callable接口
    static class MyThread3 implements Callable {

        @Override
        public Object call() throws Exception {
            System.out.println("实现Callable接口的创建方式，当前线程：" + Thread.currentThread().getName());
            return "创建成功";
        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        MyThread3 myThread3 = new MyThread3();

        myThread1.run();  //普通调用
        myThread2.run();  //普通调用
        try {
            Object rst = myThread3.call();  //普通调用
        } catch (Exception e) {
            e.printStackTrace();
        }
        myThread1.start();  //线程启动
        new Thread(myThread2).start();  //线程启动
        FutureTask<String> ft = new FutureTask<>(myThread3);
        new Thread(ft).start();  //线程启动
        try {
            String rst = ft.get();  //等待结果并且获取返回值
            System.out.println(rst);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


/*    1.创建线程的三种方式中，都需要重写run()或call()方法，这个是线程的执行体，即我们的线程需要执行的代码逻辑。
      2.我们new了一个MyThread1(或 MyThread2、MyThread3)后，可以直接调用run()/call()方法，并且里面的代码逻辑正常执行，但是，从结果看，执行的线程还是main线程，我们需要使用Thread.start()方法来启动我们创建的线程，每个线程缺省name都是Thread-n这样的样式。
      3.Runnable需要作为Thread的target来创建一个新的Thread去启动线程。Callable需要用FutureTask类对Callable进行包装(FutureTask实现了Runnable接口)，并把FutureTask类作为Thread的target来进行启动。
      4.Callable接口带有返回值，并且可以通过FutureTask获取执行结果或者接收捕获执行的异常。*/
}
