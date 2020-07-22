package cn.hxzy.company.util;

public class StringUtil {
    /**
     * 驼峰转下划线
     *
     * @param camelCaseName 驼峰字符串
     * @return 下划线字符串
     */
    public static String underscoreName(String camelCaseName) {
        StringBuffer result = new StringBuffer();
        if (camelCaseName != null && camelCaseName.length() > 0) {
            result.append(camelCaseName.substring(0, 1).toLowerCase());
            //拿到第一个字母转成小写
            for (int i = 1; i < camelCaseName.length(); i++) {
                char ch = camelCaseName.charAt(i);//取第i个位置的字符
                if (Character.isUpperCase(ch)) {//判断字符是不是大写字母
                    result.append("_");//如果是大写，则拼接下划线
                    result.append(Character.toLowerCase(ch));//将自己转为想小写加入result
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    /**
     * 下划线转驼峰
     *
     * @param underscoreName 下划线字符串
     * @return 驼峰字符串
     */
    public static String camelCaseName(String underscoreName) {
        StringBuffer result = new StringBuffer();
        if (underscoreName != null && underscoreName.length() > 0) {
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++) {
                char ch = underscoreName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }
}
