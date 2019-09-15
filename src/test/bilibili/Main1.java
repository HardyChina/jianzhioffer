package test.bilibili;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String word1 = sc.nextLine();
            String word2 = sc.nextLine();
            int m = word1.length();
            int n = word2.length();
            System.out.println(minChange(m,n,word1,word2));

        }
    }
    public static int minChange(int m, int n,String word1,String word2){
        if (m == 0 ||  n == 0){
            return Math.abs(m - n);
        }
        if (word1.charAt(m-1) == word2.charAt(n-1)){
            return  minChange(m-1, n-1,word1,word2);
        }
        else {
            return min(minChange(m,n-1,word1,word2)+1,minChange(m-1,n,word1,word2)+1,
                    minChange(m-1,n-1,word1,word2)+1);
        }
    }
    public static int min(int n1, int n2, int n3){
        List<Integer> list = new ArrayList<>(3);
        list.add(n1);
        list.add(n2);
        list.add(n3);
        Collections.sort(list);
        return list.get(0);

    }

}
