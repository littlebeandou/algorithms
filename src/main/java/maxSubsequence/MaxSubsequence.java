package maxSubsequence;

/**
 * @author xiaoqiang
 * @date 2018-10-25 11
 */

import java.util.Arrays;
import java.util.Random;

/**
 * 利用不同的算法求解最大子序列问题
 */
public class MaxSubsequence {

    private static final int THRESHOLD = 100;


    /**
     * 普通的穷举方法
     *
     * @param src
     * @return 返回连续元素之和最大的子序列和的起止下标
     */
    public static int[] exhaustiveMethod(int[] src) {
        if (src == null || src.length == 0) {
            return null;
        }
        int len = src.length;
        long maxSum = src[0];
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < len; i++) {
            if (src[i] <= 0)
                continue;
            long sumI = src[i];
            for (int j = i + 1; j < len; j++) {
                sumI += src[j];
                if (sumI > maxSum) {
                    maxSum = sumI;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        return new int[]{startIndex, endIndex};
    }

    /**
     * 利用分治策略实现最大连续和的子序列查找
     *
     * @param src
     * @return
     */
    public static int[] divideMergeMethod(int[] src) {
        if (src == null || src.length == 0) {
            return null;
        }

        return divideMergeMethod(src, 0, src.length - 1);
    }

    /**
     * @param src
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public static int[] divideMergeMethod(int[] src, int leftIndex, int rightIndex) {
        if (src == null || src.length == 0) {
            return null;
        }

        int len = src.length;
        if (leftIndex < 0 || rightIndex >= len || leftIndex >= rightIndex) {
            return null;
        }

        if ((rightIndex - leftIndex + 1) < THRESHOLD)
            return exhaustiveMethod(src);


        int midIndex = (leftIndex + rightIndex) / 2;
        int[] left = Arrays.copyOfRange(src, leftIndex, midIndex + 1);
        int[] right = Arrays.copyOfRange(src, midIndex + 1, rightIndex + 1);
        int[] leftIndexs = divideMergeMethod(left, 0, left.length - 1);
        int[] rightIndexs = divideMergeMethod(right, 0, right.length - 1);

        return mergeLeftAndRight(left, leftIndexs, right, rightIndexs);
    }

    public static int[] mergeLeftAndRight(int[] left, int[] leftIndexs, int[] right, int[] rightIndexs) {
        int leftSum = sum(left, leftIndexs[0], leftIndexs[1]);
        int rightSum = sum(right, rightIndexs[0], rightIndexs[1]);
        int leftMidSum = 0;
        int leftMidMaxSum = 0;
        int leftMidIndex = 0;
        for (int i = left.length - 1; i >= 0; i--) {
            leftMidSum += left[i];
            if (leftMidSum > leftMidMaxSum) {
                leftMidMaxSum = leftMidSum;
                leftMidIndex = i;
            }
        }

        int rightMidSum = 0;
        int rightMidMaxSum = 0;
        int rightMidIndex = 0;
        for (int i = 0; i < right.length; i++) {
            rightMidSum += right[i];
            if (rightMidSum > rightMidMaxSum) {
                rightMidMaxSum = rightMidSum;
                rightMidIndex = i;
            }
        }

        int midSum = leftMidMaxSum + rightMidMaxSum;

        int leftIndex = leftIndexs[0];
        int rightIndex = leftIndexs[1];
        if (rightSum > leftSum) {
            leftIndex = left.length + rightIndexs[0];
            rightIndex = left.length + rightIndexs[1];
            if (midSum > rightSum) {
                leftIndex = leftMidIndex;
                rightIndex = rightMidIndex + left.length;
            }
        } else {
            if (midSum > leftSum) {
                leftIndex = leftMidIndex;
                rightIndex = rightMidIndex + left.length;
            }
        }

        return new int[]{leftIndex, rightIndex};
    }

    public static int sum(int[] src, int leftIndex, int rightIndex) {
        int sum = 0;
        for (int i = leftIndex; i <= rightIndex; i++) {
            sum += src[i];
        }
        return sum;
    }

    /**
     * 动态规划法, 时间复杂度为O(N)
     * 联机算法仅需要常量空间并以线性时间运行,
     * 联机算法只对数据进行一次扫描, 处理过的数据不需要再被记忆
     *
     * @param data
     * @return
     */
    public static int dynamicMethod(int[] data) {
        int maxSum = 0;
        int thisSum = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int tempIndex = 0;
        int flip = 0;
        for (int i = 0; i < data.length; i++) {
            thisSum += data[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
                rightIndex = i;
                if (flip == 1){
                    leftIndex = tempIndex;
                    flip = 0;
                }
            } else if (thisSum < 0) {
                thisSum = 0;
                flip = 1;
                tempIndex = i + 1;

            }
        }
        System.out.println(leftIndex + " : " +rightIndex);
        return maxSum;
    }

    public static void main(String[] args) {
        int size = 100000000;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
            int i1 = random.nextInt(2);
            if (i1 == 1)
                arr[i] = arr[i] * (-1);
        }
        /*long t1 = System.currentTimeMillis();
        int[] ints = exhaustiveMethod(arr);
        long t2 = System.currentTimeMillis();
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }*/
        long t3 = System.currentTimeMillis();
        int[] ints1 = divideMergeMethod(arr);
        long t4 = System.currentTimeMillis();
        for (int i : ints1) {
            System.out.println("i = " + i);
        }
        System.out.println("sum(arr, ints1[0], ints1[1]) = " + sum(arr, ints1[0], ints1[1]));

        long t5 = System.currentTimeMillis();
        int sum = dynamicMethod(arr);
        long t6 = System.currentTimeMillis();

        System.out.println("(t4-t3) = " + (t4 - t3));
        System.out.println("(t6-t5) = " + (t6 - t5));
        System.out.println("sum = " + sum);

//        System.out.println("(t2-t1) = " + (t2 - t1));
    }

}
