package decator;

/**
 * @author xiaoqiang
 * @date 2019-04-22 15
 */
public class FiredEgg extends Condiment {

    Pancake pancake;

    public FiredEgg(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public double getPrice() {
        return pancake.getPrice() + 1.0;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + ", 煎蛋";
    }
}
