package com.zhiwen.jvm;

/**
 * 字节码指令手册 address: http://note.youdao.com/noteshare?id=6dde1c6126de6283f482992a374d214c&sub=FBB61C3619264279A07A2861C5666F87<br/><br/><br/>
 *
 * 本类通过javap -v 反汇编出的代码指令信息
 * Classfile /E:/ideaProjects/jvmStudy/target/classes/com/zhiwen/jvm/User.class
 *   Last modified 2021-8-20; size 501 bytes
 *   MD5 checksum f1cd537b957597a216a3edfafbc19b2c
 *   Compiled from "User.java"
 * public class com.zhiwen.jvm.User
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #6.#17         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #18.#19        // java/lang/System.out:Ljava/io/PrintStream;
 *    #3 = String             #20            // user.................
 *    #4 = Methodref          #21.#22        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #5 = Class              #23            // com/zhiwen/jvm/User
 *    #6 = Class              #24            // java/lang/Object
 *    #7 = Utf8               <init>
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               LocalVariableTable
 *   #12 = Utf8               this
 *   #13 = Utf8               Lcom/zhiwen/jvm/User;
 *   #14 = Utf8               test
 *   #15 = Utf8               SourceFile
 *   #16 = Utf8               User.java
 *   #17 = NameAndType        #7:#8          // "<init>":()V
 *   #18 = Class              #25            // java/lang/System
 *   #19 = NameAndType        #26:#27        // out:Ljava/io/PrintStream;
 *   #20 = Utf8               user.................
 *   #21 = Class              #28            // java/io/PrintStream
 *   #22 = NameAndType        #29:#30        // println:(Ljava/lang/String;)V
 *   #23 = Utf8               com/zhiwen/jvm/User
 *   #24 = Utf8               java/lang/Object
 *   #25 = Utf8               java/lang/System
 *   #26 = Utf8               out
 *   #27 = Utf8               Ljava/io/PrintStream;
 *   #28 = Utf8               java/io/PrintStream
 *   #29 = Utf8               println
 *   #30 = Utf8               (Ljava/lang/String;)V
 * {
 *   public com.zhiwen.jvm.User();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 3: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lcom/zhiwen/jvm/User;
 *
 *   public void test();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #3                  // String user.................
 *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 6: 0
 *         line 7: 8
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       9     0  this   Lcom/zhiwen/jvm/User;
 * }
 * SourceFile: "User.java"
 * Classfile /E:/ideaProjects/jvmStudy/target/classes/com/zhiwen/jvm/User.class
 *   Last modified 2021-8-23; size 720 bytes
 *   MD5 checksum 8b71ec264f2491413454b55908f0e79b
 *   Compiled from "User.java"
 * public class com.zhiwen.jvm.User
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #7.#28         // java/lang/Object."<init>":()V
 *    #2 = Methodref          #6.#29         // com/zhiwen/jvm/User.start:()I
 *    #3 = Fieldref           #30.#31        // java/lang/System.out:Ljava/io/PrintStream;
 *    #4 = String             #32            // 111111
 *    #5 = Methodref          #33.#34        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #6 = Class              #35            // com/zhiwen/jvm/User
 *    #7 = Class              #36            // java/lang/Object
 *    #8 = Utf8               <init>
 *    #9 = Utf8               ()V
 *   #10 = Utf8               Code
 *   #11 = Utf8               LineNumberTable
 *   #12 = Utf8               LocalVariableTable
 *   #13 = Utf8               this
 *   #14 = Utf8               Lcom/zhiwen/jvm/User;
 *   #15 = Utf8               start
 *   #16 = Utf8               ()I
 *   #17 = Utf8               a
 *   #18 = Utf8               I
 *   #19 = Utf8               b
 *   #20 = Utf8               c
 *   #21 = Utf8               main
 *   #22 = Utf8               ([Ljava/lang/String;)V
 *   #23 = Utf8               args
 *   #24 = Utf8               [Ljava/lang/String;
 *   #25 = Utf8               MethodParameters
 *   #26 = Utf8               SourceFile
 *   #27 = Utf8               User.java
 *   #28 = NameAndType        #8:#9          // "<init>":()V
 *   #29 = NameAndType        #15:#16        // start:()I
 *   #30 = Class              #37            // java/lang/System
 *   #31 = NameAndType        #38:#39        // out:Ljava/io/PrintStream;
 *   #32 = Utf8               111111
 *   #33 = Class              #40            // java/io/PrintStream
 *   #34 = NameAndType        #41:#42        // println:(Ljava/lang/String;)V
 *   #35 = Utf8               com/zhiwen/jvm/User
 *   #36 = Utf8               java/lang/Object
 *   #37 = Utf8               java/lang/System
 *   #38 = Utf8               out
 *   #39 = Utf8               Ljava/io/PrintStream;
 *   #40 = Utf8               java/io/PrintStream
 *   #41 = Utf8               println
 *   #42 = Utf8               (Ljava/lang/String;)V
 * {
 *   public com.zhiwen.jvm.User();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 3: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lcom/zhiwen/jvm/User;
 *
 *   public static int start();
 *     descriptor: ()I
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=3, args_size=0
 *          0: iconst_5
 *          1: istore_0
 *          2: bipush        6
 *          4: istore_1
 *          5: iload_0
 *          6: iload_1
 *          7: iadd
 *          8: bipush        10
 *         10: imul
 *         11: istore_2
 *         12: iload_2
 *         13: ireturn
 *       LineNumberTable:
 *         line 28: 0
 *         line 29: 2
 *         line 30: 5
 *         line 31: 12
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             2      12     0     a   I
 *             5       9     1     b   I
 *            12       2     2     c   I
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: invokestatic  #2                  // Method start:()I
 *          3: pop
 *          4: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          7: ldc           #4                  // String 111111
 *          9: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         12: return
 *       LineNumberTable:
 *         line 35: 0
 *         line 36: 4
 *         line 37: 12
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      13     0  args   [Ljava/lang/String;
 *     MethodParameters:
 *       Name                           Flags
 *       args
 * }
 * SourceFile: "User.java"
 *
 */
public class User {

    /**
     * 字节码反汇编看下执行指令，这里得参考jvm指令手册
     * ************************************<br/>
     * 局部变量是一个数组
     * Code:
     *        0: iconst_5 将int类型常量5压入栈
     *        1: istore_0 将int类型值存入局部变量0
     *        2: bipush        6  将常量6压入操作栈中
     *        4: istore_1 将int类型值存入局部变量1
     *        5: iload_0  从局部变量0中装载int类型值 5
     *        6: iload_1  从局部变量1中装载int类型值 6
     *        7: iadd     执行int类型的加法(5+6)
     *        8: bipush        10  常量10压入操作数栈中
     *       10: imul     执行int类型的加法11*10
     *       11: istore_2 将int类型值(110)存入局部变量2
     *       12: iload_2  从局部变量2中装载int类型值
     *       13: ireturn  从该方法中返回int类型的数据（110）
     *
     * ************************************** <br/>
     * @return 计算结果
     */
    public static int start(){
        int a = 5;
        int b = 6;
        int c = (a+b) *10;
        return c;
    }

    /**
     * 字节码指令解读:
     *  Code:
     *        0: invokestatic  #2                  // Method start:()I  调用静态方法
     *        3: pop                               将操作数栈顶数值弹出
     *        4: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;  //取出字段的值，放入操作数栈中
     *        7: ldc           #4                  // String 111111  把数值常量或String常量值从常量池中推送至栈顶
     *        9: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V 调用out对象(PrintStream)的printLn(方法)
     *       12: return
     *
     * @param args main方法
     */
    public static void main(String[] args) {
        start();
        System.out.println("111111");
    }
}
