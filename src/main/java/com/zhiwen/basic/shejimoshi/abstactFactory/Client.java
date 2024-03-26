package com.zhiwen.basic.shejimoshi.abstactFactory;

/**
 * <p>抽象工厂模式（Abstract Factory Pattern）是另一种创建型设计模式，它提供了一种接口，用于创建相关或依赖对象的家族，而不需要指定它们具体的类。这种模式属于创建型模式，它提供了一种创建对象的最佳方式，解决了单个工厂创建对象的局限性，使得应用程序更具有灵活性。
 *
 * 主要概念和用法：
 * 抽象工厂（Abstract Factory）：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 *
 * 具体工厂（Concrete Factory）：实现抽象工厂接口，负责创建具体的产品对象。每个具体工厂都对应一组特定的产品。
 *
 * 抽象产品（Abstract Product）：定义一系列产品的接口，是一系列产品对象的父类。
 *
 * 具体产品（Concrete Product）：实现抽象产品接口，具体工厂负责创建具体产品对象。
 *
 * 使用方法：
 * 定义抽象工厂：首先需要定义一个抽象工厂接口，其中包含一组抽象的创建方法，用于创建一系列相关的产品。
 *
 * 创建具体工厂：创建一个或多个具体工厂类，实现抽象工厂接口，负责创建具体的产品对象。
 *
 * 定义抽象产品：定义一组抽象产品接口或抽象类，声明产品的方法。
 *
 * 创建具体产品：创建一组具体产品类，实现抽象产品接口或抽象类，具体工厂负责创建这些具体产品对象。
 *
 * 使用抽象工厂：客户端使用抽象工厂来创建产品对象，而不直接实例化具体工厂和具体产品</p>
 * @author zhiwen
 * @since 2024/2/19 7:04 下午
 */
// 抽象产品：按钮
interface Button {
    void paint();
}

// 具体产品：Windows 风格按钮
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Paint a Windows button.");
    }
}

// 具体产品：Mac 风格按钮
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Paint a Mac button.");
    }
}

// 抽象产品：文本框
interface TextBox {
    void display();
}

// 具体产品：Windows 风格文本框
class WindowsTextBox implements TextBox {
    @Override
    public void display() {
        System.out.println("Display a Windows text box.");
    }
}

// 具体产品：Mac 风格文本框
class MacTextBox implements TextBox {
    @Override
    public void display() {
        System.out.println("Display a Mac text box.");
    }
}

// 抽象工厂
interface UIFactory {
    Button createButton();

    TextBox createTextBox();
}

// 具体工厂：Windows 风格工厂
class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
}

// 具体工厂：Mac 风格工厂
class MacUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MacTextBox();
    }
}

// 客户端
public class Client {
    public static void main(String[] args) {
        // 创建 Windows 风格工厂
        UIFactory windowsFactory = new WindowsUIFactory();
        Button windowsButton = windowsFactory.createButton();
        TextBox windowsTextBox = windowsFactory.createTextBox();
        windowsButton.paint();
        windowsTextBox.display();

        // 创建 Mac 风格工厂
        UIFactory macFactory = new MacUIFactory();
        Button macButton = macFactory.createButton();
        TextBox macTextBox = macFactory.createTextBox();
        macButton.paint();
        macTextBox.display();
    }
}

