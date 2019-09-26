package test.pdd;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] project = new int[m][2];
        for (int i = 0; i < m; i++) {
            project[i][0] = sc.nextInt();
            project[i][1] = sc.nextInt();
        }
        boolean[] flag = new boolean[n];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = false;
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = project[i][0]-1; j <= project[i][1] - 1 ; j++) {
                flag[j] = true;
            }
            for (int j = 0; j < flag.length; j++) {
                if (flag[j]){
                    sum++;
                }
            }
            System.out.println(sum);
            sum = 0;
        }

    }
}
