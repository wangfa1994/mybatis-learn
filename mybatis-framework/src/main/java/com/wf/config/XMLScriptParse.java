package com.wf.config;

import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @Desc:  mapper文件中，mysql的解析，生成对应的SQLSource
  * @Author: Mr.WangF
  * @Date: 2021/3/14 15:40
  */
public class XMLScriptParse {



    private ConfigurationContext configurationContext;


    private boolean isDynamic = false;

    private Map<String,NodeHandler> nodeHandlerMap = new HashMap<>();


    public XMLScriptParse(ConfigurationContext configurationContext) {
        this.configurationContext = configurationContext;

        initNodeHandle();
    }

    private void initNodeHandle() {
        nodeHandlerMap.put("if",new IfNodeHandler());
        //nodeHandlerMap.put("where",new WhereNodeHandler());
        //nodeHandlerMap.put("foreach",ForeachNodeHandler());
    }

    /**
     * 解析我们的Sql脚本
     *
     * @param element
     * @return
     */
    public SqlSource parseScriptNode(Element element) {
        // 将我们sq脚本总按照不同的类型，封装到不同的SqlNode中
        MixedSqlNode rootSqlNode = parseDynamicTags(element);
        SqlSource sqlSource = null;
        if (isDynamic) {
            sqlSource = new DynamicSqlSource(rootSqlNode);
        } else {
            sqlSource = new RawSqlSource(rootSqlNode);
        }

        // 由于带有#{}和${}、动态标签的sql处理方式不同，所以需要封装到不同的SqlSource中
        return sqlSource;
    }

    /**
     * 解析子标签
     *
     * @param element
     * @return
     */
    private MixedSqlNode parseDynamicTags(Element element) {

        List<SqlNode> contexts = new ArrayList<>();

        int count = element.nodeCount();
        for (int i = 0; i < count; i++) {

            Node node = element.node(i);
            if (node instanceof Text) {
                String trimSqlText = node.getText().trim();
                TextSqlNode textSqlNode = new TextSqlNode(trimSqlText);
                if (textSqlNode.isDynamicNode()) {
                    contexts.add(textSqlNode);
                    isDynamic = true;
                } else {
                    contexts.add(new StaticTextSqlNode(trimSqlText));
                }
            }else if (node instanceof Element){
                //如果仍存在标签则递归解析 if/where/foreach/set等动态sql字标签
                String nodeName = node.getName().toLowerCase();

                NodeHandler nodeHandler = nodeHandlerMap.get(nodeName);

                Element nodeToHandle = (Element) node;
                nodeHandler.handleNode(nodeToHandle,contexts);
                //
                isDynamic = true;
            }


        }


        return new MixedSqlNode(contexts);
    }



    public class IfNodeHandler implements NodeHandler{

        @Override
        public void handleNode(Element nodeToHandle, List<SqlNode> targetContents) {

            // 对if标签进行解析
            MixedSqlNode rootSqlNode = parseDynamicTags(nodeToHandle);

            String test = nodeToHandle.attributeValue("test");
            IfSqlNode ifSqlNode = new IfSqlNode(test, rootSqlNode);
            targetContents.add(ifSqlNode);
        }
    }
}
