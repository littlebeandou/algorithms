package decator;

/**
 * @author xiaoqiang
 * @date 2019-04-22 15
 */
public class Roujiamo extends Pancake {

    private static final String ROUJIAMODESC = "肉夹馍";

    public Roujiamo(PancakeSize size) {
        this.size = size;
        if (this.size == PancakeSize.SMALL) {
            desc = "小份" + ROUJIAMODESC;
        } else if (this.size == PancakeSize.MID) {
            desc = "中份" + ROUJIAMODESC;
        } else {
            desc = "大份" + ROUJIAMODESC;
        }
    }

    public Roujiamo() {
        desc = "中份" + ROUJIAMODESC;
    }

    @Override
    public double getPrice() {
        if (this.size == PancakeSize.SMALL) {
            return 5.0;
        } else if (this.size == PancakeSize.MID) {
            return 6.0;
        } else {
            return 7.0;
        }
    }
}
