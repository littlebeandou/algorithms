package shapeTest;

/**
 * @author xiaoqiang
 * @date 2019-05-02 12
 */
public class Triangle extends Shape {
    Triangle(int i) {
        super(i);
        System.out.println("drawing triangle");
    }

    void dispose() {
        System.out.println("erasing triangle");
        super.dispose();
    }
}
