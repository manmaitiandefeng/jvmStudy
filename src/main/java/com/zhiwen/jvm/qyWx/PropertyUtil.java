package com.zhiwen.jvm.qyWx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 读取property配置文件工具类
 * 
 * @author zhiwen
 */
public class PropertyUtil {
    /**
     * 日志
     */
    private static Logger log = LoggerFactory.getLogger(PropertyUtil.class);

    /**
     * Properties 对象
     */
    private static Map<String, String> map = new ConcurrentHashMap<String, String>();

    /**
     * 实例化对象
     */
    private static PropertyUtil instance = new PropertyUtil();

    /**
     * <p>
     * Title: PropertyUtil
     * </p>
     * <p>
     * Description: 默认加载/biz.properties
     * </p>
     */
    private PropertyUtil() {
        Properties properties = loadProps("/biz.properties");
        for (String key : properties.stringPropertyNames()) {
            map.put(key, properties.getProperty(key));
        }
    }

    /**
     * <p>
     * Description:获取实例对象
     * </p>
     * 
     * @return 实例对象
     */
    public static synchronized PropertyUtil getInstance() {
        if (instance == null) {
            instance = new PropertyUtil();
        }
        return instance;
    }

    /**
     * <p>
     * Description:加载属性文件
     * </p>
     */
    public Properties loadProps(String propsPath) {
        Properties props = new Properties();
        InputStream is = null;
        try {
            if (propsPath == null || "".equals(propsPath)) {
                throw new IllegalArgumentException();
            }
            String suffix = ".properties";
            if (propsPath.lastIndexOf(suffix) == -1) {
                propsPath += suffix;
            }
            is = getClassLoader().getResourceAsStream(propsPath);
            if (is != null) {
                props.load(is);
            }
        } catch (Exception e) {
            log.error("加载属性文件出错！", e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                log.error("释放资源出错！", e);
            }
        }
        return props;
    }

    /**
     * 获取类加载器
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * <p>
     * Description:根据key查询对应的值
     * </p>
     * 
     * @param key
     *            propertity文件中key
     * @return key对应的值
     */
    public String getValue(String key) {
        return map.get(key);
    }

    /**
     * <p>
     * Description:获取字符型属性
     * </p>
     * 
     * @param props
     *            Properties对象
     * @param key
     *            property文件中key字符
     * @return 字符属性
     * @author 廖明华
     * @date 2015年8月31日 下午2:06:14
     */
    public static String getString(Properties props, String key) {
        String value = "";
        if (map.containsKey(key)) {
            value = map.get(key);
        }
        return value;
    }

    /**
     * <p>
     * Description:获取字符型属性（带有默认值）
     * </p>
     * 
     * @param key
     *            字符型对应的属性key
     * @param defalutValue
     *            默认值
     * @return 字符型属性（带有默认值）
     * @author 廖明华
     * @date 2015年8月31日 下午2:07:25
     */
    public static String getString(String key, String defalutValue) {
        String value = defalutValue;
        if (map.containsKey(key)) {
            value = map.get(key);
        }
        return value;
    }

}
