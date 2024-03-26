package com.zhiwen.basic.shejimoshi.decorator;

/**
 * <p>装饰者模式（Decorator Pattern）是一种结构型设计模式，它允许向现有对象添加新功能，同时又不改变其结构。装饰者模式通过将对象放入包装器中来实现这一目的，这个包装器类具有与原始对象相同的接口，并且通常是原始对象的子类。
 *
 * 主要角色：
 * 组件（Component）：定义了一个对象接口，可以为其添加新的功能。
 *
 * 具体组件（Concrete Component）：实现了组件接口的具体对象，是我们要装饰的对象。
 *
 * 装饰器（Decorator）：持有一个组件对象的引用，并实现了与组件接口相同的接口。这个类的存在使得我们可以在运行时动态地添加新的功能。
 *
 * 具体装饰器（Concrete Decorator）：具体的装饰器类，扩展了装饰器类的功能。
 *
 * 使用场景：
 * 当需要在不影响其他对象的情况下，动态地添加功能到对象时，可以使用装饰者模式。
 * 当需要为对象添加多个不同的功能组合时，装饰者模式提供了一种灵活的方式来实现。</p>
 * @author zhiwen
 * @since 2024/2/20 10:09 上午
 */

public class Main {
    public static void main(String[] args) {

        //假设我们有一个咖啡店，我们可以根据客户的要求定制不同的咖啡，比如加奶、加糖等。我们可以使用装饰者模式来动态地添加这些额外的功能。

        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Description: " + simpleCoffee.getDescription() + ", Cost: $" + simpleCoffee.cost());

        Coffee milkCoffee = new Milk(simpleCoffee);
        System.out.println("Description: " + milkCoffee.getDescription() + ", Cost: $" + milkCoffee.cost());

        Coffee milkAndSugarCoffee = new Sugar(new Milk(simpleCoffee));
        System.out.println("Description: " + milkAndSugarCoffee.getDescription() + ", Cost: $" + milkAndSugarCoffee.cost());
    }
}

interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 1.0;
    }
}

//装饰器类
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

//具体装饰器类
class Milk extends CoffeeDecorator {
    public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return super.cost() + 0.2;
    }
}








