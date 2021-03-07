package com.wf.config;

import com.wf.util.OgnlUtils;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2021/3/7 16:00
 */
public class IfSqlNode implements SqlNode{

    // test 中的布尔表达式
    private String test;

    private SqlNode rootSqlNode;


    public IfSqlNode(String test, SqlNode rootSqlNode) {
        this.test = test;
        this.rootSqlNode = rootSqlNode;
    }

    @Override
    public void apply(DynamicContext context) {
        boolean evaluateBoolean = OgnlUtils.evaluateBoolean(test, context.getBindings().get("_parameter"));
        if (evaluateBoolean) {
            rootSqlNode.apply(context);
        }
    }
}
