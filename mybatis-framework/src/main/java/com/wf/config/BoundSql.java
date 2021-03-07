package com.wf.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc :  绑定sql信息
 * @Author : Mr.WangF
 * @Date: 2021/3/7 13:53
 */
public class BoundSql {

    // sql 语句
    private String sql;

    //
    private List<ParameterMapping> parameterMappingList = new ArrayList<>();

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }


    public void addParameterMapping(ParameterMapping parameterMapping) {
        parameterMappingList.add(parameterMapping);
    }
}
