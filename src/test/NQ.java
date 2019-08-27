package test;

import java.util.*;

/**
 * 浪潮排序题，一个序列一次只能把一个数放到序列最前或最后，若要升序排列需要移动多少次
 * 思路，首先找到一个有问题的数字，即大于后边数字的数字。若该i-1 < i+1,则将该数字移动到序列最后，若i-1 > i+1，则将i+1移动到最前。
 */
public class NQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ;
        while (sc.hasNext()){
            n = sc .nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int j = 0;
            int moveNum = 0;
            while (j!=(n - 1)){
                // 此时将j移动到尾
                if (array[j] > array[j+1]){
                    if (j == 0 || array[j - 1] < array[j + 1]){
                        int tem = array[j];
                        for (int i = j; i < n-1; i++) {
                            array[i] = array[i+1];
                        }
                        array[n-1] = tem;
                        moveNum ++;

                    }
                    // 此时将j+1移动到头
                    else if (array[j-1] > array[j + 1]){
                        int tem = array[j+1];
                        for (int i = j+1; i > 0 ; i--) {
                            array[i] = array[i-1];
                        }
                        array[0] = tem;
                        moveNum++;

                    }

                    j = 0;
                }
                j++;
            }
            Arrays.stream(array).forEach(System.out::print);
            System.out.println();
            System.out.println(moveNum);

        }
    }

}
