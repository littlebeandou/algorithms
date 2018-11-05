package tree;

/**
 * @author xiaoqiang
 * @date 2018-11-05 20
 */
public class TreeTest {
    public static void main(String[] args) {
        ArrayTreeNode[] arrayTreeNodes = new ArrayTreeNode[9];
        ArrayTreeNode arrayTreeNode0 = new ArrayTreeNode(8, -1, null);
        arrayTreeNodes[0] = arrayTreeNode0;
        ArrayTreeNode arrayTreeNode1 = new ArrayTreeNode(3, 0, null);
        arrayTreeNodes[1] = arrayTreeNode1;
        ArrayTreeNode arrayTreeNode2 = new ArrayTreeNode(10, 0, null);
        arrayTreeNodes[2] = arrayTreeNode2;

        ArrayTreeNode arrayTreeNode3 = new ArrayTreeNode(1, 1, null);
        arrayTreeNodes[3] = arrayTreeNode3;

        ArrayTreeNode arrayTreeNode4 = new ArrayTreeNode(6, 1, null);
        arrayTreeNodes[4] = arrayTreeNode4;

        ArrayTreeNode arrayTreeNode5 = new ArrayTreeNode(4, 4, null);
        arrayTreeNodes[5] = arrayTreeNode5;

        ArrayTreeNode arrayTreeNode6 = new ArrayTreeNode(7, 4, null);
        arrayTreeNodes[6] = arrayTreeNode6;

        ArrayTreeNode arrayTreeNode7 = new ArrayTreeNode(14, 2, null);
        arrayTreeNodes[7] = arrayTreeNode7;

        ArrayTreeNode arrayTreeNode8 = new ArrayTreeNode(13, 7, null);
        arrayTreeNodes[8] = arrayTreeNode8;

        for (ArrayTreeNode arrayTreeNode : arrayTreeNodes) {
            System.out.println("===========================================");
            System.out.println("arrayTreeNode = " + arrayTreeNode);
            System.out.println("data = "+arrayTreeNode.getData());
            int parentIndex = arrayTreeNode.getParentIndex();
            if (parentIndex != -1)
                System.out.println("parentNodes : "+arrayTreeNodes[parentIndex]);
            System.out.println();
        }

    }
}
