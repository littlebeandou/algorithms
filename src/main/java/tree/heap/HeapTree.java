package tree.heap;

import tree.Node;

/**
 * @author xiaoqiang
 * @date 2018-12-24 19
 */
public class HeapTree<T extends Comparable<T>> {
    private static final Integer DEFAULT_CAPACITY = 32;
    private Integer maxSize = 0;
    private Node<T>[] nodeArray = null;
    private Integer size = 0;

    public HeapTree() {
        this.maxSize = DEFAULT_CAPACITY;
        this.nodeArray = new Node[this.maxSize];
    }

    public HeapTree(int capacity) {
        this.maxSize = capacity;
        this.nodeArray = new Node[this.maxSize];
    }

    public HeapTree(T data) {
        this.maxSize = DEFAULT_CAPACITY;
        this.nodeArray = new Node[this.maxSize];
        Node<T> newNode = new Node<>(data);
        nodeArray[0] = newNode;
        this.size = 1;
    }

    public HeapTree(T data, int capacity) {
        this.maxSize = capacity;
        this.nodeArray = new Node[this.maxSize];
        Node<T> newNode = new Node<>(data);
        nodeArray[0] = newNode;
        this.size = 1;
    }

    public Boolean add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.size == nodeArray.length) {
            return false;
        }
        nodeArray[size++] = newNode;
        findAndSetParentNode(newNode, size);
        return true;
    }

    /**
     * 找到当前节点的父节点,并将当前节点设置为父节点的子节点
     *
     * @param newNode
     * @param size
     */
    private void findAndSetParentNode(Node<T> newNode, Integer size) {

    }

    private Integer[] getDeepAndIndex() {


        return null;
    }

    private Node<T> getFirstAvailableParentNode() {
        Integer deep = getDeep();
        int size = getSize();
        int lastFloorSize = size - pow(2, deep - 1) + 1;
        return null;
    }

    public Integer getSize() {
        if (nodeArray == null) {
            return 0;
        }
        return this.nodeArray.length;
    }

    public Integer getDeep() {
        Integer deep = 0;
        int size = getSize();
        if (size == 0) {
            return deep;
        }
        int num = 1;
        while (size > num - 1) {
            num = num * 2;
            deep++;
        }

        return deep;
    }


    private int pow(int x, Integer k) {
        int num = 1;
        if (k == 0) {
            return num;
        }
        if (k > 0) {
            for (int j = 1; j <= k; j++) {
                num = num * x;
            }
        }
        return num;
    }
}
