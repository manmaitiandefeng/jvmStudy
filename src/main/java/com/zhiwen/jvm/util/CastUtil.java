/**
 * <p>
 * Title: CastUtil.java
 * </p>
 * 
 * @Package com.uusoft.fundbase.util
 *          <p>
 *          Description:类型转换操作类
 *          </p>
 *          <p>
 *          Company:上海投投金融信息服务有限公司
 *          </p>
 *  
 * @since 2015年8月31日 下午2:24:05
 * @version V1.0
 */
package com.zhiwen.jvm.util;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类型转换工具类
 * 
 * @author zhiwen
 */
public class CastUtil {
    private static final Logger logger = LoggerFactory.getLogger(CastUtil.class);

    /**
     * <p>
     * Description:转为 String 型
     * </p>
     *
     * @param obj
     *            对象
     * @return 字符串
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }

    /**
     * <p>
     * Description:转为 String 型（提供默认值）
     * </p>
     *
     * @param obj
     *            对象
     * @param defaultValue
     *            默认值
     * @return String字符串
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * <p>
     * Description:转为 double 型
     * </p>
     *
     * @param obj
     *            对象
     * @return double对象
     */
    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    /**
     * <p>
     * Description:转为 double 型（提供默认值）
     * </p>
     *
     * @param obj
     *            对象
     * @param defaultValue
     *            默认值
     * @return double型
     */
    public static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (strValue != null && !"".equals(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * <p>
     * Description:转为 long 型
     * </p>
     *
     * @param obj
     *            对象
     * @return long型
     */
    public static long castLong(Object obj) {
        return CastUtil.castLong(obj, 0);
    }

    /**
     * <p>
     * Description:转为 long 型（提供默认值）
     * </p>
     *
     * @param obj
     *            对象
     * @param defaultValue
     *            默认值
     * @return Long对象
     */
    public static long castLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (strValue != null && !"".equals(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * <p>
     * Description:转为 int 型
     * </p>
     *
     * @param obj
     *            对象
     * @return int类型
     *  
     */
    public static int castInt(Object obj) {
        return CastUtil.castInt(obj, 0);
    }

    /**
     * <p>
     * Description:转为 int 型（提供默认值）
     * </p>
     *
     * @param obj
     *            对象
     * @param defaultValue
     *            默认值
     * @return 如果不存在，返回默认值
     *  
     */
    public static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (strValue != null && !"".equals(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return intValue;
    }

    /**
     * <p>
     * Description:转为 boolean 型
     * </p>
     *
     * @param obj
     *            对象
     * @return 对象转成boolean类型
     */
    public static boolean castBoolean(Object obj) {
        return CastUtil.castBoolean(obj, false);
    }

    /**
     * <p>
     * Description:转为 boolean 型（提供默认值）
     * </p>
     *
     * @param obj
     *            对象
     * @param defaultValue
     *            默认值
     * @return 如果转换对象为空或者null，返回默认值，否则返回转换后的值
     */
    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null) {
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }

    /**
     * <p>
     * Description:转为 String[] 型
     * </p>
     *
     * @param objArray
     *            对象数组
     * @return 转为 String[] 型
     */
    public static String[] castStringArray(Object[] objArray) {
        if (objArray == null) {
            objArray = new Object[0];
        }
        String[] strArray = new String[objArray.length];
        if (objArray != null && objArray.length > 0) {
            for (int i = 0; i < objArray.length; i++) {
                strArray[i] = castString(objArray[i]);
            }
        }
        return strArray;
    }

    /**
     * <p>
     * Description:转为 double[] 型
     * </p>
     *
     * @param objArray
     *            数组
     * @return 转为 double[] 型
     *  
     */
    public static double[] castDoubleArray(Object[] objArray) {
        if (objArray == null) {
            objArray = new Object[0];
        }
        double[] doubleArray = new double[objArray.length];
        if (objArray != null && objArray.length > 0) {
            for (int i = 0; i < objArray.length; i++) {
                doubleArray[i] = castDouble(objArray[i]);
            }
        }
        return doubleArray;
    }

    /**
     * <p>
     * Description:转为 long[] 型
     * </p>
     *
     * @param objArray
     *            数组
     * @return 转为 long[] 型
     *  
     */
    public static long[] castLongArray(Object[] objArray) {
        if (objArray == null) {
            objArray = new Object[0];
        }
        long[] longArray = new long[objArray.length];
        if (objArray != null && objArray.length > 0) {
            for (int i = 0; i < objArray.length; i++) {
                longArray[i] = castLong(objArray[i]);
            }
        }
        return longArray;
    }

    /**
     * <p>
     * Description:转为 int[] 型
     * </p>
     *
     * @param objArray
     *            数组
     * @return 转为 int[] 型
     *  
     */
    public static int[] castIntArray(Object[] objArray) {
        if (objArray == null) {
            objArray = new Object[0];
        }
        int[] intArray = new int[objArray.length];
        if (objArray != null && objArray.length > 0) {
            for (int i = 0; i < objArray.length; i++) {
                intArray[i] = castInt(objArray[i]);
            }
        }
        return intArray;
    }

    /**
     * <p>
     * Description:转为 boolean[] 型
     * </p>
     *
     * @param objArray
     *            数组
     * @return 转为 boolean[] 型
     *  
     */
    public static boolean[] castBooleanArray(Object[] objArray) {
        if (objArray == null) {
            objArray = new Object[0];
        }
        boolean[] booleanArray = new boolean[objArray.length];
        if (objArray != null && objArray.length > 0) {
            for (int i = 0; i < objArray.length; i++) {
                booleanArray[i] = castBoolean(objArray[i]);
            }
        }
        return booleanArray;
    }

    /**
     * @Title: bigDecimal2String @Description: 把bigDecimal2String类型的值转2位小数 @param val @return String @throws
     */
    public static String bigDecimal2String(BigDecimal val) {

        if (null == val) {
            return "0.00";
        } else {
            return String.format("%.2f", val);
        }
    }

    /**
     * @Title: bigDecimal4String @Description: 把bigDecimal2String类型的值转4位小数 @param val @return String @throws
     */
    public static String bigDecimal4String(BigDecimal val) {

        if (null == val) {
            return "0.00";
        } else {
            return String.format("%.4f", val);
        }
    }

    /**
     *
     * <p>
     * Description: 把String类型的值转2位小数
     * </p>
     *
     * @param val
     * @return
     */
    public static String String2Digits(String val) {

        if (val == null || "".equals(val)) {
            return "0.00";
        } else {
            try {
                BigDecimal bg = new BigDecimal(val);
                return bg.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            } catch (Exception e) {
                logger.error("把String类型的值转2位小数", e);
            }
        }
        return "0.00";
    }

    /**
     * <p>
     * Description: 把String类型的值转整数
     * </p>
     *
     * @param val
     * @return
     */
    public static String StringDigits(String val) {

        if (val == null || "".equals(val)) {
            return "0";
        } else {
            try {
                BigDecimal bg = new BigDecimal(val);
                return bg.setScale(0, BigDecimal.ROUND_HALF_UP).toString();
            } catch (Exception e) {
                logger.error("把String类型的值转整数", e);
            }
        }
        return "0";
    }

    /**
     * <p>
     * Description: 把BigDecimal类型的值转整数(如果有带小数则保留2位小数，如果不带小数则为整数)
     * </p>
     *
     * @param val
     * @return
     */
    public static String bigConditionsInteger(BigDecimal val) {
        if (val == null) {
            return "0";
        } else {
            try {
                Integer it = Integer.valueOf(val.toString());
                return it + "";
            } catch (Exception e) {
                String val1 = val.toString();
                if (val1.substring(val1.indexOf(".") + 1).length() >= 2) {
                    if (val1.substring(val1.indexOf(".") + 1, val1.indexOf(".") + 3).equals("00")) {
                        val1 = val1.substring(0, val1.indexOf("."));
                    } else {
                        val1 = val1.substring(0, val1.indexOf(".") + 3);
                    }
                }
                return val1;
            }
        }
    }

    /**
     * <p>
     * Description:四舍五入取2位小数
     * </p>
     * 
     * @param val
     * @return
     */
    public static String bigDecimal2StringUp(BigDecimal val) {
        if (null == val) {
            return "0.00";
        } else {
            return val.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        }
    }

    /**
     * <p>
     * Description:四舍五入取整数
     * </p>
     * 
     * @param val
     * @return
     */
    public static String bigDecimalStringUp(BigDecimal val) {
        if (null == val) {
            return "0";
        } else {
            return val.setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        }
    }

    public static String big2Percentage(BigDecimal val) {
        logger.info("把BigDecimal类型的值转百分数 val[{}]", val);
        try {
            if (val == null) {
                return "0.00";
            }
            return (val.multiply(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_DOWN).toString();
        } catch (Exception e) {
            logger.error("把BigDecimal类型的值转百分数 val[{}]", val, e);
            return "0.00";
        }
    }

    public static String StringConditionsInteger(String val) {
        if (val == null || "".equals(val)) {
            return "0";
        } else {
            try {
                Integer it = Integer.valueOf(val);
                val = it + "";
            } catch (Exception e) {
                BigDecimal bg = new BigDecimal(val);
                if (val.substring(val.indexOf(".") + 1).length() >= 2) {
                    if (val.substring(val.indexOf(".") + 1, val.indexOf(".") + 3).equals("00")) {
                        val = val.substring(0, val.indexOf("."));
                    } else {
                        val = val.substring(0, val.indexOf(".") + 3);
                    }
                }

            }
            return val;
        }
    }
}
