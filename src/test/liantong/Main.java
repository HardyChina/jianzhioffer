package test.liantong;

import java.util.Scanner;

/**
 * @author 10592
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n  = sc.nextInt();
        System.out.println(sum(n));
    }
    public static int sum(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return sum(n-1)+sum(n-2);


    }
}
