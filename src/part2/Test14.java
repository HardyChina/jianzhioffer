package part2;

import static java.lang.Math.pow;

/**
 * 剪绳子
 * @author 李震寰
 */
public class Test14 {
    public static int maxProductAfterCutting_solution1(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }
        int[] products = new int[length + 1];
        // 当绳子长度小于等于3时，不剪的长度>剪后的长度乘积。当绳子长度>=4时，剪后的长度>=不剪的长度,因此需要以3为分界点，从4开始。
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= length ; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product){
                    max = product;
                }
                products[i] = max;

            }

        }
        max = products[length];
        return max;

    }

    /**
     * 使用贪心算法解决剪绳子的问题,当绳子长度大于5时，将绳子尽可能多的剪成三段，当长度为4时，剪成两段。
     * n大于等于5时，3(n - 3) >= 2(n - 2)
     * 为何要讨论3和2，理由同动态优化算法，当绳子长度小于等于3时，不剪的长度>剪后的长度乘积。当绳子长度>=4时，剪后的长度>=不剪的长度。
     * @param length
     * @return
     */
    public static int maxProductAfterCutting_solution2(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }
        // 3 的数量
        int timeOf3 = length / 3;
        // 当等于4时剪成2 * 2，3 + 1 = 4
        if (length - timeOf3 * 3 == 1){
            timeOf3--;
        }
        int timeOf2 = (length - timeOf3 * 3) / 2;
        return (int) (pow(3 , timeOf3 )*pow(2 ,timeOf2 ));
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting_solution1(8));
        System.out.println(maxProductAfterCutting_solution1(3));
        System.out.println(maxProductAfterCutting_solution2(8));
        System.out.println(maxProductAfterCutting_solution2(3));
    }
}
