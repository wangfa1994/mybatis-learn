package com.wf.config;

/**
 * @Desc : SQLSource sql语句顶级接口，用于获取存储Sql相关信息，
 * 可以直接被被JDBC程序直接执行的Sql语句
 * @Author : Mr.WangF
 * @Date: 2021/3/7 13:49
 */
public interface SqlSource {

    public BoundSql getBoundSql();
}
