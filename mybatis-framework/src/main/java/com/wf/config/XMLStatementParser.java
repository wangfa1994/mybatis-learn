package com.wf.config;

import org.dom4j.Element;
import org.dom4j.Node;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2021/3/7 13:14
 */
public class XMLStatementParser {

    private  ConfigurationContext configurationContext ;
    public XMLStatementParser(ConfigurationContext configurationContext) {
        this.configurationContext = configurationContext;
    }


    /**
     * 解析statement ，一个selectd等标签就是一个MappedStatement
     *
     * @param element
     * @param nameSpace
     */
    public void parseStatement(Element element,String nameSpace) {

        String id = element.attributeValue("id");
        // 获取入参类型进行映射
        String parameterType = element.attributeValue("parameterType");
        Class<?> parameterTypeClass = resolveClass(parameterType);

        String resultType = element.attributeValue("resultType");
        Class<?> resultTypeClass = resolveClass(resultType);

        // 选择使用哪种Statement类型
        String statementType = element.attributeValue("statementType");
        statementType = statementType == null || statementType.equals("") ? "prepared" : statementType;

        // SqlSource
        SqlSource sqlSource = createSqlSource(element);


        String statementId = nameSpace + "." + id;

        // TODO 可以改成构建者模式,创建MapperdStatement
        MappedStatement mappedStatement = new MappedStatement(statementId, parameterTypeClass, resultTypeClass,
                statementType, sqlSource);
        configurationContext.setMappedStatement(statementId, mappedStatement);
    }

    /**
     * 创建SQLSource,就是对crud标签中SQL脚本的封装
     * @param element
     * @return
     */
    private SqlSource createSqlSource(Element element) {
        XMLScriptParse scriptParse = new XMLScriptParse(configurationContext);
        // 解析我们的sql脚本片段
        SqlSource sqlSource = scriptParse.parseScriptNode(element);
        return sqlSource;
    }


    /**
     * 根据全路径名称获取类信息
     * @param parameterType
     * @return
     */
    private Class<?> resolveClass(String parameterType) {

        Class<?> aClass = null;
        try {
            aClass = Class.forName(parameterType);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aClass;
    }
}
