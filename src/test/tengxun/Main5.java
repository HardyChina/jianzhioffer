package test.tengxun;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
           b[i]= sc.nextInt();
        }
        int[] sum = new int[n*n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[index++] = a[i]+b[j];
            }
        }
        int result = sum[0];
        for (int i = 1; i < sum.length; i++) {
           result ^= sum[i];
        }
        System.out.println(result);
    }
}
