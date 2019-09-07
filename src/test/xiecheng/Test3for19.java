package test.xiecheng;

import java.util.Scanner;

public class Test3for19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            long num = scanner.nextLong();
            int count = 0;
            while (num != 0){
                    count++;
                    num = num & (num - 1);
            }
            System.out.println(count);
        }
    }
}
