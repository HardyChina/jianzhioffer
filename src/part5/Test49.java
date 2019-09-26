package part5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10592
 */
public class Test49 {
    public  static int GetUglyNumber_Solution(int index) {
        if (index < 7){
            return index;
        }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int t2 = 0,t3 = 0,t5 = 0,i= 1;
        while (i < index){
            res.add(min(res.get(t2)*2,res.get(t3)*3,res.get(t5)*5)) ;
            if (res.get(i) == res.get(t2)*2) {
                t2++;
            }
            if (res.get(i) == res.get(t3)*3){
                t3++;
            }
            if (res.get(i) == res.get(t5)*5){
                t5++;
            }
            i++;
        }
        return res.get(res.size()-1);
    }
    public static int min(int n1, int n2 ,int n3){
        int tem = n1 > n2 ? n2 : n1;
        return tem > n3 ? n3 : tem;

    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1500));
    }
}

