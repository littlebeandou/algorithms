package observer;

/**
 * @author xiaoqiang
 * @date 2019-04-22 14
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
