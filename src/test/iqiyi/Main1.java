package test.iqiyi;


import java.util.*;

public class Main1 {
    /**
     * 如果有x轮的话
     * 理论上每个人都能玩x次
     * 但是必须有x人当supervisor
     * x次的话,每个人能当supervisor的次数为x-a[i]
     * n*x-∑a[i]就是所有人除去必须的能打supervisor的次数
     * 如果n*x-∑a[i] >= x 那么就ok
     * (n-1)*x-∑a[i]>=0就好
     *x>=∑a[i] / (n-1)
     */

    public static void main(String[] args){
        new Task().solve();
    }

    static int N = 100000;
    static class Task{

        int n;
        int a[];
        Scanner sc  = new Scanner(System.in);

        public void solve() {
            n = sc.nextInt();
            a = new int[N+10];
            int ma = 0;
            for (int i = 1;i <= n;i++) {
                a[i] = sc.nextInt();
                ma = Math.max(ma,a[i]);
            }
            long ans;
            long sum = 0;
            for (int i = 1;i <= n;i++) {sum += a[i];}
            if (sum%(n-1)==0) {
                ans = sum/(n-1);
            }else {
                ans = sum/(n-1) + 1;
            }
            ans = Math.max(ans, ma);
            System.out.println(ans);
        }
    }

}