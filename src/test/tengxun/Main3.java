package test.tengxun;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int min = findMinNotZero(a);
            System.out.println(min);
            increase(a,min);

        }

    }
    public static int findMinNotZero(int[] a){
        int min = 0;
        int i = 0;
        for (; i < a.length; i++) {
            if (a[i]!=0){
                min = a[i];
                break;
            }
        }
        for (; i < a.length; i++) {
           if (a[i]< min && a[i]!=0){
               min = a[i];
           }
        }
        return min;
    }
    public static void increase(int[] arr,int x){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0) {
                arr[i] -= x;
            }
        }
    }

}
