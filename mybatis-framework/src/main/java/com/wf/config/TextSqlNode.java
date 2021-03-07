package com.wf.config;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2021/3/7 15:28
 */
public class TextSqlNode implements SqlNode{

    private String sqlText;

    public TextSqlNode(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public void apply(DynamicContext context) {

    }

    /**
     * 判断文本中是否包括动态标签
     * @return TODO
     */
    public boolean isDynamicNode(){
        if(sqlText.indexOf("${")>0){
            return false;
        }else{
            return true;
        }
    }
}
