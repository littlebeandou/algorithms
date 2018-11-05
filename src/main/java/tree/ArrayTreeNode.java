package tree;

import java.util.List;

/**
 * @author xiaoqiang
 * @date 2018-11-05 20
 * ArrayTreeNode, 用数组表示树
 */
public class ArrayTreeNode {

    private Object data;    //用于存储数据
    private int parentIndex;    //用于存储父节点的下标
    private List<Integer> childIndexs;

    public ArrayTreeNode(Object data, int parentIndex, List<Integer> childIndexs) {
        this.data = data;
        this.parentIndex = parentIndex;
        this.childIndexs = childIndexs;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }

    public List<Integer> getChildIndexs() {
        return childIndexs;
    }

    public void setChildIndexs(List<Integer> childIndexs) {
        this.childIndexs = childIndexs;
    }

    @Override
    public String toString() {
        return "ArrayTreeNode{" +
                "data=" + data +
                ", parentIndex=" + parentIndex +
                ", childIndexs=" + childIndexs +
                '}';
    }
}
