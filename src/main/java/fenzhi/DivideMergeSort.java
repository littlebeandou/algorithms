package fenzhi;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author xiaoqiang
 * @date 2018-10-23 21
 * 测试结果:
 * 随机生成50万个随机数, 采用插入排序和分支排序对其进行排序
 * 插入排序耗时:43.88s
 * 分治排序耗时(分治排序阈值为100):0.14s
 * 分治排序耗时(分治排序阈值为1000):0.24s
 * ----------------------------------------------
 * 随机生成500万个随机数, 采用插入排序和分支排序对其进行排序
 * 分治排序耗时(分治排序阈值为100):0.55s
 * 分治排序耗时(分治排序阈值为1000):0.85s
 *
 * 从测试结果可以看出, 分治排序的时间复杂度小于O(n), 为O(log(n))
 */
public class DivideMergeSort {


    public static final int SIZE = 5000000;
    public static final int THRESHOLD = 100;

    public static void main(String[] args) {
//        createData();
        int[] data = readData();
//        long t0 = System.currentTimeMillis();
//        int[] sortData = insertSort(data);
        long t1 = System.currentTimeMillis();
        int[] sortData1 = divideSort(data);
        long t2 = System.currentTimeMillis();
//        System.out.println("插入排序耗时: " + (t1 - t0));
        System.out.println("分治排序耗时: " + (t2 - t1));
    }

    /**
     * 随机生成100万个范围为0~1000的随机数, 并将其保存到txt文档中
     */
    public static void createData() {
        File file = new File("F:\\data.txt");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            Random random = new Random();
            for (int i = 0; i < SIZE; i++) {
                int num = random.nextInt(10000);
                bufferedWriter.write(new String(num + ""));
                bufferedWriter.newLine();
                if (i % 50 == 0) {
                    bufferedWriter.flush();
                }
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从数据文件中读取随机数据, 并将其存入int数组中
     *
     * @return
     */
    public static int[] readData() {
        File file = new File("F:\\data.txt");
        if (!file.exists()) {
            createData();
        }
        int[] datas = new int[SIZE];
        BufferedReader reader = null;
        int i = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    break;
                }
                int num = Integer.parseInt(str);
                datas[i] = num;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datas;
    }

    /**
     * 运用插入排序对数组进行排序, 增序
     *
     * @param
     */
    public static int[] insertSort(int[] src) {
        if (src == null || src.length == 0) {
            return null;
        }
        if (src.length > 1) {
            for (int i = 1; i < src.length; i++) {
                int index = i;
                for (int j = 0; j < i; j++) {
                    if (src[i] < src[j]) {
                        index = j;
                        break;
                    }
                }
                if (index < i) {
                    int temp = src[i];
                    for (int k = i; k > index; k--) {
                        src[k] = src[k - 1];
                    }
                    src[index] = temp;
                }
            }
        }
        return src;
    }

    /**
     * 运用分治排序对数组进行排序, 增序
     *
     * @param
     */
    public static int[] divideSort(int[] src) {
        if (src == null || src.length == 0) {
            return null;
        }

        if (src.length < THRESHOLD) {
            return insertSort(src);
        }

        //对原始数据分为两个小数据进行排序
        int len = src.length;
        int mid = len / 2;
        //Arrays.copyOfRange不包括mid下标
        int[] left = Arrays.copyOfRange(src, 0, mid);
        int[] leftSorted = divideSort(left);
        int[] right = Arrays.copyOfRange(src, mid, len);
        int[] rightSorted = divideSort(right);

        //对排序后的子数据进行合并
        int[] merge = merge(leftSorted, rightSorted);
        return merge;
    }

    /**
     * 对两个已经增序排列的数组进行合并
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int lenLeft = left.length;
        int lenRight = right.length;
        int[] merge = new int[lenLeft + lenRight];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < merge.length; i++) {
            if (leftIndex < lenLeft && rightIndex < lenRight) {
                if (left[leftIndex] < right[rightIndex]) {
                    merge[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    merge[i] = right[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex >= lenLeft) {
                System.arraycopy(right, rightIndex, merge, i, lenRight - rightIndex);
                break;
            } else {
                System.arraycopy(left, leftIndex, merge, i, lenLeft - leftIndex);
                break;
            }
        }
        return merge;
    }


}
