package com.wf.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2021/3/7 15:13
 */
public class MixedSqlNode implements SqlNode {

    private List<SqlNode> sqlNodes = new ArrayList<>();

    public MixedSqlNode(List<SqlNode> sqlNodes) {
        this.sqlNodes = sqlNodes;
    }

    @Override
    public void apply(DynamicContext context) {
        for (SqlNode sqlNode : sqlNodes) {
            sqlNode.apply(context);
        }
    }
}
