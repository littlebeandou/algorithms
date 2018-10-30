package other;

import org.apache.commons.jexl3.*;

/**
 * @author xiaoqiang
 * @date 2018-10-30 10
 */
public class JexlTest {
    public static void main(String[] args) {
        JexlEngine engine = new JexlBuilder().create();
        JexlExpression expression = engine.createExpression("flag = e.evaluate(2)");
        JexlContext context = new MapContext();
        context.set("e", new Executor(new Integer(3)));
        context.set("flag", false);
        expression.evaluate(context);
        System.out.println("evaluate = " + context.get("flag"));
    }
}


