package decator;

/**
 * @author xiaoqiang
 * @date 2019-04-22 15
 */
public class DecorateTest {
    public static void main(String[] args) {
        Pancake roujiamo = new Roujiamo(Pancake.PancakeSize.SMALL);
        System.out.println("desc: " + roujiamo.getDesc() + ", price: " + roujiamo.getPrice());
        roujiamo = new FiredEgg(roujiamo);
        System.out.println("desc: " + roujiamo.getDesc() + ", price: " + roujiamo.getPrice());
        roujiamo = new FiredEgg(roujiamo);
        System.out.println("desc: " + roujiamo.getDesc() + ", price: " + roujiamo.getPrice());
    }
}
