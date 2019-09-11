package command;

/**
 * @author xiaoqiang
 * @date 2019-04-24 20
 */
public class CommandTest {
    public static void main(String[] args) {
        LightCommand lightCommand = new LightCommand(new Light());
        Consumer consumer = new Consumer(lightCommand);
        consumer.consume();
        consumer.setCommand(new TvCommand(new TV()));
        consumer.consume();
    }
}
