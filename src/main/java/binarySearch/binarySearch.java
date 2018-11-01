package binarySearch;

import fenzhi.DivideMergeSort;

import java.util.Arrays;

/**
 * @author xiaoqiang
 * @date 2018-10-31 12
 */
public class binarySearch {

    public static final int THRESHOLD = 4;
    public static final int THRESHOLD1 = 16;

    public static void main(String[] args) {
        int[] src = DivideMergeSort.readData();
        Arrays.sort(src);
        int x = 990;
        long start = System.currentTimeMillis();
        int index = binarySearchMethod(src, x);
        for (int i = 0; i < 20000; i++) {
            binarySearchMethod(src, x);
        }
        System.out.println("二分查找耗时: " + (System.currentTimeMillis() - start));
        System.out.println("index = " + index);

        long start1 = System.currentTimeMillis();
        int index1 = orderSearch(src, x);
        System.out.println("顺序查找耗时: " + (System.currentTimeMillis() - start1));
        System.out.println("index1 = " + index1);

        long start2 = System.currentTimeMillis();
        int index2 = intelDivideSearch(src, 0, src.length - 1, x);
        for (int i = 0; i < 20000; i++) {
            intelDivideSearch(src, 0, src.length - 1, x);
        }
        System.out.println("智能二分查找耗时: " + (System.currentTimeMillis() - start2));
        System.out.println("index2 = " + index2);

    }

    /**
     * 利用二分法, 在已经排序号的数组中查找指定的元素x
     *
     * @param src
     * @param x
     * @return 返回指定元素在数组中的下标, 如果没有指定元素返回-1
     */
    public static int binarySearchMethod(int[] src, int x) {
        if (src == null || src.length == 0) {
            return -1;
        }
        return binarySearchMethod(src, 0, src.length - 1, x);
    }

    public static int binarySearchMethod(int[] src, int startIndex, int endIndex, int x) {
        int index = -1;
        if (endIndex - startIndex + 1 < THRESHOLD) {
            for (int i = startIndex; i <= endIndex; i++) {
                if (src[i] == x) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        int midIndex = (startIndex + endIndex) / 2;
        if (x <= src[midIndex]) {
            index = binarySearchMethod(src, startIndex, midIndex, x);
        } else {
            index = binarySearchMethod(src, midIndex + 1, endIndex, x);
        }
        return index;
    }

    /**
     * 顺序查找
     *
     * @param src
     * @param x
     * @return
     */
    public static int orderSearch(int[] src, int x) {
        if (src == null || src.length == 0) {
            return -1;
        }
        int index = -1;
        for (int i = 0; i < src.length; i++) {
            if (x == src[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 根据输入的值智能四分查找
     *
     * @param src
     * @param x
     * @return
     */
    public static int intelDivideSearch(int[] src, int startIndex, int endIndex, int x) {
        if (src == null || src.length == 0) {
            return -1;
        }

        if (x < src[startIndex] || x > src[endIndex]) {
            return -1;
        }

        int index = -1;
        if (endIndex - startIndex + 1 < THRESHOLD1) {
            for (int i = startIndex; i <= endIndex; i++) {
                if (src[i] == x) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        int space = (endIndex - startIndex + 1) >> 2;
        int mid1 = startIndex + space - 1;
        int mid2 = startIndex + space * 2 - 1;
        int mid3 = startIndex + space * 3 - 1;

        int start = startIndex;
        int end = startIndex;
        if (x <= src[mid1]) {
            end = mid1;
        } else if (x <= src[mid2]) {
            start = mid1 + 1;
            end = mid2;
        } else if (x <= src[mid3]) {
            start = mid2 + 1;
            end = mid3;
        } else {
            start = mid3 + 1;
            end = endIndex;
        }

        index = intelDivideSearch(src, start, end, x);
        return index;
    }
}
