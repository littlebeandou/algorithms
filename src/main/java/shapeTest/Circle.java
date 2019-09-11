package shapeTest;

/**
 * @author xiaoqiang
 * @date 2019-05-02 12
 */
public class Circle extends Shape {
    Circle(int i) {
        super(i);
        System.out.println("drawing circle");
    }

    void dispose() {
        System.out.println("erasing circle");
        super.dispose();
    }
}
