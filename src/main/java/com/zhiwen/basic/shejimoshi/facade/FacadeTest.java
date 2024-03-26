package com.zhiwen.basic.shejimoshi.facade;

/**
 * <p>门面模式,结构型设计模式</p>
 * @author zhiwen
 * @since 2024/2/19 6:39 下午
 */
// 子系统类
class CPU {
    public void start() {
        System.out.println("CPU is starting...");
    }
}

class Memory {
    public void load() {
        System.out.println("Memory is loading...");
    }
}

class HardDrive {
    public void read() {
        System.out.println("Hard Drive is reading...");
    }
}

// 门面类
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer is started successfully.");
    }
}

// 客户端
public class FacadeTest {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}

