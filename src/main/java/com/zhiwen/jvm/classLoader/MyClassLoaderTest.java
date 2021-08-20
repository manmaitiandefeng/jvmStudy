package com.zhiwen.jvm.classLoader;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 *
 * @author zhiwen
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {

        /**
         * 类路径
         */
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        /**
         * 自定义的核心就是重新指定类加载地址
         * @param name 加载类的包名 com.zhiwen.jvm.User
         * @return 类
         * @throws ClassNotFoundException
         */
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] bytes = loadByte(name);
                return defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                throw new ClassNotFoundException();
            }
        }

        public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
            MyClassLoader myClassLoader = new MyClassLoader("E:\\study\\project");


            //注意:在类加载时load的路径是包路径com.zhiwen.jvm.User,classPath是不同的，自定义是是E:\study\project开头，appClassLoader是E:\ideaProjects\jvmStudy\target\classes
            //如果包名一致，还是要走双亲委派，appClassLoader加载路径有就优先加载
            Class<?> userClass = myClassLoader.loadClass("com.zhiwen.jvm.User");

            Object o = userClass.newInstance();

            Method soutMethod = userClass.getDeclaredMethod("test", null);
            soutMethod.invoke(o,null);

            System.out.println("user的类加载器----"+userClass.getClassLoader());

        }
    }

}
