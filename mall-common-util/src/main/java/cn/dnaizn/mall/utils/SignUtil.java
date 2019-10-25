package cn.dnaizn.mall.utils;

import com.github.pagehelper.util.StringUtil;

import java.util.*;

public class SignUtil {
    static final String KEY ="XV0qmv5JNaqpGak77JI2o42fHXGcwL";
    static final String APP_ID = "2019092300001";
    public static Map create(Map<String,String> map) {
        map.put("app_id", APP_ID);
        StringBuffer sb = new StringBuffer();
        //排序
        List<Map.Entry<String, String>> infoIds =
                new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });
        //对参数数组进行按key升序排列,然后拼接，最后调用5签名方法
        int size  = infoIds.size();
        for(int i = 0; i < size; i++) {
            if(StringUtil.isNotEmpty(infoIds.get(i).getValue())) {//不为空，为空的不参与签名
                sb.append(infoIds.get(i).getKey() + "=" + infoIds.get(i).getValue() + "&");
            }
        }
        String newStrTemp = sb.toString()+"key="+KEY;
        map.put("sign", MD5Util.encryptWithMD5(newStrTemp,"UTF-8"));
        return map;
    }
}
