package command;

/**
 * @author xiaoqiang
 * @date 2019-04-24 20
 */
public class LightCommand implements ICommand {

    Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
