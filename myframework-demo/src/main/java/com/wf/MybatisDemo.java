package com.wf;

import com.wf.config.ConfigurationContext;
import com.wf.config.XMLConfigParser;
import com.wf.util.DocumentUtils;
import com.wf.util.ResourcesUtils;
import org.dom4j.Document;

import java.io.InputStream;

public class MybatisDemo {

    public static void main(String[] args) {

        // 指定全局配置文件路径
        String resource = "SqlMapConfig.xml";
        // 获取指定路径的IO流
        InputStream inputStream = ResourcesUtils.converResourceWithPath(resource);
        // 获取Document对象
        Document document = DocumentUtils.converDocumentByInputStrema(inputStream);
        // 解析Document获取Configuration对象
        XMLConfigParser configParser = new XMLConfigParser();

        // <configuration>
        ConfigurationContext configuration = configParser.parse(document.getRootElement());
        System.out.println(configuration);
    }
}
