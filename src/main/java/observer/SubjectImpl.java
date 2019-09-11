package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoqiang
 * @date 2019-04-22 14
 */
public class SubjectImpl implements Subject{

    private String message;

    List<Observer> observers;

    public SubjectImpl() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}
