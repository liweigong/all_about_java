package com.armeng.java.basic.grammar.initorder;

/**
 * @author xiaoming.kang
 * @date 2018/09/17.
 */
public class Child extends Parent{


    public Child(){
        System.out.println("Child的构造方法");
    }
    {
        System.out.println("Child的构造代码块");
    }
    static{
        System.out.println("Child的静态代码块");
    }
    //public static Child hB = new Child();
    public static void main(String[] args){
        new Child();//调用B的构造方法
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/ab6eb06face84c4e81ab5bc6f0f7f258?orderByHotValue=1&mutiTagIds=134_639&page=1&onlyReference=false
     来源：牛客网

     可以看出：
     a.父类始终先调用（继承先调用父类），并且这三者之间的相对顺序始终保持不变
     b.因为静态代码块在类加载时执行，所以先输出的是父类和子类的静态代码块
     c.调用B的构造方法创建对象时，构造块和构造方法会一起按顺序执行，还是父类的先调用
     */
}
