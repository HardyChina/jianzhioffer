package part3;

/**
 * 数值的整数次方
 * @author 李震寰
 */
public class Test16 {
    /**
     * 返回数值的整数次方
     * @param base 底数
     * @param exponent 指数
     * @return
     */
    public static double power(double base, int exponent){
        if (base == 0.0 && exponent == 0){
            throw new RuntimeException("parameter Error");
        }
        //指数为0时，返回1
        if (exponent == 0){
            return 1;
        }
        //先取绝对值，在进行计算。最后在根据exponent的正负判断是否取倒数
        int exp = exponent;
        if (exponent < 0){
            exp = -exp;
        }
        double result = powerExector(base, exp);
//        double result = powerExector2(base, exp);
        //若exponent为负则取倒数
        if (exponent < 0){
            return 1 / result;
        }
        return result;

    }

    /**
     * 计算整数次方
     * @param base
     * @param exponent
     * @return
     */
    private static double powerExector(double base, int exponent){
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        double result = powerExector(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1){
            result *= base;
        }
        return result;
    }
    private static double powerExector2(double base, int exponent){
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(power(2, -4));
        System.out.println(power(2, 4));
        System.out.println(power(2, 0));
        System.out.println(power(0.00000000000000000000000000001, -1));
        System.out.println(power(0.00000000000000000000000000001, 1));
        System.out.println(power(0.00000000000000000000000000001, 0));
        System.out.println(power(0.00000000000000000000000000000, 0));

    }
}
