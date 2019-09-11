package fenzhi;

import java.io.*;
import java.util.*;

/**
 * @author xiaoqiang
 * @date 2018-10-23 21
 * 测试结果: 你好,我好
 * 分支1,创建了
 * 随机生成50万个随机数, 采用插入排序和分支排序对其进行排序
 * 插入排序耗时:43.88s
 * 分治排序耗时(分治排序阈值为100):0.14s
 * 分治排序耗时(分治排序阈值为1000):0.24s
 * 快速排序耗时: 0.245s
 * ----------------------------------------------
 * 随机生成500万个随机数, 采用插入排序和分支排序对其进行排序
 * 分治排序耗时(分治排序阈值为100):0.55s
 * 分治排序耗时(分治排序阈值为1000):0.85s
 * 快速排序耗时: 0.912s
 * <p>
 * 从测试结果可以看出, 分治排序的时间复杂度小于O(n), 为O(log(n))
 */
public class DivideMergeSort {


    public static final int SIZE = 50;
    public static final int THRESHOLD = 16;

    public static void main(String[] args) {
//        createData();
        int[] data = readData();
        int[] data1 = readData();
        /*for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();*/
        long t0 = System.currentTimeMillis();
        fastSort(data, 0, data.length - 1);
        long t1 = System.currentTimeMillis();
//        insertSort(data1, 0, data1.length - 1);
        baseSort(data1);
        long t2 = System.currentTimeMillis();

        System.out.println("t1-t0 = " + (t1 - t0));
        System.out.println("t2-t1 = " + (t2 - t1));
        for (int i = 0; i < data1.length; i++) {
            System.out.print(data1[i] + " ");
        }
        System.out.println();

        checkSort(data);
        checkSort(data1);
        System.out.println(data[0]);
        System.out.println(data[data.length - 1]);

        /*long t0 = System.currentTimeMillis();
//        int[] sortData = insertSort(data);
        long t1 = System.currentTimeMillis();
        int[] sortData1 = divideSort(data);
        long t2 = System.currentTimeMillis();
        System.out.println(data[3]);
        long t3 = System.currentTimeMillis();
        Arrays.sort(data);
        long t4 = System.currentTimeMillis();
//        System.out.println("插入排序耗时: " + (t1 - t0));
        System.out.println("分治排序耗时: " + (t2 - t1));
        System.out.println("分治排序耗1时: " + (t4 - t3));*/

    }

    private static void checkSort(int[] src) {
        boolean flag = true;
        if (src != null && src.length > 1) {
            for (int i = 1; i < src.length; i++) {
                if (src[i] < src[i - 1]) {
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("sorted!");
        } else {
            System.out.println("not sorted!");
        }
    }

    /**
     * 随机生成100万个范围为0~1000的随机数, 并将其保存到txt文档中
     */
    public static void createData() {
        File file = new File("F:\\data.txt");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
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
//        if (!file.exists()) {
        createData();
//        }
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

    private static Random random = new Random();

    public static void fastSort(int[] src, int start, int end) {
        if (src == null || src.length <= 1 || start < 0 || end > src.length - 1 || end <= start + 1) {
            return;
        }

        int len = end - start + 1;
        if (len < 400) {
            insertSort(src, start, end);
            return;
        }

        //计算用于划分的基准值,从数组中取五个不同的值,取中间数作为基准值
        int size = 15;
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int nextInt = random.nextInt(len);
            list.add(src[start + nextInt]);
        }

        Collections.sort(list);
        int base = list.get(size >> 1);
//        System.out.println("base = " + base);

        int mid = start;
        int endIndex = end;
        int count = 0;
        for (int i = start; i < end + 1; i++) {

            if (src[i] > base) {
                int temp = src[i];
                boolean flag = false;
                for (int j = endIndex; j > i; j--) {
                    endIndex--;
                    if (src[j] <= base) {
                        //找到<=base的数,将两者进行调换,mid下标之前(包含mid)的元素都小于等于base
                        mid = i;
                        src[i] = src[j];
                        src[j] = temp;
                        flag = true;
                        count++;
                        break;
                    }
                }
                //如果找不到需要调换的元素,说明已经完成调换了,跳出整个循环
                if (!flag) {
                    break;
                }

            } else {
                mid = i;
            }
        }
//        System.out.println("count = " + count);
        if (count < (len >> 3)) {
//            System.out.println("len1 = " + len);
            insertSort(src, start, mid);
            insertSort(src, mid + 1, end);
        } else {
//            System.out.println("len2 = " + len);
            fastSort(src, start, mid);
            fastSort(src, mid + 1, end);
        }

    }

    private static void insertSort(int[] src, int start, int end) {
        if (src == null || src.length <= 1 || start < 0 || end >= src.length || end <= start + 1) {
            return;
        }
        for (int i = start + 1; i <= end; i++) {
            int startIndex = i;
            for (int j = start; j < i; j++) {
                if (src[i] < src[j]) {
                    startIndex = j;
                    break;
                }
            }
            if (startIndex < i) {
                int temp = src[i];
                for (int k = i; k > startIndex; k--) {
                    src[k] = src[k - 1];
                }
                src[startIndex] = temp;
            }
        }
    }

    /**
     * 基数排序
     */
    public static void baseSort(int[] src) {
        int max = src[0];
        for (int i = 0; i < src.length; i++) {
            if (src[i] > max) {
                max = src[i];
            }
        }
        int count = 0;
        while (max > 0) {
            max = max / 10;
            count++;
        }
        for (int i = count; i >= 0; i--) {
            baseSort(src, i);
        }

    }

    /**
     * 当position为0时,代表对各位进行排序,为1时代表对十位进行排序,以此类推
     *
     * @param src
     * @param position
     */
    public static void baseSort(int[] src, int position) {
        int length = src.length;
        int capacity = length >> 4;
        ArrayList<Integer> list0 = new ArrayList<>(capacity);
        ArrayList<Integer> list1 = new ArrayList<>(capacity);
        ArrayList<Integer> list2 = new ArrayList<>(capacity);
        ArrayList<Integer> list3 = new ArrayList<>(capacity);
        ArrayList<Integer> list4 = new ArrayList<>(capacity);
        ArrayList<Integer> list5 = new ArrayList<>(capacity);
        ArrayList<Integer> list6 = new ArrayList<>(capacity);
        ArrayList<Integer> list7 = new ArrayList<>(capacity);
        ArrayList<Integer> list8 = new ArrayList<>(capacity);
        ArrayList<Integer> list9 = new ArrayList<>(capacity);
        //todo 取余有待改进
        int mod = (int) Math.pow(10, position);
        for (int i = 0; i < length; i++) {
            int num = src[i];
            if (num % mod == 0) {
                list0.add(num);
            } else if (num % mod == 1) {
                list1.add(num);
            } else if (num % mod == 2) {
                list2.add(num);
            } else if (num % mod == 3) {
                list3.add(num);
            } else if (num % mod == 4) {
                list4.add(num);
            } else if (num % mod == 5) {
                list5.add(num);
            } else if (num % mod == 6) {
                list6.add(num);
            } else if (num % mod == 7) {
                list7.add(num);
            } else if (num % mod == 8) {
                list8.add(num);
            } else {
                list9.add(num);
            }
        }
        int size0 = list0.size();
        int size1 = list1.size();
        int size2 = list2.size();
        int size3 = list3.size();
        int size4 = list4.size();
        int size5 = list5.size();
        int size6 = list6.size();
        int size7 = list7.size();
        int size8 = list8.size();
        int size9 = list9.size();
        for (int i = 0; i < size0; i++) {
            src[i] = list0.get(i);
        }
        for (int i = 0; i < size1; i++) {
            src[size0 + i] = list1.get(i);
        }
        int size01 = size0 + size1;
        for (int i = 0; i < size2; i++) {
            src[size01 + i] = list2.get(i);
        }
        int size02 = size0 + size1 + size2;
        for (int i = 0; i < size3; i++) {
            src[size02 + i] = list3.get(i);
        }
        int size03 = size0 + size1 + size2 + size3;
        for (int i = 0; i < size4; i++) {
            src[size03 + i] = list4.get(i);
        }
        int size04 = size0 + size1 + size2 + size3 + size4;
        for (int i = 0; i < size5; i++) {
            src[size04 + i] = list5.get(i);
        }
        int size05 = size0 + size1 + size2 + size3 + size4 + size5;
        for (int i = 0; i < size6; i++) {
            src[size05 + i] = list6.get(i);
        }
        int size06 = size0 + size1 + size2 + size3 + size4 + size5 + size6;
        for (int i = 0; i < size7; i++) {
            src[size06 + i] = list7.get(i);
        }
        int size07 = size0 + size1 + size2 + size3 + size4 + size5 + size6 + size7;
        for (int i = 0; i < size8; i++) {
            src[size07 + i] = list8.get(i);
        }
        int size08 = size0 + size1 + size2 + size3 + size4 + size5 + size6 + size7 + size8;
        for (int i = 0; i < size9; i++) {
            src[size08 + i] = list9.get(i);
        }
        System.out.println();
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
