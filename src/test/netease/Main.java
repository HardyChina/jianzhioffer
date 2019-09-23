package test.netease;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n = 4;
            int[] A = new int[n];
            int[] B = new int[n];
            for (int j = 0; j< n; j++) {
                A[i] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                B[i] = sc.nextInt();
            }
            System.out.println(A[0]);
        }
    }
}
