package polynomialCurve;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

/**
 * @author xiaoqiang
 * @date 2018-11-16 22
 */
public class PolynomialCurveTest {
    /**
     * 随后创建PolynomialCurveFitter对象，创建时要指定拟合多项式的阶数，
     * 注意阶数要选择适当，不是越高越好，否则拟合误差会很大。
     * 最后调用PolynomialCurveFitter的fit方法即可完成多项式曲线拟合，
     * fit方法的参数通过WeightedObservedPoints.toList()获得。
     * 拟合结果通过一个double数组返回，按元素顺序依次是常数项、一次项、二次项、……。
     *
     * @param args
     */
    public static void main(String[] args) {
        testLeastSquareMethodFromApache();

    }

    private static void testLeastSquareMethodFromApache() {
        final WeightedObservedPoints obs = new WeightedObservedPoints();
        double[] xs = {-3, -2, -1, 0, 1, 2, 3};
        obs.add(-3, 4);
        obs.add(-2, 2);
        obs.add(-1, 3);
        obs.add(0, 0);
        obs.add(1, -1);
        obs.add(2, -2);
        obs.add(3, -5);

        // Instantiate a third-degree polynomial fitter.
        final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3);
        // Retrieve fitted parameters (coefficients of the polynomial function).
        final double[] coeff = fitter.fit(obs.toList());
        for (double c : coeff) {
            System.out.println(c);
        }

        compute(xs, coeff);

    }

    public static void compute(double[] xArray, double[] params) {

        for (int i = 0; i < xArray.length; i++) {
            double y = 0;
            for (int j = 0; j < params.length; j++) {
                y += params[j] * Math.pow(xArray[i], j);
            }
            System.out.print(" " + y);
        }
    }
}
