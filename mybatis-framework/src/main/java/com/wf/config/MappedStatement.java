package com.wf.config;

/**
 * @Desc : 每一个crud标签都是一个Statement
 * @Author : Mr.WangF
 * @Date: 2021/3/7 13:29
 */
public class MappedStatement {

    // 唯一Id,根据这个id进行找到对应的sql片段
    private String statementId;

    // 参数类型
    private Class<?> parameterType;

    // 返回值类型
    private Class<?> resultType;

    private String statementType;
    // sql脚本
    private SqlSource sqlSource;

    public MappedStatement(String statementId, Class<?> parameterType, Class<?> resultType, String statementType, SqlSource sqlSource) {
        this.statementId = statementId;
        this.parameterType = parameterType;
        this.resultType = resultType;
        this.statementType = statementType;
        this.sqlSource = sqlSource;
    }
}
