package com.wf.config;


import com.wf.util.DocumentUtils;
import com.wf.util.ResourcesUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
  * @Desc: 用来解析全局配置文件
  * @Author: Mr.WangF
  * @Date: 2021/3/14 15:39
  */
public class XMLConfigParser {

    private ConfigurationContext configurationContext;


    public XMLConfigParser() {
        this.configurationContext = new ConfigurationContext();
    }

    public  ConfigurationContext parse(Element rootElement){
        parseEnvironments(rootElement.element("environments"));
        parseMappers(rootElement.element("mappers"));
        return configurationContext;
    }


    /**
     *  解析环境变量
     * @param environments
     */
    private void parseEnvironments(Element environments){

        // 获取默认环境属性属性
        String aDefault = environments.attributeValue("default");


        // 获取environment下面的environment子标签 ，现在是单个，是否可以扩展成多个
        List<Element> environmentList = environments.elements("environment");

        for (Element element: environmentList) {
            String idValue = element.attributeValue("id");
            // 判断环境,选择当前合适的环境
            if(idValue.equals(aDefault)){
                parseEnvironment(element);
            }
        }
    }


    /**
     * 解析mappers
     * @param element
     */
    private void parseMappers(Element element){
        List<Element> mapperList = element.elements("mapper");

        for (Element mapper : mapperList) {
            parseMapper(mapper);
        }
    }

    /**
     * 解析mapper标签
     * @param mapper
     */
    private void parseMapper(Element mapper) {
        // 获取映射文件的路径
        String resource = mapper.attributeValue("resource");
        //
        InputStream inputStream = ResourcesUtils.converResourceWithPath(resource);
        Document document = DocumentUtils.converDocumentByInputStrema(inputStream);

        //
        XMLMapperParse xmlMapperParse = new XMLMapperParse(configurationContext);
        // 解析mapper文件
        xmlMapperParse.parseMapperFile(document.getRootElement());


    }


    /**
     * 解析environment标签 ,获取数据源
     * @param element
     */
    private void parseEnvironment(Element element) {

        Element dataSource = element.element("dataSource");
        // 数据源信息配置
        String dataSourceType = dataSource.attributeValue("type");
        if (dataSourceType.equals("DBCP")){
            // 解析property属性
            Properties properties = parseDataSourceProperty(dataSource);

            BasicDataSource dataSource1 = new BasicDataSource();
            dataSource1.setDriverClassName(properties.getProperty("driver"));
            dataSource1.setUrl(properties.getProperty("url"));
            dataSource1.setUsername(properties.getProperty("username"));
            dataSource1.setPassword(properties.getProperty("password"));

            // 放入ConfigurationContext中
            configurationContext.setDataSource(dataSource1);

        }
    }

    /**
     * 解析dataSource属性
     * @param dataSource
     * @return
     */
    private Properties parseDataSourceProperty(Element dataSource) {
        Properties properties  = new Properties();

        List<Element> propertyList = dataSource.elements();

        for (Element element : propertyList) {
            String key = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.put(key,value);
        }

        return properties;

    }

}
