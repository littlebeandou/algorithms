package tree;

import java.util.List;

/**
 * @author xiaoqiang
 * @date 2018-11-05 20
 */
public class LinkedTreeNode {

    private Object data;    //用于存储数据
    private LinkedTreeNode parent;
    private List<LinkedTreeNode> children;

    public LinkedTreeNode(Object data, LinkedTreeNode parent, List<LinkedTreeNode> children) {
        this.data = data;
        this.parent = parent;
        this.children = children;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LinkedTreeNode getParent() {
        return parent;
    }

    public void setParent(LinkedTreeNode parent) {
        this.parent = parent;
    }

    public List<LinkedTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<LinkedTreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "LinkedTreeNode{" +
                "data=" + data +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }
}
