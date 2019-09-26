package test.pdd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 10592
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            if (m == 0) {
                System.out.print(0);
            }
            list.sort(Integer::compareTo);

            int sum = 0;
            for (int i = 0, j = m * 2 - 1; i < m && j >= m; i++, j--) {
                sum += list.get(i) * list.get(j);
            }
            System.out.print(sum);


        }
    }

}
