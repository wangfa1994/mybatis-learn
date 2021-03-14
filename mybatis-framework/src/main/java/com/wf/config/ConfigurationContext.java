package com.wf.config;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
  * @Desc: mybatis的全局配置文件
  * @Author: Mr.WangF
  * @Date: 2021/3/14 15:26
  */
public class ConfigurationContext {

    /**
     * 存储数据源
     */
    private DataSource dataSource;


    private Map<String, MappedStatement> mappedStatementMap = new HashMap<>();


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setMappedStatement(String statementId, MappedStatement mappedStatement) {
        mappedStatementMap.put(statementId, mappedStatement);
    }

    public MappedStatement getMappedStatementById(String statementId) {
        return mappedStatementMap.get(statementId);
    }
}
