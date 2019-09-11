package tree;

/**
 * @author xiaoqiang
 * @date 2018-12-22 15
 */
public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Tree() {
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    /**
     * 增
     *
     * @param data
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        add(data, root);
    }

    public void add(T data, Node<T> src) {
        Node<T> newNode = new Node<T>(data);
        if (src == null) {
            System.out.println("null point exception!");
            return;
        }
        T srcData = src.getData();
        if (data.compareTo(srcData) == 0) {
            return;
        }

        //添加到src节点的左子树中
        if (data.compareTo(srcData) < 0) {
            Node<T> leftChild = src.getLeftChild();
            if (leftChild == null) {
                src.setLeftChild(newNode);
                return;
            }
            add(data, leftChild);
            return;
        }

        if (data.compareTo(srcData) > 0) {
            Node<T> rightChild = src.getRightChild();
            if (rightChild == null) {
                src.setRightChild(newNode);
                return;
            }
            add(data, rightChild);
        }
    }

    /**
     * 查
     *
     * @param data
     * @return
     */
    public Boolean contains(T data) {
        Boolean flag = false;
        flag = contains(data, this.root);
        return flag;
    }

    private Boolean contains(T data, Node<T> src) {
        if (src == null) {
            return false;
        }
        T rootData = src.getData();
        if (data.compareTo(rootData) == 0) {
            return true;
        }
        //去左子树查找
        else if (data.compareTo(rootData) < 0) {
            Node<T> leftChild = src.getLeftChild();
            if (leftChild == null) {
                return false;
            }
            return contains(data, leftChild);
        }

        //去右子树查找
        else if (data.compareTo(rootData) > 0) {
            Node<T> rightChild = src.getRightChild();
            if (rightChild == null) {
                return false;
            }
            return contains(data, rightChild);
        } else {
            return false;
        }
    }

    /**
     * 删
     *
     * @param data
     * @return 返回null代表无指定的数据, 否则返回指定的data
     */
    public T delete(T data) {
        if (this.root == null) {
            return null;
        }
        T rootData = this.root.getData();
        if (data.compareTo(rootData) == 0) {
            this.root = null;
            return data;
        }

        Node<T> leftChild = this.root.getLeftChild();
        Node<T> rightChild = this.root.getRightChild();
        if (data.compareTo(rootData) < 0) {
            return delete(data, this.root, leftChild, 0);
        }
        return delete(data, this.root, rightChild, 1);
    }

    private T delete(T data, Node<T> parent, Node<T> child, int flag) {
        if (child == null) {
            return null;
        }
        T childData = child.getData();
        Node<T> leftChild = child.getLeftChild();
        Node<T> rightChild = child.getRightChild();
        if (data.compareTo(childData) == 0) {
            //子节点为叶子节点
            if (leftChild == null && rightChild == null) {
                if (flag == 0) {
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
                return data;
            }
            //子节点只有一个子节点
            if (leftChild != null && rightChild == null) {
                if (flag == 0) {
                    parent.setLeftChild(leftChild);
                } else {
                    parent.setRightChild(leftChild);
                }
                return data;
            }
            if (leftChild == null && rightChild != null) {
                if (flag == 0) {
                    parent.setLeftChild(rightChild);
                } else {
                    parent.setRightChild(rightChild);
                }
                return data;
            }
            //子节点有两个子节点
            Node<T> successor = getAndDeleteSuccessorFromLeft(parent, leftChild, 0);
            if (flag == 0) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(leftChild);
            successor.setRightChild(rightChild);
            return data;

        }
        if (data.compareTo(childData) < 0) {
            return delete(data, child, leftChild, 0);
        }
        return delete(data, child, rightChild, 1);
    }

    private Node<T> getAndDeleteSuccessorFromLeft(Node<T> grandParent, Node<T> parent, int flag) {
        Node<T> rightChild = parent.getRightChild();
        if (rightChild == null) {
            Node<T> successor = new Node<>(parent.getData());
            Node<T> leftChild = parent.getLeftChild();
            if (flag == 0) {
                grandParent.setLeftChild(leftChild);
            } else {
                grandParent.setRightChild(leftChild);
            }
            return successor;
        } else {
            return getAndDeleteSuccessorFromLeft(parent, rightChild, 1);
        }
    }

    /**
     * todo 树的遍历
     * @param displayType, 1: 中序遍历, 2: 前序遍历, 3: 后序遍历
     */
    public void display(int displayType){

    }

}
