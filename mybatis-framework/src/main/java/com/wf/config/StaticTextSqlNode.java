package com.wf.config;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2021/3/7 15:35
 */
public class StaticTextSqlNode implements  SqlNode{


    private String sqlText;

    public StaticTextSqlNode(String sqlText) {
        this.sqlText = sqlText;
    }
    @Override
    public void apply(DynamicContext context) {


    }
}
