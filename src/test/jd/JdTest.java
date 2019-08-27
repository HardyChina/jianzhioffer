package test.jd;

import java.util.*;

public class JdTest {
    public static void main(String[] args) {
        int n;
        int m;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                map.put(i,0);
            }
            for (int i = 0; i < m; i++) {
                // 男女
                int man = sc.nextInt();
                int woman = sc.nextInt();
                // 统计男对应的女
                map.put(man,map.get(man)+1);
            }
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            int a = 0;
            ArrayList<Integer> arrayToGone = new ArrayList<>();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (entry.getValue()!=0){
                   a++;
                   arrayToGone.add(entry.getKey());
                }


            }
            System.out.println(a);
            arrayToGone.stream().forEach(System.out::print);

        }

    }
}
