package com.yhx.base.lambda;

import com.yhx.base.functionalInterface.FunctionalInterfaceMain;
import com.yhx.base.functionalInterface.ParamInterface;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * lambda 表达式语法：（paramType paramName） ->{ ......}.
 * <p>
 * 1.lambda 表达式可以实现任何接只有一个需要实现方法的接口。多个实现方法使用lambda时，编译异常
 * 2.lambda 目标对象（实现类）必须是接口
 * 3. jdk 提供幾個內部接口 以便常規開發使用：
 *
 *
 */
public abstract class Main {

    abstract void t();

    public static void main(String[] args) throws Exception {
        //example2Runnable();
        //exampleInterface();
        //paramInterface();
        functionMethod();
        System.out.println("done");


    }

    //这里以runnable 接口为例
    static void example2Runnable() throws Exception {

        //1. 匿名内部类
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                //do something
                System.out.println("匿名内部类调用方法");
            }
        });

        Thread tLambda = new Thread(() -> {
            //do something
            System.out.println("lambda表达式调用");
        });

        t.start();
        tLambda.start();
        t.join();
        tLambda.join();
    }

    //这里以functionInterface 接口为例
    static void exampleInterface() {

        FunctionalInterfaceMain fim = () -> {
            System.out.println("通过 lamada表达式实现接口抽象方法");
        };

        fim.test();

        //内部匿名类
        FunctionalInterfaceMain fim2 = new FunctionalInterfaceMain() {
            @Override
            public void test() {
                System.out.println("通过内部匿名类表达式实现接口抽象方法");
            }
        };
    }


    static void paramInterface() {

        ParamInterface pi = new ParamInterface() {
            @Override
            public String hello(String name) {
                return "hello " + name;
            }
//
//            @Override
//            public String hello2(String name) {
//                return "hello2 "+name;
//            }
        };

        ParamInterface pi2 = (String name) -> {
            return "hello lamabd " + name;
        };

        System.out.println("pi result:" + pi.hello("yhx"));
        System.out.println("pi2 result:" + pi2.hello("yhx"));
    }

    //jdk 提供 function<paramType,returnType> 接口
    static void functionMethod() {

        Function<String, Integer> fc = (String num) -> {
            System.out.println("lambda string" + num + " convert int");
            return Integer.valueOf(num);
        };

        Predicate<Integer> predicate=(Integer i)->{

            System.out.println("lambda Predicate i=" + i + "  Predicate");
            return i>0;
        };

        System.out.println("predicate "+predicate.test(10));
        System.out.println(fc.apply("1234"));
    }
}
