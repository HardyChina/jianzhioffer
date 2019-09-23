package test.netease;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(findMin(arr[i]));

        }


    }
    private static int findMin(int num){
        ArrayList<Integer> list = new ArrayList<>();
        if (num <= 9){
            return num;
        }
        int tem = 0;
        while (num > 0){
           if (num -9 >0){
               list.add(9);
               tem = num - 9;
           }else {
               list.add(tem);
           }
           num /= 10;
        }
        int n = 0;
        int index = 1;
        for (int i = 0; i < list.size(); i++) {
            n += list.get(i)*index;
            index *= 10;
        }
        return n;
    }
    private static int sum(int num){
        int sum = 0;
        while (num!=0){
            sum += num%10;
            num /= 10;
        }
        return sum;

    }
}
