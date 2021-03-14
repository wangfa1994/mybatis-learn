package com.wf.config;

/**
 * @Desc : Sql 中 参数的封装
 * @Author : Mr.WangF
 * @Date: 2021/3/7 13:54
 */
public class ParameterMapping {

    private String name;

    private Class<?> type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public ParameterMapping(String name) {
        super();
        this.name = name;
    }

}
