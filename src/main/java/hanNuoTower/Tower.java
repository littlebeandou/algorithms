package hanNuoTower;

/**
 * @author xiaoqiang
 * @date 2018-12-10 20
 */
public class Tower {
    private static int count = 0;
    public static void main(String[] args) {
        int diskNum = 7;
        doTower(diskNum, "Tower_A", "Tower_B", "Tower_C");
        System.out.println("count = " + count);
    }

    private static void doTower(int diskNum, String tower_a, String tower_b, String tower_c) {
        if (diskNum == 1) {
            System.out.println("move " + diskNum + " from " + tower_a + " to " + tower_c);
            count++;
        }  else {
            doTower(diskNum - 1, tower_a, tower_c, tower_b);
            System.out.println("move " + diskNum + " from " + tower_a + " to " + tower_c);
            count++;
            doTower(diskNum - 1, tower_b, tower_a, tower_c);
        }
    }
}
