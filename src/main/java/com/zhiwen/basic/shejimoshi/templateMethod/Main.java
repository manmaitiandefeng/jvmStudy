package com.zhiwen.basic.shejimoshi.templateMethod;

/**
 * <p>模板方法模式（Template Method Pattern）是一种行为设计模式，它定义了一个操作中的算法框架，将某些步骤延迟到子类中实现。通过这种方式，可以在不改变算法结构的情况下，允许子类重写算法的特定步骤。
 *
 * 主要角色：
 * 抽象类（Abstract Class）：定义了一个模板方法，其中包含了算法的基本步骤，其中一些步骤由子类实现。抽象类可以包含具体方法、抽象方法或钩子方法。
 *
 * 具体类（Concrete Class）：实现了抽象类中定义的抽象方法，以完成算法的具体步骤。在具体类中，可以重写抽象方法，但不会改变算法的结构。
 *
 * 使用场景：
 * 当算法的整体步骤固定，但其中部分步骤具有多种实现方式时，可以考虑使用模板方法模式。
 * 当避免代码重复，将相同的代码抽取到一个公共的方法中时，可以使用模板方法模式。
 * 当需要子类通过扩展来改变算法的某些特定步骤时，可以使用模板方法模式。</p>
 * @author zhiwen
 * @since 2024/2/20 10:55 上午
 */
public class Main {

    //假设我们要实现一个制作饮料的流程，其中包括泡茶和泡咖啡两种饮料的制作方法。制作饮料的流程包括烧水、冲泡、倒入杯中等步骤，但是具体的冲泡方式不同，泡茶是泡茶叶，而泡咖啡是冲泡咖啡粉。
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.makeBeverage(); // 制作茶

        System.out.println("-----------------------");

        Beverage coffee = new Coffee();
        coffee.makeBeverage(); // 制作咖啡
    }
}

abstract class Beverage {
    // 模板方法，定义了饮料的制作流程
    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // 具体步骤
    private void boilWater() {
        System.out.println("Boiling water");
    }

    // 具体步骤，由子类实现
    abstract void brew();

    // 具体步骤
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 钩子方法，子类可以选择性地覆盖它来控制算法的某些步骤
    boolean customerWantsCondiments() {
        return true;
    }

    // 具体步骤，由子类实现
    abstract void addCondiments();
}



class Tea extends Beverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }

    // 重写钩子方法，控制是否添加调料
    @Override
    boolean customerWantsCondiments() {
        return false;
    }
}

class Coffee extends Beverage {
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
