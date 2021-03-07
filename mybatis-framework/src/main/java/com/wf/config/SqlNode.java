package com.wf.config;

/**
 * @Desc : 提供对Sql脚本的解析
 * @Author : Mr.WangF
 * @Date: 2021/3/7 14:54
 */
public interface  SqlNode {


    void apply(DynamicContext context);


}
