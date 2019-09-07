package test.xiecheng.test1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int K,int[] A) {
        ArrayList<Integer> cells = new ArrayList<>();
        int cell = 0;
        int max = findMaxAvg(K,A);
        for (int i = 0; i < A.length; i++) {
            if (cell > max){
                cells.add(cell);
                cell = 0;
            }
            cell += A[i];
        }
        return cells.stream().mapToInt(x->x).summaryStatistics().getMax();
    }
    static int findMaxAvg(int K,int[] A) {
        /**
         dp[i][k]表示前i个数构成k个子数组时的最大平均值, 那么对于所有 0 <= j <= i-1
         dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + (A[j+1] + ... + A[i+1]) / (i-j))
         **/
        int [][] dp = new int[A.length+1][K+1];
        // 额外记录一个sum数组保存到前i个数的和, 便于计算(A[j+1] + ... + A[i+1]) / (i-j)
        int [] sum = new int[A.length+1];

        for(int i = 1; i <= A.length; ++i) {
            sum[i] = sum[i-1] + A[i-1];
            dp[i][1] = sum[i] / i;
        }
        for(int i = 1; i <= A.length; ++i) {
            for(int k = 2; k <= K; ++k) {
                for(int j = 0; j < i; ++j) {
                    dp[i][k] = Math.min(dp[i][k], dp[j][k-1] + (sum[i]-sum[j]) / (i-j));
                }
            }
        }

        return dp[A.length][K];


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
