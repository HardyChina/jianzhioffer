package test.yuanfudao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;

        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            if (m == 0 && n == 0){
                System.out.println();
            }
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            print(arr);
        }
    }
    public static void print(int[][] arr){
        if (arr == null){
            System.out.println();
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int start = 0;
        while (rows > start * 2&& cols> start* 2){
            printCycle(arr,start);
            start++;
        }

    }
    public static void printCycle(int[][] arr, int start){
        int endRow = arr.length - start - 1;
        int endCol = arr[0].length - start - 1;
        // 从上往下
        if (start <= endRow) {
            for (int i = start; i <= endRow; i++) {
                System.out.print(arr[i][start]);
                System.out.print(" ");
            }
        }
        // 从左往右
        if (start < endCol){
            for (int i = start + 1; i <=endCol; i++) {
            System.out.print(arr[endRow][i]);
                System.out.print(" ");
        }
        }

        // 从下往上
        if (start<endRow && start < endCol){
            for (int i = endRow - 1; i >= start ; i--) {
                System.out.print(arr[i][endCol]);
                System.out.print(" ");
            }
        }

        // 从右往左
        if (start < endCol && start < endRow -1) {
            for (int i = endCol - 1; i > start; i--) {
                System.out.print(arr[start][i]);
                System.out.print(" ");
            }
        }
    }
}
