package cn.dnaizn.mall.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(90000) + 10000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
    //length用户要求产生字符串的长度
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
