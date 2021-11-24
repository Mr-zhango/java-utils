package cn.myfreecloud.javautils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author zhangyang2.zhang
 * @since 2021-11-24
 */
public class DoubleTest {

    private static double minNumber = 0.000001;

    private static double zeroNumber = 0d;

    private static double thisYear = 123.66;

    private static double baseYear = 500.33;

    public static void main(String[] args) {
        Double doubleNumber = new Double(123456.33845);

        DecimalFormat format = new DecimalFormat("###,####.##");

        System.out.println(format.format(doubleNumber));
        System.out.println("***************************************");
        Double doubleNumber2222 = new Double(0.00);

        System.out.println(format.format(doubleNumber2222));

        System.out.println(calcDiffAndRate(thisYear, baseYear));
    }

    /**
     * 计算差值、比率
     *
     * @param baseValue 基准值
     * @param afterValue 变动值
     */
    private static Double calcDiffAndRate(double afterValue, double baseValue) {
        if (baseValue < minNumber) {
            return zeroNumber;
        } else {
            return new BigDecimal(afterValue).subtract(new BigDecimal(baseValue)).multiply(new BigDecimal(100)).divide(new BigDecimal(baseValue), 2, RoundingMode.HALF_UP).doubleValue();
        }
    }
}

