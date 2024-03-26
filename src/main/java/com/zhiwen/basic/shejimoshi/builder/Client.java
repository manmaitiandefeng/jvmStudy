package com.zhiwen.basic.shejimoshi.builder;

/**
 * <p>主要概念和用法：
 * 产品（Product）：要构建的复杂对象。通常包含多个部件或组件。
 *
 * 抽象建造者（Builder）：定义了构建产品各个部件的抽象方法，以及返回最终构建产品的方法。
 *
 * 具体建造者（Concrete Builder）：实现了抽象建造者接口，负责实际构建产品的各个部件，并负责组装这些部件以构建最终的产品。
 *
 * 指挥者（Director）：负责使用建造者接口构建产品。指挥者知道构建的具体步骤和顺序，但不负责具体构建过程。
 *
 * 使用方法：
 * 定义产品类：首先需要定义一个产品类，该产品类包含了要构建的复杂对象的所有属性。
 *
 * 定义抽象建造者：定义一个抽象建造者接口，其中包含了构建产品各个部件的抽象方法，以及返回最终构建产品的方法。
 *
 * 定义具体建造者：创建一个或多个具体建造者类，实现抽象建造者接口，负责实际构建产品的各个部件，并负责组装这些部件以构建最终的产品。
 *
 * 定义指挥者：创建一个指挥者类，负责使用建造者接口构建产品。指挥者知道构建的具体步骤和顺序，但不负责具体构建过程。
 *
 * 客户端调用：客户端使用具体建造者和指挥者来构建产品，通过指定需要的类型和内容来创建对象，而不需要知道具体的构建细节。</p>
 * @author zhiwen
 * @since 2024/2/19 7:13 下午
 */
// 产品类：电脑
class Computer {
    private String cpu;
    private String memory;
    private String hardDrive;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDrive='" + hardDrive + '\'' +
                '}';
    }
}

// 抽象建造者
interface ComputerBuilder {
    void buildCpu();
    void buildMemory();
    void buildHardDrive();
    Computer getComputer();
}

// 具体建造者：台式电脑建造者
class DesktopComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public DesktopComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("Desktop CPU");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("Desktop Memory");
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("Desktop Hard Drive");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

// 具体建造者：笔记本电脑建造者
class LaptopComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public LaptopComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("Laptop CPU");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("Laptop Memory");
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("Laptop Hard Drive");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

// 指挥者
class Director {
    public Computer construct(ComputerBuilder builder) {
        builder.buildCpu();
        builder.buildMemory();
        builder.buildHardDrive();
        return builder.getComputer();
    }
}

// 客户端
public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        // 构建台式电脑
        ComputerBuilder desktopBuilder = new DesktopComputerBuilder();
        Computer desktopComputer = director.construct(desktopBuilder);
        System.out.println("Desktop Computer: " + desktopComputer);

        // 构建笔记本电脑
        ComputerBuilder laptopBuilder = new LaptopComputerBuilder();
        Computer laptopComputer = director.construct(laptopBuilder);
        System.out.println("Laptop Computer: " + laptopComputer);
    }
}

