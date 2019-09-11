package observer;

/**
 * @author xiaoqiang
 * @date 2019-04-22 14
 */
public class ObserverTest {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        ObserverA observerA = new ObserverA(subject);
        ObserverB observerB = new ObserverB(subject);

        subject.setMessage("hello!");
        subject.setMessage("hello-1!");
        subject.removeObserver(observerB);
        subject.setMessage("hello-2!");
        subject.setMessage("hello-2!");
    }
}
