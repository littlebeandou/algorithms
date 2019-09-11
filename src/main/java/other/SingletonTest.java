package other;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaoqiang
 * @date 2019-03-19 20
 */
public class SingletonTest {

    public static final SingletonTest instance = new SingletonTest();
    private static AtomicInteger count = new AtomicInteger(0);


    private SingletonTest() {

    }
}
