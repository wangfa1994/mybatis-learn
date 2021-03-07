package com.wf.config;

import org.dom4j.Element;

import java.util.List;

/**
 * @Desc : handler处理器，针对不同的子标签进行处理，封装成对应的sqlNode对象中
 * if标签-->IfSqlNode
 * @Author : Mr.WangF
 * @Date: 2021/3/7 15:41
 */
public interface NodeHandler {


    void handleNode(Element nodeToHandle, List<SqlNode> targetContents);

}
