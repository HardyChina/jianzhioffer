package test.tengxun;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][2];
        for (int i = 0; i < n; i++) {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
        }
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = num[i][1];
        }
        int max = Arrays.stream(y).max().getAsInt();
        int min = Arrays.stream(y).min().getAsInt();
        System.out.println(max + min);
    }
}
