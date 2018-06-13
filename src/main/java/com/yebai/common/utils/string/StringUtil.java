package com.yebai.common.utils.string;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;


public class StringUtil {
    private StringUtil(){}

    public String suffix(String src, String regx){
        if(null == src || isBlank(src.trim())){
            return src;
        }
        if(null == regx){
            regx = "\\.";
        }
        List<String> suffixList = Lists.newArrayList(src.split(regx));
        Collections.reverse(suffixList);
        return suffixList.get(0);
    }

    public String prefix(String src, String regx){
        if(null == src || isBlank(src.trim())){
            return src;
        }
        if(null == regx){
            regx = "\\.";
        }
        List<String> prefixList = Lists.newArrayList(src.split(regx));
        return prefixList.get(0);
    }

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(final CharSequence cs){
        return !isBlank(cs);
    }
}
