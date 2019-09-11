package command;

/**
 * @author xiaoqiang
 * @date 2019-04-24 20
 */
public class TvCommand implements ICommand {

    TV tv;

    public TvCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.show();
    }
}
