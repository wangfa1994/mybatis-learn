package com.wf.config;

/**
 * @Desc : 每一个crud标签都是一个MappedStatement
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

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public Class<?> getParameterType() {
        return parameterType;
    }

    public void setParameterType(Class<?> parameterType) {
        this.parameterType = parameterType;
    }

    public Class<?> getResultType() {
        return resultType;
    }

    public void setResultType(Class<?> resultType) {
        this.resultType = resultType;
    }

    public String getStatementType() {
        return statementType;
    }

    public void setStatementType(String statementType) {
        this.statementType = statementType;
    }

    public SqlSource getSqlSource() {
        return sqlSource;
    }

    public void setSqlSource(SqlSource sqlSource) {
        this.sqlSource = sqlSource;
    }
}
