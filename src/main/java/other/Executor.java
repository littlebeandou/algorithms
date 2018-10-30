package other;

public class Executor {
    private static Integer a;

    public Executor(Integer a) {
        this.a = a;
    }

    public static Boolean evaluate(Integer threshold) {
        if (a > threshold)
            return true;
        return false;
    }
}