package part4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author 10592
 */
public class Test38 {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || "".equals(str)){
            return list;
        }
         PermutationHelper(str.toCharArray(), list, 0);
        Collections.sort(list);
        return list;


    }


    private static void PermutationHelper(char[] chars,ArrayList<String> list,int i){
       if (i == chars.length -1){
           if (!list.contains(String.valueOf(chars))) {
               list.add(String.valueOf(chars));
           }
       }
       else {
           for (int j = i; j < chars.length; j++) {
               swap(chars,i,j);
               PermutationHelper(chars,list,i+1);
               swap(chars, i ,j);
           }
       }
    }

    private static void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Permutation("abc").forEach(System.out::println);
        Permutation("aabb").forEach(System.out::println);
    }
}

