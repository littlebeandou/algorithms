package observer;

/**
 * @author xiaoqiang
 * @date 2019-04-22 14
 */
public class ObserverA implements Observer {

    private Subject subject;

    public ObserverA(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String message) {
        System.out.println("A received a message: " + message);
    }
}
