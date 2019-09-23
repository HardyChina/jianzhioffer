package test.netease;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = 0;
        for (int i = 1; i <n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]){
                    result += Math.abs(arr[i]-arr[j]);
                }
            }

        }
        System.out.println(result);
    }
}
