package test.Didi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNext()){
            n = sc.nextInt();
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Character> list2 = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='+'||chars[i]=='-'||chars[i]=='*'||chars[i] =='/'){
                    list2.add(chars[i]);
                }
                else {
                    list.add(Integer.valueOf(chars[i]));
                }
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i = i+2) {
                System.out.print(list.get(i));
                System.out.print(list2.get(i));
                System.out.print(list.get(i+1));

            }
        }
    }
}
