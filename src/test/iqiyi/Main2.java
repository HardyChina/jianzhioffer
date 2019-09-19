package test.iqiyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int m ,n;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < A.length; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                A[a] = b;
                int[] AA = new int[n/2];


            }
        }
    }
}
