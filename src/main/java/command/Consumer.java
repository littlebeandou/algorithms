package command;

/**
 * @author xiaoqiang
 * @date 2019-04-24 20
 */
public class Consumer {
    ICommand command;

    public Consumer(ICommand command) {
        this.command = command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void consume() {
        command.execute();
    }
}
