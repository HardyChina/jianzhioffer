package test.liantong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 10592
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
        increment(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i!=arr.length-1) {
                System.out.print(",");
            }
        }
    }


    private static boolean increment( int[] arr){
        //位数
        boolean finished = false;
        int nTakeOver = 0;
        // 每循环一次，i所在的位数进行一次加1运算，每次都从第一位加起
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + nTakeOver;
            // 只有个位时+1
            if (i == arr.length-1){
                sum++;
            }

            if (sum >= 10){
                // 最高位+1时完成
                if (i == 0){
                    finished = true;
                }
                else {
                    // 进位操作
                    sum -= 10;
                    nTakeOver = 1;
                    arr[i] = sum;
                }
            }
            else {
                arr[i] = sum;
                break;
            }

        }
        return finished;

    }

}
