package com.wf.config;

import org.dom4j.Element;

import java.util.List;

/**
 * 解析映射文件
 */
public class XMLMapperParse {

    private ConfigurationContext configurationContext;

    public XMLMapperParse(ConfigurationContext configurationContext) {
        this.configurationContext = configurationContext;
    }

    /**
     * 解析mapper文件
     * @param rootElement
     */
    public void parseMapperFile(Element rootElement) {
        String namespace = rootElement.attributeValue("namespace");

        // mapper文件中的一个一个的curd标签对应一个statementMapper

        // 获取所有的select标签, 可以使用呢xpath进行通配
        List<Element> selectElementList = rootElement.elements("select");

        // 解析对应的crud脚本
        XMLScriptParse scriptParse = new XMLScriptParse(configurationContext);

        for (Element element : selectElementList) {
            scriptParse.parseScript(element);

        }



    }
}
