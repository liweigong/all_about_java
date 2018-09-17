package com.armeng.java.basic.grammar.initorder;

/**
 * @author xiaoming.kang
 * @date 2018/09/17.
 */
public class Parent {

    public Parent(){
        System.out.println("Parent的构造方法");
    }
    {
        System.out.println("Parent的构造代码块");
    }
    static{
        System.out.println("Parent的静态代码块");
    }

}
