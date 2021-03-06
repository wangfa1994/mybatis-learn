package com.wf.config;

import javax.sql.DataSource;

/**
 *
 */
public class ConfigurationContext {

    /**
     * 存储数据源
     */
    private DataSource dataSource;


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
