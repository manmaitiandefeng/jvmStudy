package com.zhiwen.jvm.classLoader.spi;

public class SPIService1Impl implements SPIService {
    @Override
    public void execute() {
        System.out.println("SPIService1Impl......");
    }
}
