package com.zhiwen.basic.shejimoshi.factoryMethod;

/**
 * <p>工厂方法模式（Factory Method Pattern）是一种创建型设计模式，它提供了一种将对象的创建委托给子类的方式，从而使一个类的实例化延迟到其子类。这种模式通过定义一个创建对象的接口，但让子类决定实例化哪个类来创建对象。
 * 主要概念和用法：
 * 抽象工厂（Creator）：定义一个创建对象的抽象类或接口，其中包含一个抽象的工厂方法，该方法返回一个产品对象。这个抽象类可以包含一些默认实现，或者实现部分工厂方法。
 * 具体工厂（Concrete Creators）：具体工厂类是抽象工厂的子类，实现了工厂方法，负责创建具体的产品对象。
 * 抽象产品（Product）：定义一个产品的接口或抽象类，是具体产品对象的父类。
 * 具体产品（Concrete Products）：具体产品类是抽象产品的子类，实现了抽象产品定义的接口，具体工厂负责创建具体产品对象。
 * 使用方法：
 * 定义抽象工厂：首先需要定义一个抽象工厂，声明一个抽象的工厂方法用于创建产品对象。
 * 创建具体工厂：创建一个或多个具体工厂类，继承抽象工厂，并实现工厂方法，负责创建具体的产品对象。
 * 定义抽象产品：定义一个抽象产品类或接口，声明产品的方法。
 * 创建具体产品：创建一个或多个具体产品类，继承抽象产品，并实现具体产品的方法。
 * 使用工厂方法：客户端使用具体工厂来创建产品对象，而不直接实例化具体产品。</p>
 * @author zhiwen
 * @since 2024/2/19 7:00 下午
 */
// 抽象产品
interface Shape {
    void draw();
}

// 具体产品：圆形
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw a circle.");
    }
}

// 具体产品：矩形
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw a rectangle.");
    }
}

// 抽象工厂
abstract class ShapeFactory {
    abstract Shape createShape();
}

// 具体工厂：创建圆形
class CircleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Circle();
    }
}

// 具体工厂：创建矩形
class RectangleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Rectangle();
    }
}

// 客户端
public class Client {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();
    }
}
