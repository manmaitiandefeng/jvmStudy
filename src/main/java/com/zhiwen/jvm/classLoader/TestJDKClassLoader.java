package com.zhiwen.jvm.classLoader;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.net.URL;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 了解下类加载器
 * 
 * @author zhiwen
 */
public class TestJDKClassLoader {

    public static  int a = 5;

    public static void main(String[] args) {
        // 如果是null 加载器是顶级的引导类加载器 BootstrapClassLoader 是在jvm中用c++实现的
        System.out.println("String加载器：" + String.class.getClassLoader());

        // 扩展类加载器sun.misc.Launcher$ExtClassLoader
        ClassLoader extClassLoader = DESKeyFactory.class.getClassLoader();
        System.out.println("DESKeyFactory 加载器：" + extClassLoader.getClass().getName());

        // 系统默认加载器是应用类加载器AppClassLoader
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader 加载器:" + appClassLoader);

        // 父加载器 appClassLoader ->ExtClassLoader ->BootstrapClassLoader(java中是空)
        System.out.println("appClassLoader 父加载器:" + appClassLoader.getParent());
        System.out.println("ExtClassLoader 父加载器:" + extClassLoader.getParent());

        // 加载器加载的包 顶级引导类加载器C:\Program Files\Java\jre1.8.0_191\lib\rt.jar
        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
        String BootstrapUrlList =
            Stream.of(bootstrapClassPath.getURLs()).map(URL::getPath).collect(Collectors.joining("\r\n"));
        System.out.println("BootstrapClassLoader 加载的文件：" + "\r\n" + BootstrapUrlList);
        System.out.println();

        // java.ext.dirs路径下是extClassloader
        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();

        // 注意 java.class.path路径下包含了 BootstrapClassLoader extClassloader appClassloader
        //java.class.path(classpath)
        // 根据Java应用的CLASSPATH来加载Java类
        // Java中的应用类都是通过它来加载的
        System.out.println("appClassloader加载以下文件:");
        String appClassLoadUrlList =
            Stream.of(System.getProperty("java.class.path").split(";")).collect(Collectors.joining("\r\n"));
        System.out.println(appClassLoadUrlList);

    }
}
