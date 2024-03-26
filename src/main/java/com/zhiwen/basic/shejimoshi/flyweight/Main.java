package com.zhiwen.basic.shejimoshi.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 * @author zhiwen
 * @since 2024/2/20 5:32 下午
 */
public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        // 绘制文本
        String text = "Hello, world!";
        for (char c : text.toCharArray()) {
            Flyweight flyweight = factory.getFlyweight(c);
            flyweight.draw("black");
        }
    }
}

class FlyweightFactory {
    //存储享元对象的池子，非常关键，就是通过这个池子来实现享元模式的，比如当hello world中 'o'多次出现就不需要创建多个对象了
    private Map<Character, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(char character) {
        if (!flyweights.containsKey(character)) {
            flyweights.put(character, new CharacterFlyweight(character));
        }
        return flyweights.get(character);
    }
}


interface Flyweight {
    void draw(String color);
}

class CharacterFlyweight implements Flyweight {
    private char character;

    public CharacterFlyweight(char character) {
        this.character = character;
    }

    @Override
    public void draw(String color) {
        System.out.println("Drawing character " + character + " with color " + color);
    }
}

