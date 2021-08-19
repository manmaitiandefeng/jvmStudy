package com.zhiwen.jvm.classLoader;

/**
 * @author zhiwen
 */
public class TestDynamicLoad {

    static {

        System.out.println("load TestDynamicLoad -----");
    }

    public static void main(String[] args) {
        System.out.println("111");
        A a = new A();
        a.setName("Aname");
        a.print();

    }
}

class A {
    static {
        System.out.println("load class a");
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("打印A："+name);

    }
    public A() {
        System.out.println("instance A");
    }
}

class B {
    static {
        System.out.println("load class a");
    }

    public B() {
        System.out.println("instance A");
    }
}
