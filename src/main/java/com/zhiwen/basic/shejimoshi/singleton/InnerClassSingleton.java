package com.zhiwen.basic.shejimoshi.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <p></p>
 * @author zhiwen
 * @since 2024/1/29 10:27 上午
 */
public class InnerClassSingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private InnerClassSingleton() {
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

    private static class InnerClassHolder {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    private Object readResolve() throws ObjectStreamException {
        return InnerClassHolder.instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       /* Constructor<InnerClassSingleton>
                declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(
                true
        );
       *//* InnerClassSingleton
                innerClassSingleton = declaredConstructor.newInstance();*//*
        InnerClassSingleton
                instance = InnerClassSingleton.getInstance();*/
        //System.out.println(innerClassSingleton == instance);
    }
}
