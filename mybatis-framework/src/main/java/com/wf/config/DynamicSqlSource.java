package com.wf.config;

/**
 * @Desc : 动态处理${} 和 动态标签的sql語句 ，类似于JDBC中Statement传参的处理逻辑，字符串拼接
 * @Author : Mr.WangF
 * @Date: 2021/3/7 15:18
 */
public class DynamicSqlSource implements SqlSource {

    private SqlNode sqlNode;

    public DynamicSqlSource(SqlNode sqlNode) {
    this.sqlNode = sqlNode;
    }

    /**
     * sqlSession执行的时候，才会真正执行
     */
    @Override
    public BoundSql getBoundSql() {
        return null;
    }
}
