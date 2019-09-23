package test.tengxun;

import java.util.Scanner;

/**
 * @author 10592
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0;
        int n = 0;
        boolean flag = true;
            t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                n = sc.nextInt();
                String s = sc.next();
                if (n!=s.length()){
                    System.out.println("NO");
                    continue;
                }
                if (n<11||s.length() <11){
                    System.out.println("NO");
                }else {
                    int num = -1;
                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j)=='8'){
                            num = j;
                            break;
                        }
                    }
                    if (num < 0){
                        System.out.println("NO");
                        continue;
                    }
                    flag = (n - num) < 11 ? false:true;
                    if (flag){
                        System.out.println("YES");
                    }else {
                        System.out.println("NO");
                    }
                }

            }

        }
    }

