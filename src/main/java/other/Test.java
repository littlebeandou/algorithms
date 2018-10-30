package other;

import org.apache.commons.jexl3.*;

/**
 * @author xiaoqiang
 * @date 2018-10-30 10
 */
public class Test {
    public static void main(String[] args) {
        JexlContext jc = new MapContext();
        String str = "一二三四五六七八九十";
        jc.set("Util", new Util());
        jc.set("str", str);
        jc.set("ans", "");
        String expression = "ans = Util.regMatch(\"[\u4e00-\u9fa5]{10,}\",str)";

        JexlExpression expression1 = new JexlBuilder().create().createExpression(expression);
        expression1.evaluate(jc);
        System.out.println(jc.get("ans"));

    }
}
