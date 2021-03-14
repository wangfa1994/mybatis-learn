package com.wf.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc : 动态解析标签上下文
 * 存储SqlNode解析过程中产生的sql片段，并完成字符串拼接 存储SqlNode解析过程中需要的入参信息
 * @Author : Mr.WangF
 * @Date: 2021/3/7 15:12
 */
public class DynamicContext {

    // sql拼接
    private StringBuilder sb = new StringBuilder();

    // 参数
    private Map<String, Object> bindings = new HashMap<String, Object>();

    // 为什么要指定key
    public DynamicContext(Object param) {
        bindings.put("_parameter", param);
    }

    public void appendSql(String sql) {
        sb.append(sql);
        sb.append(" ");
    }

    public String getSql() {
        return sb.toString();
    }

    public Map<String, Object> getBindings() {
        return bindings;
    }

}
