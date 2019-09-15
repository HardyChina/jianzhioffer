package test.bilibili;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int a = 1;
            int x = 2 * n;
            int index = (int)Math.sqrt(x);

            for (int i = 2; i <= index; i++) {
                if (x%i==0){
                    double n2 = (i+x/i-1)/2;
                    double n1 = x/i - n2;
                    if (n1 < n2 && (int)n1==n1&& (int)n2 == n2){
                        if ((n1+n2)*(n2-n1+1)==x){
                            a++;
                        }
                    }
                }
            }
            System.out.println(a);
        }
    }
}
