package test.pdd;

import java.util.*;

/**
 * @author 10592
 */
public class Main3 {
    private static Set<String> set = new TreeSet<>();
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                String str = bulidString(i, j);

                funcForAll(str.toCharArray(),0);
            }
        }
        String[] strs = new String[set.size()];
        set.toArray(strs);
        Arrays.sort(strs);
        System.out.println(strs[k-1]);
    }
    public static String bulidString(int n, int m){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append("a");
        }
        for (int i = 0; i < m; i++) {
            str.append("b");
        }
        return str.toString();

    }
    public static void funcForAll(char[] chars, int start){
        if (start == chars.length - 1){
            set.add(new String(chars));
        }else {
            for (int i = start;i<=chars.length-1;i++) {
                swap(chars, start, i);
                funcForAll(chars,start+1);
                swap(chars, start, i);
            }

        }

    }
    public static void swap(char[] chars, int i, int j){
        char tem = chars[i];
        chars[i] = chars[j];
        chars[j] = tem;
    }
}
