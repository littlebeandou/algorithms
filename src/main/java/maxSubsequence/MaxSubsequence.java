package maxSubsequence;

/**
 * @author xiaoqiang
 * @date 2018-10-25 11
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 利用不同的算法求解最大子序列问题
 */
public class MaxSubsequence {

    private static final int THRESHOLD = 10;


    /**
     * 普通的穷举方法
     *
     * @param src
     * @return 返回map, 包括连续元素之和最大的子序列和最大连续和
     */
    public static Map<String, Object> exhaustiveMethod(int[] src) {
        if (src == null || src.length == 0) {
            return null;
        }
        int len = src.length;
        long maxSum = src[0];
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < len; i++) {
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

        Map<String, Object> map = new HashMap<>();
        map.put("maxSum", maxSum);
        int[] subArr = Arrays.copyOfRange(src, startIndex, endIndex + 1);
        map.put("subArr", subArr);
        return map;
    }

    /**
     * 利用分治策略实现最大连续和的子序列查找
     *
     * @param src
     * @param leftIndex,  数组的左索引, 必须大于0
     * @param rightIndex, 数组的右索引, 必须小于数组的长度
     * @return
     */
    public static Map<String, Object> divideMergeMethod(int[] src, int leftIndex, int rightIndex) {
        if (src == null || src.length == 0) {
            return null;
        }

        int len = src.length;
        if (leftIndex < 0 || rightIndex >= len || leftIndex >= rightIndex) {
            return null;
        }

        if (len < THRESHOLD)
            return exhaustiveMethod(src);

        int midIndex = (leftIndex + rightIndex + 1) / 2;
        int[] leftData = Arrays.copyOfRange(src, leftIndex, midIndex);
        int[] rightData = Arrays.copyOfRange(src, midIndex, rightIndex + 1);

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {4, -3, 5, -2, -1, 2, 1, -2};
        Map<String, Object> map = exhaustiveMethod(arr);
        long maxSum = (long) map.get("maxSum");
        System.out.println("maxSum = " + maxSum);
        int[] subArr = (int[]) map.get("subArr");
        for (int i : subArr) {
            System.out.println("i = " + i);
        }
    }

}
