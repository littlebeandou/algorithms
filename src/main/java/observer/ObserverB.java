package observer;

/**
 * @author xiaoqiang
 * @date 2019-04-22 14
 */
public class ObserverB implements Observer {

    private Subject subject;

    public ObserverB(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String message) {
        System.out.println("B received a message: " + message);
    }


}
