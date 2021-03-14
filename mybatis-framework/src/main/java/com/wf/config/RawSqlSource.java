package com.wf.config;

/**
 * @Desc : 类似JDBC中PreparedStatement的处理逻辑，是预处理
 * @Author : Mr.WangF
 * @Date: 2021/3/7 15:21
 */
public class RawSqlSource implements SqlSource{

    private SqlNode sqlNode;

    public RawSqlSource(SqlNode sqlNode) {
        this.sqlNode = sqlNode;
        // 在这里要先对sql节点进行解析
    }

    @Override
    public BoundSql getBoundSql() {
        return null;
    }
}
