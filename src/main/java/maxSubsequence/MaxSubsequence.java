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
            long maxSumI = src[i];
            long sumI = src[i];
            int startIndexI = i;
            int endIndexI = i;

            for (int j = i + 1; j < len; j++) {
                sumI += src[j];
                if (sumI > maxSumI){
                    maxSumI = sumI;
                    endIndexI = j;
                }
            }

            if (maxSumI > maxSum){
                maxSum = maxSumI;
                startIndex = startIndexI;
                endIndex = endIndexI;
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("maxSum", maxSum);
        int[] subArr = Arrays.copyOfRange(src, startIndex, endIndex + 1);
        map.put("subArr", subArr);
        return map;
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
