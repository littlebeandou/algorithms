package hashMapCapacity;

import java.util.HashMap;

/**
 * @author xiaoqiang
 * @date 2018-11-29 17
 * 根据给定的元素个数,计算hashMap的初始化容量
 */
public class CalculateHashMapCapacity {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int hashMapCapacity = 0;
        for (int i = 0; i < 100000; i++) {
            hashMapCapacity = getHashMapCapacity(191, 0.75);
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("hashMapCapacity = " + hashMapCapacity);
        HashMap<String, String> stringStringHashMap = new HashMap<>(hashMapCapacity);
    }

    /**
     * 当已知hashMap的要存的数据数量,计算出HashMap的初始化容量大小
     *
     * @param dataNum
     * @return
     */
    public static int getHashMapCapacity(int dataNum) {
        if (dataNum <= 0) {
            return 2;
        }
        int capacity = dataNum * 4 / 3 + 1;
        int powTimes = 0;
        while (capacity > 0) {
            capacity = capacity >> 1;
            powTimes++;
        }
        capacity = (int) Math.pow(2.0, powTimes);
        return capacity;
    }

    public static int getHashMapCapacity(int dataNum, double loadFactor) {
        if (dataNum <= 0) {
            return 2;
        }
        int capacity = (int) (dataNum / loadFactor + 1);
        int powTimes = 0;
        while (capacity > 0) {
            capacity = capacity >> 1;
            powTimes++;
        }
        capacity = (int) Math.pow(2.0, powTimes);
        return capacity;
    }

}
