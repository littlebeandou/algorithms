package shapeTest;

/**
 * @author xiaoqiang
 * @date 2019-05-02 12
 */
public class CADSystem  extends Shape{

    private Circle circle;

    private Triangle triangle;

    private Line[] lines = new Line[3];

    CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j*j);
        }
        circle = new Circle(1);
        triangle = new Triangle(1);
        System.out.println("combined constructor");
    }

    public void dispose() {
        System.out.println("cad dispose");
        triangle.dispose();
        circle.dispose();
        for (int i = 0; i < lines.length; i++) {
            lines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem cadSystem = new CADSystem(47);
        try {

        } finally {
            System.out.println("=================");
            cadSystem.dispose();
        }
    }
}



