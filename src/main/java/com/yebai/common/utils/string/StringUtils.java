package com.yebai.common.utils.string;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/// import static com.google.common.base.Preconditions.checkArgument;

public class StringUtils {
    private StringUtils(){}

    public String suffix(String src, String regx){
        if(null == src || org.apache.commons.lang3.StringUtils.isBlank(src.trim())){
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
        if(null == src || org.apache.commons.lang3.StringUtils.isBlank(src.trim())){
            return src;
        }
        if(null == regx){
            regx = "\\.";
        }
        List<String> prefixList = Lists.newArrayList(src.split(regx));
        return prefixList.get(0);
    }
}
