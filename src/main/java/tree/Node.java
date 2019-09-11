package tree;

/**
 * @author xiaoqiang
 * @date 2018-12-22 14
 */
public class Node<T extends Comparable<T>> {
    private T data;
    private Integer index;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Integer index, Node<T> leftChild, Node<T> rightChild) {
        this.data = data;
        this.index = index;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public void add(Node<T> node, T data) {
        if (node == null){
            System.out.println("node节点不能为空");
            return;
        }

    }

}
