/**
 * <p>
 * Title: JsonCastUtil.java
 * </p>
 * 
 * @Package com.uusoft.fundbase.util
 *          <p>
 *          Description:JSON转换工具类
 *          </p>
 *          <p>
 *          Company:上海投投金融信息服务有限公司
 *          </p>
 * @author 廖明华
 * @since 2015年8月31日 下午4:46:30
 * @version V1.0
 */
package com.zhiwen.jvm.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * JSON转换工具类
 */
public class JsonCastUtil {

    /**
     * <p>
     * Description:json字符串转成Map对象
     * </p>
     * 
     * @param str
     *            json字符串
     * @return json字符串对应的Map对象
     */
    public static Map<String, String> jsonStrToMap(String str) {
        Map<String, String> map = (Map<String, String>)JSON.parse(str);
        return map;
    }

    /**
     * <p>
     * Description:Map转成Json字符串
     * </p>
     * 
     * @param map
     *            map对象
     * @return map对象转换后的json对象
     */
    public static String mapToJson(Map<String, Object> map) {
        return JSON.toJSONString(map, true);
    }

    /**
     * <p>
     * Description:将JSON字符串转成对象
     * </p>
     * 
     * @param t
     *            对象
     * @param str
     *            json字符串
     * @return 对象
     */
    public static <T> T jsonStrToMap(Class<T> t, String str) {
        return JSON.parseObject(str, t);
    }
}
