package decator;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author xiaoqiang
 * @date 2019-04-22 15
 */
public abstract class Pancake {

    protected PancakeSize size = PancakeSize.MID;

    protected String desc = "this is not a concrete pancake";

    public String getDesc() {
        return desc;
    }

    public abstract double getPrice();

    public PancakeSize getSize() {
        return this.size;
    }

    public enum PancakeSize {
        SMALL, MID, BIG
    }
}
