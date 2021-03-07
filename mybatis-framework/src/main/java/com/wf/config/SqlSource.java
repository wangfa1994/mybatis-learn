package com.wf.config;

/**
 * @Desc : SQLSource sql语句顶级接口，用于存储Sql相关信息
 * @Author : Mr.WangF
 * @Date: 2021/3/7 13:49
 */
public interface SqlSource {

    public BoundSql getBoundSql();
}
