package com.wf.util;

import java.io.InputStream;

/**
 * 解析资源
 */
public class ResourcesUtils {


    public static InputStream converResourceWithPath(String path){
        InputStream resourceAsStream = ResourcesUtils.class.getClassLoader().getResourceAsStream(path);
       return resourceAsStream;
    }
}
