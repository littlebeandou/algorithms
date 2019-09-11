package shapeTest;

/**
 * @author xiaoqiang
 * @date 2019-05-02 12
 */
public class Line extends Shape {

    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("drawing line: " + start + ", " + end);
    }

    void dispose() {
        System.out.println("erasing line");
        super.dispose();
    }
}
