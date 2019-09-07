package test.alibaba;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (i%2==0){
                    area[i][j] = 0;
                }
            }

        }
       return shortestRoad1(area);
    }

    /**
     *
     * @param arr
     * @return
     */
    private static int shortestRoad1(int arr[][])
    {
        int dp[]=new int[arr[0].length];
        dp[0]=arr[0][0];
        for(int j=1;j<arr[0].length;j++)
        {
            dp[j]=dp[j-1]+arr[0][j];
            //求出第一行的dp
        }
        for(int i=1;i<arr.length;i++)
        {
            dp[0]=arr[i][0]+dp[0];
            //dp[0]代表每
            // 一行最左边的dp，
            //后一行的dp覆盖前一行的dp
            for(int j=1;j<arr[0].length;j++)
            {
                dp[j]=Math.min(dp[j-1]+arr[i][j], dp[j]+arr[i][j]);
            }
        }
        return dp[arr[0].length-1];
    }

}
