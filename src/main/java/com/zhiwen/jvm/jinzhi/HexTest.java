package com.zhiwen.jvm.jinzhi;

import org.apache.tomcat.util.buf.HexUtils;

import java.nio.charset.Charset;

/**
 * @description: 十六进制转换工具
 * @author zhiwen
 * @date 2021/9/1 11:14
 * @version 1.0
 */
public class HexTest {

    /**
     * @description 字符串转十六进制
     * @param  sourceStr
     * @return java.lang.String
     * @author zhiwen
     * @date 2021/9/1 11:18
     */
    public static String string2HexString(String sourceStr){
        return HexUtils.toHexString(sourceStr.getBytes(Charset.defaultCharset()));
    }


    /** 
     * @description 十六进制转字符串
     * @param  hexString 十六机制
     * @return java.lang.String 
     * @author zhiwen
     * @date 2021/9/1 11:20
     */
    public static String hexString2String(String hexString){
        return new String(HexUtils.fromHexString(hexString));
    }
    


    public static void main(String[] args) {

        //demo
        //十六进制 28294c6a6176612f6c616e672f537472696e673b
        //字符串 ()Ljava/lang/String;

//        String string = hexString2String("4578636c617373427974652e6a617661");
        String string = hexString2String("636f6d2f7a686977656e2f6a766d" +
                "2f636c617373427974652f4578636c61" +
                "737342797465");
        System.out.println(string);
    }
    //28294c6a6176612f6c616e672f537472696e673b
    //28294c6a6176612f6c616e672f537472696e673b
}
