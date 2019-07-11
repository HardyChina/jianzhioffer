package part2;

/**
 * 二进制中1的个数
 * @author 李震寰
 */
public class Test15 {
    /**
     *可能会引起死循环的方法，不适用于负数
     * @return
     */
    public static int numberOf1MayError(int n){
        int count = 0;
        while (n != 0){
            if ((n & 1) == 1){
                count++;
            }
          n =  n >> 1;

        }
           return  count;
    }

    /**
     * 常规解法
     * @param n
     * @return
     */
    public static int numberOf1Normal(int n){
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((n & flag) > 0){
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    /**
     * 最佳解法
     * @param n
     * @return
     */
    public static int numberOf1(int n){
        int count = 0;
        while ( n != 0 ){
            count++;
            n = n & ( n - 1 );
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1MayError(9));
        System.out.println(numberOf1Normal(9));
        System.out.println(numberOf1(9));
    }
}
