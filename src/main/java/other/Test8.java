package other;

public class Test8 extends Base {


    public String name = "dervied";

    public Test8() {
        super();
        tellName();
        System.out.println("son");
        printName();
    }

    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }

    public void printName() {
        System.out.println("Dervied print name: " + name);
    }

    public static void main(String[] args) {
        Base base = new Test8();
    }
}

class Base {

    public String name = "base";

    public Base() {
        tellName();
        System.out.println("parent");
        printName();
    }

    private void tellName() {
        System.out.println("Base tell name: " + name);
    }

    private void printName() {
        System.out.println("Base print name: " + name);
    }

    public static void printNameStatic() {
        System.out.println("Base print name: static");
    }
}
