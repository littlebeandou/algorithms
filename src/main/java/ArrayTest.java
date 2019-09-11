/**
 * @author xiaoqiang
 * @date 2018-12-08 16
 */
public class ArrayTest {
    public static void main(String[] args) {
        int sum = fn(5);
        System.out.println("sum = " + sum);

    }
    public static int fn(int n){
        if (n <= 1) {
            return n;
        } else {
            return n+fn(n-1);
        }
    }
}
