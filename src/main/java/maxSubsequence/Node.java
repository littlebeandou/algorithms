package maxSubsequence;

/**
 * 用于表示数组元素, index为数组元素下标, value为数组元素的值
 */
public class Node {
    int index;
    int value;

    public Node() {
    }

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}